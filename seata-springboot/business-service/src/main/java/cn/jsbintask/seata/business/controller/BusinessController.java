package cn.jsbintask.seata.business.controller;

import cn.jsbintask.seata.business.client.OrderFeignClient;
import cn.jsbintask.seata.business.client.ProductFeignClient;
import cn.jsbintask.seata.business.client.UserFeignClient;
import cn.jsbintask.seata.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 购买下单，模拟全局事务回滚
     * 根据不同参数 回滚
     */
    @RequestMapping("/business/purchase")
    @GlobalTransactional
    public String purchaseRollback(String userid, String pid, Integer count) {
        System.out.println(userid + " " + pid + " " + count);
        // 减库存
        productFeignClient.deduct(pid, count);

        // 下单
        Order order = orderFeignClient.create(userid, pid, count);

        // 扣钱
        Boolean result = userFeignClient.debit(userid, order.getMoney());

        if (!result) {
            throw new RuntimeException("扣钱失败，余额不足！");
        }

        return "success";
    }
}
