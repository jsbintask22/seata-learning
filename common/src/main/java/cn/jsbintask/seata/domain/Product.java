package cn.jsbintask.seata.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
@DynamicUpdate
@DynamicInsert
@Data
public class Product {

    @Id
    private Long id;
    private String productCode;
    private Integer count;
}
