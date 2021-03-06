package cn.jsbintask.seata.business.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-04-04
 */
@FeignClient(name = "user-service", url = "127.0.0.1:8083")
public interface UserFeignClient {

    @GetMapping("/debit")
    Boolean debit(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);

    @GetMapping("/saveLog")
    Boolean saveAccountLog(@RequestParam("userId") String userId);
}
