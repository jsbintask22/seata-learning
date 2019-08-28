package cn.jsbintask.seata.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "t_user")
@DynamicUpdate
@DynamicInsert
@Data
public class User {

    @Id
    private Long id;
    private String userCode;
    private BigDecimal money;
    private String username;
}
