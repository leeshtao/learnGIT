/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : readinglist

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-12-09 16:54:08
*/
SET FOREIGN_KEY_CHECKS=0;

DROP database IF EXISTS readinglist;
create database readinglist;
use readinglist;



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `USER_NAME` varchar(255) NOT NULL,
  `FULLNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `CREATE_DATE` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE` DATETIME,
  PRIMARY KEY (USER_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TRIGGER IF EXISTS `update_reader_trigger`;

CREATE TRIGGER `update_reader_trigger` BEFORE UPDATE ON `reader`
FOR EACH ROW SET NEW.`LAST_UPDATE` = NOW()



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `READER` varchar(255) DEFAULT NULL,
  `ISBN` varchar(255) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `AUTHOR` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `CREATE_DATE` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE` DATETIME,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TRIGGER IF EXISTS `update_book_trigger`;

CREATE TRIGGER `update_book_trigger` BEFORE UPDATE ON `book`
FOR EACH ROW SET NEW.`LAST_UPDATE` = NOW()