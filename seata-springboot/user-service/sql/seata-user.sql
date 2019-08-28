# seata-user db
DROP SCHEMA IF EXISTS `seata_user`;
CREATE SCHEMA `seata_user`;
USE `seata_user`;

CREATE TABLE `t_user`
(
    `id`      INT(11) NOT NULL AUTO_INCREMENT,
    `user_code` VARCHAR(255) DEFAULT NULL,
    `username` VARCHAR(32) DEFAULT NULL,
    `money`   INT(11)      DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO t_user (user_code, username, money)
VALUES ('U1000001', 'jason', 50000);
INSERT INTO t_user (user_code, username, money)
VALUES ( 'U1000002', 'jsbintask', 10000);
INSERT INTO t_user (user_code, username, money)
VALUES ('U1000003', 'lee', 20000);

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
