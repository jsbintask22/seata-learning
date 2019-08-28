package cn.jsbintask.seata.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/26 15:32
 */

@Entity
@Table(name = "t_account_log")
@DynamicUpdate
@DynamicInsert
@Data
public class UserLog {
    private String userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createTime;
}
