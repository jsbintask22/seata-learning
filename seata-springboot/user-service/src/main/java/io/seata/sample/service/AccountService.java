package io.seata.sample.service;

import io.seata.sample.entity.Account;
import io.seata.sample.entity.AccountLog;
import io.seata.sample.exception.SeataException;
import io.seata.sample.repository.AccountDAO;
import io.seata.sample.repository.AccountLogDAO;
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
public class AccountService {

    private static final String ERROR_USER_ID = "U100001";
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountLogDAO accountLogDAO;

    @Transactional(rollbackFor = Exception.class)
    public void debit(String userId, BigDecimal num) {
        Account account = accountDAO.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountDAO.save(account);

        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception: =========RUNTIME EXCEPTION===========");
        }
        if (userId.equals("U100002")) {
            throw new SeataException("account branch exception: ======SEATA EXCEPTION=============");
        }
    }

    public void saveAcountLog(String userId) {
        AccountLog accountLog = new AccountLog();
        accountLog.setCreateTime(new Date());
        accountLog.setUserId(userId);

        AccountLog dbAccount = accountLogDAO.saveAndFlush(accountLog);
        System.out.println(dbAccount);
        if (ERROR_USER_ID.equals(userId)) {
            throw new SeataException("add account log error. " + userId);
        }
    }
}
