package cn.jsbintask.seata.user.repository;

import cn.jsbintask.seata.domain.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/26 15:36
 */
@Repository
public interface AccountLogDAO extends JpaRepository<UserLog, Integer> {
}
