--liquibase formatted sql
--changeset daniel:16040707
CREATE TABLE `role_authority_sum` (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';

--changeset omg:1604070702
CREATE TABLE `mega` (
  `row_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联role的role_id',
  `authority_sum` int(11) unsigned NOT NULL DEFAULT '0' COMMENT 'perms的值的和',
  `data_type_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联data_type的id',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色的权限值的和，如角色有RD权限，则和为2+8=10';