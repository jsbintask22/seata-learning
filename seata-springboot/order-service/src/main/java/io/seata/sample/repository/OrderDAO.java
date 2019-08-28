package io.seata.sample.repository;

import io.seata.sample.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
public interface OrderDAO extends JpaRepository<Order, Long> {

}
