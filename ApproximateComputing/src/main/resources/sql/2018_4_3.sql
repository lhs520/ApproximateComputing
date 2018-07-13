/*
Navicat MySQL Data Transfer

Source Server         : lhs520
Source Server Version : 50721
Source Host           : 120.79.193.101:3306
Source Database       : approximatecomputing

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-03 13:37:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audio
-- ----------------------------
DROP TABLE IF EXISTS `audio`;
CREATE TABLE `audio` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audio
-- ----------------------------
INSERT INTO `audio` VALUES ('1', '5', '1', '90', '2018-03-26 14:01:37');
INSERT INTO `audio` VALUES ('2', '5', '1', '90', '2018-03-26 14:01:37');
INSERT INTO `audio` VALUES ('3', '0', '1', '90', '2018-03-26 14:02:58');
INSERT INTO `audio` VALUES ('4', '0', '1', '90', '2018-03-26 14:02:58');
INSERT INTO `audio` VALUES ('5', '5', '1', '90', '2018-03-26 14:03:26');
INSERT INTO `audio` VALUES ('6', '10', '1', '90', '2018-03-26 14:03:26');
INSERT INTO `audio` VALUES ('7', '5', '1', '90', '2018-03-26 14:10:14');
INSERT INTO `audio` VALUES ('8', '10', '1', '90', '2018-03-26 14:10:14');
INSERT INTO `audio` VALUES ('9', '5', '1', '90', '2018-03-26 14:10:34');
INSERT INTO `audio` VALUES ('10', '10', '1', '90', '2018-03-26 14:10:34');
INSERT INTO `audio` VALUES ('11', '20', '3', '90', '2018-03-26 22:40:26');
INSERT INTO `audio` VALUES ('12', '10', '2', '90', '2018-03-26 22:40:26');

-- ----------------------------
-- Table structure for imagerecognition
-- ----------------------------
DROP TABLE IF EXISTS `imagerecognition`;
CREATE TABLE `imagerecognition` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of imagerecognition
-- ----------------------------
INSERT INTO `imagerecognition` VALUES ('1', '20', '3', '90', '2018-03-27 13:20:25');
INSERT INTO `imagerecognition` VALUES ('2', '10', '2', '90', '2018-03-27 13:20:25');

-- ----------------------------
-- Table structure for pathplaning
-- ----------------------------
DROP TABLE IF EXISTS `pathplaning`;
CREATE TABLE `pathplaning` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `path_length` float(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pathplaning
-- ----------------------------
INSERT INTO `pathplaning` VALUES ('1', '20', '3', '90', '2018-03-27 13:27:34', '900');
INSERT INTO `pathplaning` VALUES ('2', '10', '2', '90', '2018-03-27 13:27:34', '960');

-- ----------------------------
-- Table structure for photodecode
-- ----------------------------
DROP TABLE IF EXISTS `photodecode`;
CREATE TABLE `photodecode` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photodecode
-- ----------------------------
INSERT INTO `photodecode` VALUES ('1', '20', '3', '90', '2018-03-27 13:31:14');
INSERT INTO `photodecode` VALUES ('2', '10', '2', '90', '2018-03-27 13:31:14');

-- ----------------------------
-- Table structure for speechrecognition
-- ----------------------------
DROP TABLE IF EXISTS `speechrecognition`;
CREATE TABLE `speechrecognition` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of speechrecognition
-- ----------------------------
INSERT INTO `speechrecognition` VALUES ('1', '20', '3', '90', '2018-03-27 13:34:55');
INSERT INTO `speechrecognition` VALUES ('2', '10', '2', '90', '2018-03-27 13:34:55');
INSERT INTO `speechrecognition` VALUES ('3', '10', '3', '90', '2018-03-27 21:42:57');
INSERT INTO `speechrecognition` VALUES ('4', '5', '2', '90', '2018-03-27 21:42:57');
INSERT INTO `speechrecognition` VALUES ('5', '10', '3', '90', '2018-03-27 21:43:52');
INSERT INTO `speechrecognition` VALUES ('6', '5', '2', '90', '2018-03-27 21:43:52');

-- ----------------------------
-- Table structure for stockprediction
-- ----------------------------
DROP TABLE IF EXISTS `stockprediction`;
CREATE TABLE `stockprediction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `error_ratio` float(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stockprediction
-- ----------------------------
INSERT INTO `stockprediction` VALUES ('1', '20', '3', '90', '2018-03-27 13:37:45', '5');
INSERT INTO `stockprediction` VALUES ('2', '10', '2', '90', '2018-03-27 13:37:45', '10');

-- ----------------------------
-- Table structure for tsp
-- ----------------------------
DROP TABLE IF EXISTS `tsp`;
CREATE TABLE `tsp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `path_length` float(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tsp
-- ----------------------------
INSERT INTO `tsp` VALUES ('1', '20', '3', '90', '2018-03-27 13:39:01', '900');
INSERT INTO `tsp` VALUES ('2', '10', '2', '90', '2018-03-27 13:39:01', '960');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'shu888', 'E1:0A:DC:39:49:BA:59:AB:BE:56:E0:57:F2:0F:88:3E', '2018-03-28 13:30:24');
INSERT INTO `user` VALUES ('2', 'zkq888', 'E1:0A:DC:39:49:BA:59:AB:BE:56:E0:57:F2:0F:88:3E', '2018-03-28 13:38:48');
INSERT INTO `user` VALUES ('3', 'wxh888', 'E1:0A:DC:39:49:BA:59:AB:BE:56:E0:57:F2:0F:88:3E', '2018-03-28 13:39:02');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `quality_loss_ratio` float(10,0) DEFAULT NULL,
  `time` float(10,0) DEFAULT NULL,
  `grade` int(4) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '20', '3', '90', '2018-03-27 13:41:18');
INSERT INTO `video` VALUES ('2', '10', '2', '90', '2018-03-27 13:41:18');
INSERT INTO `video` VALUES ('3', '20', '3', '90', '2018-03-27 20:50:56');
INSERT INTO `video` VALUES ('4', '10', '2', '90', '2018-03-27 20:50:56');
INSERT INTO `video` VALUES ('5', '20', '3', '90', '2018-03-27 21:42:00');
INSERT INTO `video` VALUES ('6', '10', '2', '90', '2018-03-27 21:42:00');
INSERT INTO `video` VALUES ('7', '20', '3', '90', '2018-03-28 13:23:49');
INSERT INTO `video` VALUES ('8', '10', '2', '90', '2018-03-28 13:23:49');
INSERT INTO `video` VALUES ('9', '20', '3', '90', '2018-03-28 13:41:24');
INSERT INTO `video` VALUES ('10', '10', '2', '90', '2018-03-28 13:41:24');
SET FOREIGN_KEY_CHECKS=1;
