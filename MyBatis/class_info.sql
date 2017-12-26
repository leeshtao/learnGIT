/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-12-20 08:18:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', 'class1');
