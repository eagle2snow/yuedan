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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_res
-- ----------------------------
INSERT INTO `t_res` VALUES ('1', null, null, '1', '1', '顶级资源', null, '0', '0', null, null);
INSERT INTO `t_res` VALUES ('2', null, '2018-04-13 13:57:40.075000', '1', '1', '会员中心', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('3', null, '2018-04-14 17:52:22.665000', '1', '1', '会员管理', 'admin:member:show', '0', '1', '/admin/member/list/1/115.htm', '2');
INSERT INTO `t_res` VALUES ('34', null, '2018-04-13 15:10:46.443000', '1', '1', '管理员中心', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('35', null, '2018-04-13 15:11:43.358000', '1', '1', '管理员管理', 'admin:sys:user:show', '0', '1', '/admin/sys/user/list/1/15.htm', '34');
INSERT INTO `t_res` VALUES ('36', null, '2018-04-13 15:12:12.382000', '1', '1', '添加管理员', 'admin:sys:user:add', '0', '2', '', '35');
INSERT INTO `t_res` VALUES ('37', null, '2018-04-13 15:12:51.566000', '1', '1', '修改管理员信息', 'admin:sys:user:update', '0', '2', '', '35');
INSERT INTO `t_res` VALUES ('38', null, '2018-04-13 15:13:07.038000', '1', '1', '删除管理员', 'admin:sys:user:delete', '0', '2', '', '35');
INSERT INTO `t_res` VALUES ('39', null, '2018-04-13 15:14:26.077000', '1', '1', '资源管理', 'admin:sys:res:show', '0', '1', '/admin/sys/res/list/1/15.htm', '34');
INSERT INTO `t_res` VALUES ('40', null, '2018-04-13 15:15:09.940000', '1', '1', '添加资源', 'admin:sys:res:add', '0', '2', '', '39');
INSERT INTO `t_res` VALUES ('41', null, '2018-04-13 15:15:26.382000', '1', '1', '修改资源', 'admin:sys:res:update', '0', '2', '', '39');
INSERT INTO `t_res` VALUES ('42', null, '2018-04-13 15:16:08.348000', '1', '1', '删除资源', 'admin:sys:res:delete', '0', '2', '', '39');
INSERT INTO `t_res` VALUES ('44', null, '2018-04-16 09:25:20.904000', '1', '1', '会员服务', '', '0', '1', '', '1');
INSERT INTO `t_res` VALUES ('45', null, '2018-04-13 16:27:16.431000', '1', '1', '设置管理员权限', 'admin:user:setRes', '0', '2', '', '35');
INSERT INTO `t_res` VALUES ('46', null, '2018-04-13 17:12:21.693000', '1', '1', '查看登录日志', 'admin:sys:loginlog:show', '0', '1', '/admin/sys/loginlog/list/1/15.htm', '34');
INSERT INTO `t_res` VALUES ('47', null, '2018-04-13 17:12:06.969000', '1', '1', '查看操作日志', 'admin:sys:optlog:show', '0', '1', '/admin/sys/optlog/list/1/15.htm', '34');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_res
-- ----------------------------
