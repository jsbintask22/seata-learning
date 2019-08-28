package cn.jsbintask.seata.user.controller;

import cn.jsbintask.seata.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2017/12/25
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/debit")
    public Boolean debit(String userId, BigDecimal money) {
        // 处理业务操作失败情况
        if ("NO_MONEY".equalsIgnoreCase(userId)) {
            return false;
        }

        userService.debit(userId, money);

        return true;
    }

    @GetMapping("/saveLog")
    public Boolean saveLog(String userId) {
        userService.saveAcountLog(userId);

        return true;
    }
}
