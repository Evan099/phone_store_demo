/*
 Navicat Premium Data Transfer

 Source Server         : hello
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : phone_store_demo

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 05/08/2020 18:05:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buyer_address
-- ----------------------------
DROP TABLE IF EXISTS `buyer_address`;
CREATE TABLE `buyer_address`  (
  `address_id` int(255) NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buyer_address
-- ----------------------------
INSERT INTO `buyer_address` VALUES (5, '小露露', '18289898989', '四川省成都市高新区软件园A区3308', '610001', NULL, NULL);
INSERT INTO `buyer_address` VALUES (13, '张三丰', '13289889898', '北京市北京市朝阳区簧门街213', '110105', NULL, NULL);
INSERT INTO `buyer_address` VALUES (14, '李易峰', '18799998888', '天津市天津市和平区123123', '120101', NULL, NULL);
INSERT INTO `buyer_address` VALUES (15, '杨幂', '18233336666', '上海市上海市虹口区和平饭店3206', '310109', NULL, NULL);

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `buyer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_id` int(255) NULL DEFAULT NULL,
  `phone_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_quantity` int(255) NOT NULL,
  `phone_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specs_id` int(255) NOT NULL,
  `specs_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specs_price` decimal(50, 0) NULL DEFAULT NULL,
  `order_amount` decimal(50, 0) NULL DEFAULT NULL,
  `pay_status` int(255) NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`, `phone_quantity`, `specs_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1596446283804272358', '吴彦祖', '13788889999', '四川省', 1, '华为P10', 1, '../static', 1, '华为P10_规格参数', 2800, 280, 1, '2020-07-30', NULL);
INSERT INTO `order_master` VALUES ('1596447844799515309', '张柏芝', '13788889999', '四川省', 1, '华为P10', 1, '../static', 1, '华为P10_规格参数', 2900, 280, 0, '2020-07-30', NULL);
INSERT INTO `order_master` VALUES ('1596524017478668687', '张三', '13788889999', '四川省', 1, '华为P10', 1, '../static', 1, '华为P10_规格参数', 3000, 280, 0, '2020-07-30', NULL);
INSERT INTO `order_master` VALUES ('1596532822458576339', '小周', '19888889999', '福建省厦门市大件路1903号', 1, '华为P10', 1, '../static', 1, '华为P10_规格参数', NULL, 280, 1, '2020-07-30', NULL);
INSERT INTO `order_master` VALUES ('1596533151970687190', '小语', '19888889999', '天津市大件路1903号', 1, '华为P10', 1, '../static', 1, '华为P10_规格参数', NULL, 280, 0, '2020-07-30', NULL);

-- ----------------------------
-- Table structure for phone_category
-- ----------------------------
DROP TABLE IF EXISTS `phone_category`;
CREATE TABLE `phone_category`  (
  `category_id` int(255) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_type` int(255) NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_category
-- ----------------------------
INSERT INTO `phone_category` VALUES (1, '红色', 1, '2020-07-01', '2020-07-03');
INSERT INTO `phone_category` VALUES (2, '黑色', 2, '2020-07-10', '2020-07-19');
INSERT INTO `phone_category` VALUES (3, '蓝色', 3, '2020-08-03', '2020-08-03');
INSERT INTO `phone_category` VALUES (4, '金色', 4, '2020-08-03', '2020-08-03');

-- ----------------------------
-- Table structure for phone_info
-- ----------------------------
DROP TABLE IF EXISTS `phone_info`;
CREATE TABLE `phone_info`  (
  `phone_id` int(255) NOT NULL AUTO_INCREMENT,
  `phone_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_price` decimal(50, 0) NULL DEFAULT NULL,
  `phone_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_stock` int(255) NULL DEFAULT NULL,
  `phone_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_type` int(255) NULL DEFAULT NULL,
  `phone_tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`phone_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_info
-- ----------------------------
INSERT INTO `phone_info` VALUES (1, '华为P10', 3000, NULL, 300, 'https://img.yzcdn.cn/vant/ipad.jpeg', 1, '720P珍珠屏&1300万像素&32G内存', '2020-07-30', NULL);
INSERT INTO `phone_info` VALUES (2, '华为P11', 3100, NULL, 0, 'https://img.yzcdn.cn/vant/ipad.jpeg', 2, '720P珍珠屏&1300万像素&32G内存', '2020-07-30', NULL);
INSERT INTO `phone_info` VALUES (3, '华为P12', 3100, '', 0, 'https://img.yzcdn.cn/vant/ipad.jpeg', 3, '1080P', '2020-08-01', '2020-08-03');
INSERT INTO `phone_info` VALUES (4, '华为Mate30', 4000, NULL, 0, 'https://img.yzcdn.cn/vant/ipad.jpeg', 4, '1080POLED屏&200万像素&32G内存', '2020-07-30', NULL);
INSERT INTO `phone_info` VALUES (8, '华为Mate40', 4500, NULL, 0, 'https://img.yzcdn.cn/vant/ipad.jpeg', 4, '720P珍珠屏&2000万像素&32G内存', '2020-07-30', NULL);

-- ----------------------------
-- Table structure for phone_specs
-- ----------------------------
DROP TABLE IF EXISTS `phone_specs`;
CREATE TABLE `phone_specs`  (
  `specs_id` int(255) NOT NULL AUTO_INCREMENT,
  `phone_id` int(255) NULL DEFAULT NULL,
  `specs_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specs_stock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specs_price` decimal(50, 0) NULL DEFAULT NULL,
  `specs_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `specs_preview` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `update_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`specs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of phone_specs
-- ----------------------------
INSERT INTO `phone_specs` VALUES (1, 1, '32GB', '130', 390000, 'https://img.yzcdn.cn/vant/ipad.jpeg', 'https://img.yzcdn.cn/vant/ipad.jpeg', '2020-08-02', '2020-08-03');
INSERT INTO `phone_specs` VALUES (2, 1, '64GB', '170', 490000, 'https://img.yzcdn.cn/vant/ipad.jpeg', 'https://img.yzcdn.cn/vant/ipad.jpeg', '2020-08-05', '2020-08-05');
INSERT INTO `phone_specs` VALUES (3, 2, '128GB', '100', 520000, 'https://img.yzcdn.cn/vant/ipad.jpeg', 'https://img.yzcdn.cn/vant/ipad.jpeg', '2020-08-05', '2020-08-05');

SET FOREIGN_KEY_CHECKS = 1;
