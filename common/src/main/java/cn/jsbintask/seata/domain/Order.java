package cn.jsbintask.seata.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/28 11:19
 */
@Entity
@Table(name = "t_order")
@DynamicUpdate
@DynamicInsert
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

    public Order() {
    }

    public Order(String userId, String productCode, BigDecimal money, Integer count) {
        this.userId = userId;
        this.productCode = productCode;
        this.money = money;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
