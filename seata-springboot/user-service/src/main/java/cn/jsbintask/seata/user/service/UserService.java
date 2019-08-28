package cn.jsbintask.seata.user.service;

import cn.jsbintask.seata.domain.User;
import cn.jsbintask.seata.domain.UserLog;
import cn.jsbintask.seata.user.exception.SeataException;
import cn.jsbintask.seata.user.repository.AccountDAO;
import cn.jsbintask.seata.user.repository.AccountLogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019-08-11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AccountLogDAO accountLogDAO;

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        User user = accountDAO.findByUserCode(userId);
        user.setMoney(user.getMoney().subtract(num));
        accountDAO.save(user);

        // 模拟业务操作过程中 抛出 runtime exception
        if ("runtime_exception".equals(userId)) {
            throw new RuntimeException("user branch exception: =========RUNTIME EXCEPTION===========");
        }

        // 模拟业务操作过程中 抛出 自定义 seata exception
        if ("seata_exception".equals(userId)) {
            throw new SeataException("user branch exception: ======SEATA EXCEPTION=============");
        }
    }

    public void saveAcountLog(String userId) {
        UserLog userLog = new UserLog();
        userLog.setCreateTime(new Date());
        userLog.setUserId(userId);

        UserLog dbAccount = accountLogDAO.saveAndFlush(userLog);
        System.out.println(dbAccount);
    }
}
