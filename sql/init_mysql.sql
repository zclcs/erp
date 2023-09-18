/*
 Navicat Premium Data Transfer

 Source Server         : docker_mysql_192.168.30.10
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : 192.168.33.10:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 18/09/2023 08:41:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对账表编号',
  `company_id` bigint(20) NULL DEFAULT NULL COMMENT '公司编号',
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公司名称',
  `delivery_date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '对账单生成日期',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '对账单名称',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 688 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '对账单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for child_order
-- ----------------------------
DROP TABLE IF EXISTS `child_order`;
CREATE TABLE `child_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '子订单编号',
  `orders_id` bigint(20) NULL DEFAULT NULL COMMENT '父订单编号',
  `product_id` bigint(20) NOT NULL COMMENT '子产品编号',
  `product_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '子产品名称',
  `specification` int(11) NULL DEFAULT NULL COMMENT '规格型号/桶',
  `number` int(11) NULL DEFAULT NULL COMMENT '桶数',
  `weight` int(11) NULL DEFAULT NULL COMMENT '重量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '金额',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `child_order_status` int(11) NOT NULL COMMENT '状态 1 有效 0 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1220 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '子订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for child_order_bill
-- ----------------------------
DROP TABLE IF EXISTS `child_order_bill`;
CREATE TABLE `child_order_bill`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对账表和子单的关联表',
  `child_order_id` bigint(20) NULL DEFAULT NULL COMMENT '子单id',
  `bill_id` bigint(20) NULL DEFAULT NULL COMMENT '对账单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2555 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '对账单和子订单关联' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '公司表主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公司名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '公司' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `company_id` bigint(20) NULL DEFAULT NULL COMMENT '公司编号',
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '公司名称',
  `delivery_date` date NULL DEFAULT NULL COMMENT '送货日期',
  `orders_status` int(11) NOT NULL COMMENT '状态 1 有效 0 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 622 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '订单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '产品名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '产品' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for product_company
-- ----------------------------
DROP TABLE IF EXISTS `product_company`;
CREATE TABLE `product_company`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '进货公司编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '进货公司名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '进货公司' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `product_company_id` bigint(20) NULL DEFAULT NULL COMMENT '进货公司id',
  `product_company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '进货公司名称',
  `purchase_date` date NULL DEFAULT NULL COMMENT '进货日期',
  `purchase_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '进货金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 207 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '进货单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
  `id` bigint(20) NOT NULL COMMENT '系统配置id',
  `salesman` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统配置' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
