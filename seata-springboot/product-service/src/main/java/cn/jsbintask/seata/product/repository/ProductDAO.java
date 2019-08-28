package cn.jsbintask.seata.product.repository;

import cn.jsbintask.seata.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {

    Product findByProductCode(String productCode);

}
