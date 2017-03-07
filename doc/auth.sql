/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : auth

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-03-07 13:47:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_perm
-- ----------------------------
DROP TABLE IF EXISTS `auth_perm`;
CREATE TABLE `auth_perm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `permission` varchar(64) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  `depth` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_permission` (`permission`) USING BTREE,
  KEY `idx_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_deleted` (`is_deleted`) USING BTREE,
  KEY `idx_depth` (`depth`),
  CONSTRAINT `FK51r9w3nh9fbg0h8qd42amp0m4` FOREIGN KEY (`parent_id`) REFERENCES `auth_perm` (`id`),
  CONSTRAINT `auth_perm_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `auth_perm` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkh4a29xvpbkqo2aiatd3eb1fp` (`company_id`),
  KEY `FKg8cspqk58l57tpqp1pudaiwqv` (`category_id`),
  CONSTRAINT `FKg8cspqk58l57tpqp1pudaiwqv` FOREIGN KEY (`category_id`) REFERENCES `sys_category` (`id`),
  CONSTRAINT `FKkh4a29xvpbkqo2aiatd3eb1fp` FOREIGN KEY (`company_id`) REFERENCES `u_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for auth_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_perm`;
CREATE TABLE `auth_role_perm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `perm_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqg8n65ev9i0ra6fp1l65u21jm` (`perm_id`),
  KEY `FKq62vmoq46p63pbbh4315soafw` (`role_id`),
  CONSTRAINT `FKq62vmoq46p63pbbh4315soafw` FOREIGN KEY (`role_id`) REFERENCES `auth_role` (`id`),
  CONSTRAINT `FKqg8n65ev9i0ra6fp1l65u21jm` FOREIGN KEY (`perm_id`) REFERENCES `auth_perm` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_category
-- ----------------------------
DROP TABLE IF EXISTS `sys_category`;
CREATE TABLE `sys_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `depth` int(11) NOT NULL,
  `priority` int(11) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_depth` (`depth`) USING BTREE,
  KEY `idx_priority` (`priority`) USING BTREE,
  KEY `idx_is_deleted` (`is_deleted`) USING BTREE,
  CONSTRAINT `FK18qsxukvf40pdippprno5eq5b` FOREIGN KEY (`parent_id`) REFERENCES `sys_category` (`id`),
  CONSTRAINT `sys_category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `sys_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_company
-- ----------------------------
DROP TABLE IF EXISTS `u_company`;
CREATE TABLE `u_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `gmt_last_login` datetime DEFAULT NULL,
  `last_login_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_department
-- ----------------------------
DROP TABLE IF EXISTS `u_department`;
CREATE TABLE `u_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcyxi17g73goqqgonew6sjd745` (`company_id`),
  KEY `FKhq5o8e68otvfjc09kgy8h0m0s` (`parent_id`),
  CONSTRAINT `FKcyxi17g73goqqgonew6sjd745` FOREIGN KEY (`company_id`) REFERENCES `u_company` (`id`),
  CONSTRAINT `FKhq5o8e68otvfjc09kgy8h0m0s` FOREIGN KEY (`parent_id`) REFERENCES `u_department` (`id`),
  CONSTRAINT `u_department_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `u_company` (`id`),
  CONSTRAINT `u_department_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `u_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_employee
-- ----------------------------
DROP TABLE IF EXISTS `u_employee`;
CREATE TABLE `u_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb4n0b11pet23s4kimtl0i2xhc` (`company_id`),
  KEY `FK6hijb060n9cy5u390qcfaypyh` (`department_id`),
  CONSTRAINT `FK6hijb060n9cy5u390qcfaypyh` FOREIGN KEY (`department_id`) REFERENCES `u_department` (`id`),
  CONSTRAINT `FKb4n0b11pet23s4kimtl0i2xhc` FOREIGN KEY (`company_id`) REFERENCES `u_company` (`id`),
  CONSTRAINT `u_employee_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `u_department` (`id`),
  CONSTRAINT `u_employee_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `u_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
