package cn.jsbintask.seata.product.service;

import cn.jsbintask.seata.domain.Product;
import cn.jsbintask.seata.product.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Transactional(rollbackFor = Exception.class)
    public void deduct(String productCode, int count) {
        Product product = productDAO.findByProductCode(productCode);
        product.setCount(product.getCount() - count);

        productDAO.save(product);
    }
}
