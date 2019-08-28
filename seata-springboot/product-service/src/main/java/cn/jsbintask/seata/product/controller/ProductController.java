package cn.jsbintask.seata.product.controller;

import cn.jsbintask.seata.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019/3/28
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService storageService;

    @GetMapping(path = "/deduct")
    public Boolean deduct(String productCode, Integer count) {
        storageService.deduct(productCode, count);
        return true;
    }
}
