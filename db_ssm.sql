/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-11-01 09:42:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_link` varchar(255) DEFAULT NULL,
  `goods_price` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO goods VALUES ('6', 'p10', 'www.huawei.com', '3999');
INSERT INTO goods VALUES ('7', 'mi6', 'www.xm.com', '2499');
INSERT INTO goods VALUES ('8', 'mi5', 'www.xiaomi.com', '1799');

-- ----------------------------
-- Table structure for `head_pic`
-- ----------------------------
DROP TABLE IF EXISTS `head_pic`;
CREATE TABLE `head_pic` (
  `img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of head_pic
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `pic` varchar(255) NOT NULL DEFAULT '1.jpeg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO tb_user VALUES ('1', 'alvin', '12347', '1031734796@qq.com', '1.jpeg');
INSERT INTO tb_user VALUES ('57', 'huozhenlin', '1234', '10317347966@qq.com', '1.jpeg');
INSERT INTO tb_user VALUES ('58', 'cheng', '1234', '939597764@qq.com', 'bc80c5ef4c454718bc8bd77040279a0e.jpeg');
INSERT INTO tb_user VALUES ('59', 'alvin1234', '1234', '106@qq.com', '0b4bc460b117472481cbbdfc4dbfaf99.jpeg');
INSERT INTO tb_user VALUES ('60', 'huozhenlin1234', '1234', '196@qq.com', 'aa166b39206c46128b16335385130e7b.jpeg');
INSERT INTO tb_user VALUES ('61', 'huozhenlin123', '1234', '10317347@qq.com', '5a13758e5cf644d3bda00df6e8b73d3a.jpeg');
INSERT INTO tb_user VALUES ('62', 'hyz', '123456', '1036@qq.com', 'faf754c58a57408f8958c2502814d3c8.jpeg');
INSERT INTO tb_user VALUES ('63', 'jjii', '123', 'ddd@qq.com', '09034fd5ed884ef18ba80ecb0068aaf6.jpeg');
