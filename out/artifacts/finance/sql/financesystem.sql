/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : financesystem

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 06/12/2018 17:15:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `tare` decimal(15, 2) NOT NULL,
  `suttle` decimal(15, 2) NOT NULL,
  `price` decimal(15, 2) NOT NULL,
  `chickType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`chickType`) USING BTREE,
  UNIQUE INDEX `chickType_UNIQUE`(`chickType`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (0.00, 0.00, 3.00, '水果');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype`  (
  `goodsType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('水果', 'admin', 22);
INSERT INTO `goodstype` VALUES ('蔬菜', 'admin', 23);

-- ----------------------------
-- Table structure for pullchick
-- ----------------------------
DROP TABLE IF EXISTS `pullchick`;
CREATE TABLE `pullchick`  (
  `tare` decimal(15, 2) NOT NULL,
  `suttle` decimal(15, 2) NOT NULL,
  `price` decimal(15, 2) NOT NULL,
  `sumWeight` decimal(15, 2) NOT NULL,
  `sumPrice` decimal(15, 2) NOT NULL,
  `chickType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`chickType`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `region` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `authority` int(11) NOT NULL,
  PRIMARY KEY (`username`) USING BTREE,
  UNIQUE INDEX `username_UNIQUE`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('admin', '123', '超级管理员', '长沙', 1);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` date NOT NULL,
  `tare` decimal(15, 2) NOT NULL,
  `suttle` decimal(15, 2) NOT NULL,
  `price` decimal(15, 2) NOT NULL,
  `handleType` int(11) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `region` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES (1, '水果', '2018-12-06', 1.00, 2.00, 3.00, 1, 'admin', '长沙');
INSERT INTO `warehouse` VALUES (2, '水果', '2018-12-06', 1.00, 2.00, 3.00, 1, 'admin', '长沙');
INSERT INTO `warehouse` VALUES (3, '水果', '2018-12-06', 1.00, 2.00, 3.00, -1, 'admin', '长沙');
INSERT INTO `warehouse` VALUES (4, '水果', '2018-12-06', 1.00, 2.00, 3.00, -1, 'admin', '长沙');

SET FOREIGN_KEY_CHECKS = 1;
