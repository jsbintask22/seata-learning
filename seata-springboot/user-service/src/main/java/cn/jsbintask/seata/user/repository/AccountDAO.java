package cn.jsbintask.seata.user.repository;

import cn.jsbintask.seata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description：
 *
 * @author jsbintask@gmail.com
 * @date 2019/3/28
 */
public interface AccountDAO extends JpaRepository<User, Long> {

    User findByUserCode(String userCode);

}
