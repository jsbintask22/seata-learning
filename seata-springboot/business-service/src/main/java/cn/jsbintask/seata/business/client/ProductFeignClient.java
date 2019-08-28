package cn.jsbintask.seata.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
@FeignClient(name = "product-service", url = "127.0.0.1:8081")
public interface ProductFeignClient {

    @GetMapping("/deduct")
    void deduct(@RequestParam("productCode") String productCode,
                @RequestParam("count") Integer count);

}
