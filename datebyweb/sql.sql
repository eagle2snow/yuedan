/*
Navicat MySQL Data Transfer

Source Server         : selfthis
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : bar

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-04 18:25:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `login_ip` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcymi7qmui33qy2i3ecpw5oim9` (`user_id`),
  CONSTRAINT `FKcymi7qmui33qy2i3ecpw5oim9` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES ('1', null, '2018-07-04 18:24:49.941000', '1', '1', null, '0:0:0:0:0:0:0:1', '1');

-- ----------------------------
-- Table structure for `t_member`
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `agency_id` varchar(255) DEFAULT NULL,
  `agency_nickname` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `chang_referrer` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `consume` decimal(19,2) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `generalize_cost` decimal(19,2) DEFAULT NULL,
  `generalize_id` varchar(255) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `ioc_url` varchar(255) DEFAULT NULL,
  `last_update_qr_code` datetime(6) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `login_time` datetime(6) DEFAULT NULL,
  `love` int(11) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `qr_code` text,
  `referrer_generalize_id` varchar(255) DEFAULT NULL,
  `referrer_nickname` varchar(255) DEFAULT NULL,
  `set_meal` int(11) DEFAULT NULL,
  `ten_return_one` decimal(19,2) DEFAULT NULL,
  `total_revenue` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------

-- ----------------------------
-- Table structure for `t_opt_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_opt_log`;
CREATE TABLE `t_opt_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `opt_ip` varchar(255) DEFAULT NULL,
  `opt_uri` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK56xgvnksn8373s5p4iuvx5e8r` (`user_id`),
  CONSTRAINT `FK56xgvnksn8373s5p4iuvx5e8r` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_opt_log
-- ----------------------------
INSERT INTO `t_opt_log` VALUES ('1', null, '2018-07-04 18:14:59.949000', '1', '1', null, '0:0:0:0:0:0:0:1', '/admin/sys/loginlog/list/1/15.htm', '1');

-- ----------------------------
-- Table structure for `t_res`
-- ----------------------------
DROP TABLE IF EXISTS `t_res`;
CREATE TABLE `t_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9mxmyqk77m4ta5xfwfurf0tkh` (`parent_id`),
  CONSTRAINT `FK9mxmyqk77m4ta5xfwfurf0tkh` FOREIGN KEY (`parent_id`) REFERENCES `t_res` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_res
-- ----------------------------
INSERT INTO `t_res` VALUES ('1', null, '2018-05-17 17:54:08.834000', '1', '1', '顶级资源', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('2', null, '2018-04-13 13:57:40.075000', '1', '1', '会员中心', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('8', null, '2018-04-13 14:08:38.504000', '2', '1', '商品分类', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('18', null, '2018-04-13 14:27:52.177000', '2', '1', '订单管理', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('22', null, '2018-04-13 14:30:59.790000', '2', '1', '评价管理', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('28', null, '2018-04-13 14:53:43.424000', '2', '1', '分销中心', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('32', null, '2018-04-13 15:08:40.162000', '2', '1', '财务管理', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('34', null, '2018-04-13 15:10:46.443000', '1', '1', '管理员中心', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('44', null, '2018-04-16 09:25:20.904000', '2', '1', '会员服务', '', '0', '1', '', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `last_login_date` datetime(6) DEFAULT NULL,
  `last_login_ip` varchar(255) DEFAULT NULL,
  `login_count` int(11) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `pass_error_times` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `sign` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', null, '2018-04-13 16:41:42.228000', '1', '1', '超级管理员', '/static/admin/img/user8-128x128.jpg', null, null, '0', '18174734499', '0', 'admin', null, '0', null, 'admin');

-- ----------------------------
-- Table structure for `t_user_res`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_res`;
CREATE TABLE `t_user_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `res_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9jnp8x22r714llhds35oe91pe` (`res_id`),
  KEY `FKqfnq1bbob94mdme33ftbqen9j` (`user_id`),
  CONSTRAINT `FK9jnp8x22r714llhds35oe91pe` FOREIGN KEY (`res_id`) REFERENCES `t_res` (`id`),
  CONSTRAINT `FKqfnq1bbob94mdme33ftbqen9j` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1459 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_res
-- ----------------------------
