# seata_product db
DROP SCHEMA IF EXISTS seata_product;
CREATE SCHEMA seata_product;
USE seata_product;

CREATE TABLE `t_product`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `product_code` VARCHAR(255) DEFAULT NULL,
    `count`          INT(11)      DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `product_code` (`product_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO t_product (product_code, count)
VALUES ('P_100001', 500);
INSERT INTO t_product (product_code, count)
VALUES ('P_100002', 1000);
INSERT INTO t_product (product_code, count)
VALUES ('P_100003', 100);

CREATE TABLE `undo_log` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` bigint(20) NOT NULL,
                            `xid` varchar(100) NOT NULL,
                            `context` varchar(128) NOT NULL,
                            `rollback_info` longblob NOT NULL,
                            `log_status` int(11) NOT NULL,
                            `log_created` datetime NOT NULL,
                            `log_modified` datetime NOT NULL,
                            `ext` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
