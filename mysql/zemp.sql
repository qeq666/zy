/*
Navicat MySQL Data Transfer

Source Server         : zemp
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : zemp

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-11-07 17:37:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'admin', '123456');
INSERT INTO `emp` VALUES ('2', 'dana', '123456');
INSERT INTO `emp` VALUES ('3', 'bobo', '123456');
INSERT INTO `emp` VALUES ('4', 'dabai', '123456');
INSERT INTO `emp` VALUES ('5', 'dabai1', '123456');
INSERT INTO `emp` VALUES ('6', 'dabai2', '123456');
INSERT INTO `emp` VALUES ('7', 'asdas', 'asdasd');
INSERT INTO `emp` VALUES ('8', 'sdfsd', '34534');
INSERT INTO `emp` VALUES ('9', '34534534', '3434534');
