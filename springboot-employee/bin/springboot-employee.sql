SET FOREIGN_KEY_CHECKS=0;

DROP database IF EXISTS springboot_employee;
create database springboot_employee;
use springboot_employee;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  ID bigint(20) not null auto_increment, 
  NAME VARCHAR(20), 
  GENDER varchar(6), 
  AGE INT(3), 
  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  LAST_UPDATE DATETIME,
  IS_VALID int(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100000000000 DEFAULT CHARSET=utf8;

DROP TRIGGER IF EXISTS `update_employee_trigger`;

CREATE TRIGGER `update_employee_trigger` BEFORE UPDATE ON `employee`
FOR EACH ROW SET NEW.`LAST_UPDATE` = NOW()