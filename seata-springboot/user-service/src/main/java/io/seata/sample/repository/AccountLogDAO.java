package io.seata.sample.repository;

import io.seata.sample.entity.AccountLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/26 15:36
 */
@Repository
public interface AccountLogDAO extends JpaRepository<AccountLog, Integer> {
}
