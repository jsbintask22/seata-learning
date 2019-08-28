# seata_order db
DROP SCHEMA IF EXISTS seata_order;
CREATE SCHEMA seata_order;
USE seata_order;

CREATE TABLE `t_order`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `user_id`        VARCHAR(255) DEFAULT NULL,
    `product_code` VARCHAR(255) DEFAULT NULL,
    `count`          INT(11)      DEFAULT '0',
    `money`          INT(11)      DEFAULT '0',
    `create_time` DATETIME DEFAULT NULL,
    `update_time` DATETIME DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

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
