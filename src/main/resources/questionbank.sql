/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : questionbank

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 30/07/2019 17:08:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary`  (
  `id` bigint(20) NOT NULL,
  `dictionary_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dictionary_type` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dictionary_value` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `orgid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
INSERT INTO `t_dictionary` VALUES (1, '我疯狂崩溃', '321', '3124214', NULL, '214', '1', '1241', '2412', '2019-06-13 11:53:09.000000', 'Aaron', '2019-07-29 01:20:55.794000', '124');
INSERT INTO `t_dictionary` VALUES (604789904634941440, '我炸了', '4124', '314', NULL, '12412', '1', '12412', 'Aaron', '2019-07-27 21:39:32.160000', 'Aaron', '2019-07-29 01:46:15.173000', NULL);
INSERT INTO `t_dictionary` VALUES (605078809284317184, '终于修好了', '12412', 'qwr', NULL, '4124', '1', '1421', 'Aaron', '2019-07-28 16:47:09.955000', 'Aaron', '2019-07-29 01:46:30.109000', NULL);
INSERT INTO `t_dictionary` VALUES (605082301642182656, 'JsonSerialize(usingToStringSerializer.class)', '12412', 'qwr', NULL, '4124', '1', '1421', 'Aaron', '2019-07-28 17:01:02.601000', 'Aaron', '2019-07-29 01:48:06.178000', NULL);
INSERT INTO `t_dictionary` VALUES (605322815054417920, '我不打了，崩溃', '茄子', '1', NULL, '我起了一枪秒了', '2', NULL, 'Aaron', '2019-07-29 08:56:54.563000', 'Aaron', '2019-07-30 10:55:34.269000', NULL);
INSERT INTO `t_dictionary` VALUES (605323443931582464, '真实', '茄子', '2', NULL, '卧槽，我崩溃了', NULL, NULL, 'Aaron', '2019-07-29 08:59:15.399000', '-1', NULL, NULL);
INSERT INTO `t_dictionary` VALUES (605323543684714496, '白给少年22', '茄子', '33', NULL, '我起了一枪秒了，有什么好说的', '2', NULL, 'Aaron', '2019-07-29 08:59:39.182000', 'aaron', '2019-07-30 16:18:53.091000', NULL);
INSERT INTO `t_dictionary` VALUES (605323793459712000, '我给丢点东西', '茄子', '1', NULL, '丢个跳台下的烟一颗警家烟真实一点', '1', NULL, 'Aaron', '2019-07-29 09:00:38.733000', 'Aaron', '2019-07-29 15:01:02.025000', NULL);
INSERT INTO `t_dictionary` VALUES (605339831328968704, '我不打了我崩溃了', '茄子', '2', NULL, '崩溃', '1', NULL, 'Aaron', '2019-07-29 10:04:22.459000', 'Aaron', '2019-07-29 10:12:22.170000', NULL);
INSERT INTO `t_dictionary` VALUES (605361725566488576, '考试卷管理', '2', '1', NULL, '管理考试信息', '1', NULL, 'Aaron', '2019-07-29 11:31:22.452000', NULL, NULL, '1.0');
INSERT INTO `t_dictionary` VALUES (605712977244590080, '考试d', '412421', '24', NULL, '12412', '1', NULL, 'Aaron', '2019-07-30 10:47:07.378000', 'aaron', '2019-07-30 16:18:42.310000', '1.0');
INSERT INTO `t_dictionary` VALUES (605729129219887104, 'redis', 'rwe', 'wr', NULL, 'rwerw', '1', NULL, 'Aaron', '2019-07-30 11:51:18.309000', NULL, NULL, '1.0');
INSERT INTO `t_dictionary` VALUES (605762510003507200, '新增redis', '13', '1', NULL, '3131', '1', NULL, NULL, '2019-07-30 14:03:56.908000', NULL, NULL, '1.0');
INSERT INTO `t_dictionary` VALUES (605762697543421952, '新增redis2', '13', '1', NULL, '4124', '1', NULL, NULL, '2019-07-30 14:04:41.621000', NULL, NULL, '1.0');
INSERT INTO `t_dictionary` VALUES (605763069796290560, '舒服撒', '414', '但是', NULL, '舒服撒', '1', NULL, NULL, '2019-07-30 14:06:10.373000', NULL, NULL, '1.0');
INSERT INTO `t_dictionary` VALUES (605763147588046848, '绝对不糊', '414', '渣渣', NULL, '132131', '1', NULL, NULL, '2019-07-30 14:06:28.920000', NULL, NULL, '1.0');
INSERT INTO `t_dictionary` VALUES (605763252437258240, '棋爽，舒服子', '414', '渣渣', NULL, '24', '1', NULL, NULL, '2019-07-30 14:06:53.918000', NULL, '2019-07-30 14:07:36.955000', '1.0');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `updated_time` datetime(6) DEFAULT NULL,
  `version` varchar(255) CHARACTER SET big5 COLLATE big5_chinese_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '123456', 'aaron', b'1', '2019-07-18', 'fad', 'fadfa', 'sdfsa', 'sfs', 'fasdfas', 'asdfs', 'fadf', '2019-07-10 15:36:08.000000', 'adfa', '2019-07-25 15:36:12.000000', 'safsf');

SET FOREIGN_KEY_CHECKS = 1;
