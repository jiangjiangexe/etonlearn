--liquibase formatted sql
--changeset tsuki:16040707
CREATE TABLE `rock` (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';

--changeset tsuki:1604070702
CREATE TABLE `zero` (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';

--changeset tsuki:1604070703
CREATE TABLE `dioga` (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';
--rollback DROP TABLE `dioga`;

--changeset tsuki:1604070704
CREATE TABLE mach (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';
--rollback drop TABLE mach;

--changeset tsuki:1604070704
CREATE TABLE mach (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';
--rollback drop TABLE mach;

--changeset tsuki:1604070707
CREATE TABLE MEGAMAN (
  MAN VARCHAR(11) NOT NULL
);