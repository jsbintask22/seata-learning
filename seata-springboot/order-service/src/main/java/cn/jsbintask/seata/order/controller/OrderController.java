package cn.jsbintask.seata.order.controller;

import cn.jsbintask.seata.domain.Order;
import cn.jsbintask.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public Order create(String userId, String commodityCode, Integer count) {

        return orderService.create(userId, commodityCode, count);
    }

}
