package cn.jsbintask.seata.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "cn.jsbintask.seata")
@EnableJpaRepositories
@EntityScan(basePackages = "cn.jsbintask.seata")
public class ProductApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class, args);
    }

}
