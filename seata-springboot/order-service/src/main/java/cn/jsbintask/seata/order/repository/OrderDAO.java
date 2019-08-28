package cn.jsbintask.seata.order.repository;

import cn.jsbintask.seata.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
public interface OrderDAO extends JpaRepository<Order, Long> {

}
