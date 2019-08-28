package cn.jsbintask.seata.business.controller;

import cn.jsbintask.seata.business.client.OrderFeignClient;
import cn.jsbintask.seata.business.client.ProductFeignClient;
import cn.jsbintask.seata.business.client.UserFeignClient;
import cn.jsbintask.seata.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class BusinessController {

    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;

    private ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

    /**
     * 购买下单，模拟全局事务回滚
     * 根据不同参数 回滚
     */
    @RequestMapping("/business/purchase")
    @GlobalTransactional
    public String purchaseRollback(String userid, String pid, Integer count, String param) {
        System.out.println(userid + " " + pid + " " + count);
        // 减库存
        productFeignClient.deduct(pid, count);

        // 下单
        Order order = orderFeignClient.create(userid, pid, count);
        log.info("下单成功: {}", order);

        // 模拟在事务期间 产生的脏数据  beforeimage 和 afterimage 不一样
        if ("dirty_data_test".equalsIgnoreCase(param)) {
            order.setUpdateTime(new Date(System.currentTimeMillis() + 60 * 60 * 1000L));
            orderFeignClient.update(order);
        }
        if ("dirty_data_async_test".equalsIgnoreCase(param)) {
            Future<?> future = threadPoolExecutor.submit(() -> {
                order.setUpdateTime(new Date(System.currentTimeMillis() + 60 * 60 * 1000L));
                Order update = orderFeignClient.update(order);
                log.info("异步更新成功: {}", update);
            });

            try {
                // 等待异步线程 执行更新 order， 产生脏数据
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 扣钱
        Boolean result = userFeignClient.debit(userid, order.getMoney());

        if (!result) {
            throw new RuntimeException("扣钱失败，余额不足！");
        }

        return "success";
    }
}
