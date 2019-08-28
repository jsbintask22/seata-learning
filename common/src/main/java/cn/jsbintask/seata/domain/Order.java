package cn.jsbintask.seata.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/28 11:19
 */
@Entity
@Table(name = "t_order")
@DynamicUpdate
@DynamicInsert
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "count")
    private Integer count;

    private Date createTime;

    private Date updateTime;
}
