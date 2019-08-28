package cn.jsbintask.seata.order.service;

import cn.jsbintask.seata.domain.Order;
import cn.jsbintask.seata.order.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Transactional(rollbackFor = Exception.class)
    public Order create(String userId, String commodityCode, Integer count) {

        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));

        Order order = new Order();
        order.setUserId(userId);
        order.setProductCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderDAO.saveAndFlush(order);
        return order;
    }

}
