package cn.jsbintask.seata.business.client;

import cn.jsbintask.seata.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
@FeignClient(name = "order-service", url = "127.0.0.1:8082")
public interface OrderFeignClient {

    @GetMapping("/create")
    Order create(@RequestParam("userId") String userId,
                 @RequestParam("commodityCode") String commodityCode,
                 @RequestParam("count") Integer count);

    @PostMapping("/update")
    Order update(@RequestBody Order order);
}
