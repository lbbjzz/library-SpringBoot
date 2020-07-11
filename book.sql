/*
 Navicat Premium Data Transfer

 Source Server         : j2e
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 47.107.234.173:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 11/07/2020 20:40:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('admin', 'mIc2tOHMar6YKXBvDTN7ug==', 'lQYXrBs5Tz2rFmfr/+ZB6w==', '2020-06-29 15:22:49');

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES (1, 'manager');
INSERT INTO `t_authority` VALUES (2, 'guest');

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pub_house` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `pub_date` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `classes` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `price` float NULL DEFAULT NULL,
  `quantity` int(11) NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 310 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, '白夜行', '南海出版公司', '东野圭吾', '2008', '悬疑小说', 30, 16, 'https://pic.baike.soso.com/ugc/baikepic2/22167/20180227142742-1630692861_jpg_211_300_10384.jpg/0');
INSERT INTO `t_book` VALUES (2, '嫌疑人X的献身', '南海出版公司', '东野圭吾', '2005', '悬疑小说', 40, 10, 'http://pic.baike.soso.com/p/20140403/20140403115509-1589897452.jpg');
INSERT INTO `t_book` VALUES (4, '世界神话大书', '上海文艺出版社', '蒂亚戈·德·莫拉埃斯', '2020', '幼儿读物', 64, 2, 'https://pic.ulecdn.com/pic/user_800141203/product/prd20200622/d28469988addec99_p800x800_xl.jpg');
INSERT INTO `t_book` VALUES (5, '少年读史记', '青岛出版社', '张嘉骅', '2015', '中国儿童文学', 50, 3, 'http://img.mp.itc.cn/upload/20170423/d86bf986b3c7446ca8e833d04c95d1f6_th.jpeg');
INSERT INTO `t_book` VALUES (6, '梅格时空大冒险', '文汇出版社', '马德琳·英格', '2017', '外国儿童文学', 108, 2, 'http://img.mp.itc.cn/upload/20170517/0e7bf8fa49004e8fa065fadd3f5fb26b_th.jpg');
INSERT INTO `t_book` VALUES (7, '林语堂传记典藏版', '湖南文艺出版社', '林语堂', '2020', '传记', 63, 2, 'http://www.kfzimg.com/sw/kfzimg/1361/ff8220da674c9b09_n.jpg');
INSERT INTO `t_book` VALUES (8, ' 白马少年，衣襟带花', '中国友谊出版公司', '云鲸航', '2020', '青春文学', 19, 2, 'http://p2.itc.cn/q_70/images03/20200610/68d84b559ee74a2b8d80db6c198d2f40.png');
INSERT INTO `t_book` VALUES (9, '卢浮宫艺术课', '江苏凤凰文艺出版社', '程珺', '2020', '艺术', 27.5, 2, 'https://mmbiz.qpic.cn/mmbiz_jpg/SVpWZ5BwP9NUJibQ1h270RJyTBPRSCWLrtsFLGZtuDXnJGunSrHfhV27ngAyImLnt3YVRPibx0417mREJJ5jdKwA/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1');
INSERT INTO `t_book` VALUES (10, ' 蓝溪镇1', '江苏凤凰文艺出版社', '木头、孙呱', '2020', '动漫', 24.9, 2, 'https://img10.360buyimg.com/n1/jfs/t1/111009/1/3974/374425/5eaa9c73E8e929be1/12dfc46a1f0734d7.jpg');
INSERT INTO `t_book` VALUES (11, '摄影的艺术', '人民邮电出版社', 'Bruce Barnbaum', '2012', '摄影', 59, 1, 'https://cover.read.duokan.com/mfsv2/download/s010/p01T9yAChQUd/cmuvxqLewaI2Kw.jpg!l');
INSERT INTO `t_book` VALUES (12, '哲学100问', '华文出版社', '书杰', '2019', '哲学宗教', 68, 2, 'http://5b0988e595225.cdn.sohucs.com/images/20200321/347bfad3bb3e45ecb2a7f92b7a85ed62.jpeg');
INSERT INTO `t_book` VALUES (13, '决战：毛泽东、蒋介石是如何应对三大战役的', '生活·读书·新知三联书店', '金冲及', '2020', '政治军事', 37.2, 2, 'http://y1.ifengimg.com/cmpp/2014/01/02/09/c85c1e1c-7936-4482-bca3-2d4fa664517d.jpg');
INSERT INTO `t_book` VALUES (14, '大国之基', '东方出版社', '贺雪峰', '2019', '社会科学', 40.7, 6, 'http://p2.itc.cn/q_70/images03/20200604/e6a0b54f053c4945aaa5190c84b65ccd.jpeg');
INSERT INTO `t_book` VALUES (15, '怪奇事物所', '国际文化出版公司', '怪奇事务所', '2020', '科普读物', 26.1, 2, 'http://upload.dajianet.com/2020/0306/1583479167185.png');
INSERT INTO `t_book` VALUES (16, '钱从哪里来', '中信出版社', '香帅', '2020', '管理', 44.25, 2, 'http://5b0988e595225.cdn.sohucs.com/images/20200102/164d48b3a9f247ba9808c5ac63183ab8.jpeg');
INSERT INTO `t_book` VALUES (17, ' 非暴力沟通', '华夏出版社', '46.6', '2018', '励志', 46.6, 2, 'http://img.mp.itc.cn/upload/20170714/5f91328a8dd54dd5bc5fae65e5a417d0_th.jpg');
INSERT INTO `t_book` VALUES (18, '哲人石丛书珍藏版08·大流感：最致命瘟疫的史诗', '上海科技教育出版社', '约翰·M·巴里', '2018', '自然科学', 44.1, 2, 'http://www.kfzimg.com/sw/kfzimg/942/a67aec7ed636f0f9_n.jpg');
INSERT INTO `t_book` VALUES (19, '几何原本', '江苏人民出版社', '欧几里得', '2011', '自然科学', 22.6, 3, 'https://img3m0.ddimg.cn/21/27/23514600-1_w_1.jpg');
INSERT INTO `t_book` VALUES (20, '相对论', '新世界出版社', '爱因斯坦', '2014', '自然科学', 16, 3, 'http://www.kfzimg.com/sw/kfzimg/295/38feeae2241ed260_b.jpg');
INSERT INTO `t_book` VALUES (21, '说出灿烂人生：跟著名主持人学沟通', '北京联合出版有限公司', '冯殊', '2020', '励志', 29.9, 3, 'http://p6.itc.cn/images01/20200514/8f213b3fca264594ae95b68f3c6af19c.jpeg');
INSERT INTO `t_book` VALUES (22, ' 向上生长', '贵州人民出版社', '九边', '2020', '励志', 17.6, 2, 'http://p2.itc.cn/images03/20200517/d68b738e34654b528f630f00ae73ae60.jpeg');
INSERT INTO `t_book` VALUES (23, '金字塔原理', '南海出版公司', '芭芭拉·明托', '2019', '管理', 87.1, 2, 'http://www.kfzimg.com/sw/kfzimg/1036/baeae682ea1b9070_n.jpg');
INSERT INTO `t_book` VALUES (24, '掌控习惯', '北京联合出版有限公司', '詹姆斯·克利尔', '2019', '管理', 24.5, 3, 'http://5b0988e595225.cdn.sohucs.com/images/20191010/6db873a0f6b043a79b6139d2cce7656f.jpeg');
INSERT INTO `t_book` VALUES (25, '1分钟物理', '天津科学技术出版社', '中科院物理所', '2020', '科普读物', 27.5, 3, 'http://5b0988e595225.cdn.sohucs.com/images/20190918/b9dcf7fd858e473f94ceb7436bc08dc3.jpeg');
INSERT INTO `t_book` VALUES (26, '想太多的人类学家', '天津科学技术出版社', '李相僖、尹信荣', '2020', '科普读物', 29, 5, 'http://www.uua.cn/uploadfile/2020/0510/20200510124457736.jpg');
INSERT INTO `t_book` VALUES (27, '乡土中国', '人民出版社', '费孝通', '2015', '社会科学', 12.3, 5, 'https://img3m9.ddimg.cn/41/30/23678069-1_w_6.jpg');
INSERT INTO `t_book` VALUES (28, ' 第二性', '上海译文出版社', '西蒙娜德波伏瓦', '2011', '社会科学', 50.1, 1, 'http://5b0988e595225.cdn.sohucs.com/images/20180606/fd159dd0888240758d302a5823d1c4ca.jpeg');
INSERT INTO `t_book` VALUES (29, '禅者的初心', '海南出版社', '铃木俊隆', '2010', '哲学宗教', 16.5, 2, 'http://img1.gtimg.com/rushidao/pics/hv1/82/157/2204/143355217.jpg');
INSERT INTO `t_book` VALUES (30, '论语别裁', '东方出版社', '南怀瑾', '2018', '哲学宗教', 49, 2, 'http://www.toplights.cn/Upload/Imgfile/2020/2/25/202022521408250.jpg');
INSERT INTO `t_book` VALUES (31, '摄影构图 迅速提升照片水平的150个关键技法', '人民邮电出版社', '上田晃思、河野铁平、杉本恭子', '2016', '摄影', 29.5, 1, 'http://5b0988e595225.cdn.sohucs.com/images/20191226/dc17b4522dc74419af3b3d57b1d978c0.jpeg');
INSERT INTO `t_book` VALUES (32, '论摄影', '上海译文出版社', '苏珊·桑塔格', '2010', '摄影', 29, 1, 'https://pic.baike.soso.com/ugc/baikepic2/2382/20200621083837-450549856_jpeg_600_600_29657.jpg/0');
INSERT INTO `t_book` VALUES (33, '艺术通史', '北京联合出版有限公司', '史蒂芬·法辛', '2019', '艺术', 126, 1, 'https://img1.doubanio.com/view/subject/s/public/s33519589.jpg');
INSERT INTO `t_book` VALUES (34, '写给大家的中国美术史', '生活·读书·新知三联书店', '蒋勋', '2015', '艺术', 66, 2, 'https://img3m1.ddimg.cn/92/9/23784941-1_w_1.jpg');
INSERT INTO `t_book` VALUES (35, '又是青春年少', '浙江文艺出版社', '三水小草', '2020', '青春文学', 22.5, 3, 'http://s3-static.jjwxc.net/tmp/guanli/frontcover/003/345/3345643.jpg');
INSERT INTO `t_book` VALUES (36, '我开动物园那些年Ⅰ', '新星出版社', '拉棉花糖的兔子', '2020', '青春文学', 34.3, 2, 'http://5b0988e595225.cdn.sohucs.com/images/20190125/f4657923d0cf49778c73dadd889b3ecd.jpeg');
INSERT INTO `t_book` VALUES (37, '一个人住第5年', '北京联合出版公司', '高木直子', '2015', '动漫', 19.9, 2, 'https://i02piccdn.sogoucdn.com/dd7cf9d52200b462');
INSERT INTO `t_book` VALUES (38, '国家是怎样炼成的', '中国致公出版社', '赛雷', '2019', '动漫', 71.4, 2, 'http://xsrb.xsnet.cn/epaper/resfile/2018-04-23/06/zyh8482_b.jpg');
INSERT INTO `t_book` VALUES (39, '华为没有成功，只有成长：任正非传', '华中科技大学出版社', '林超华', '2019', '传记', 24.9, 3, 'https://i04piccdn.sogoucdn.com/7af2dab01721fe4c');
INSERT INTO `t_book` VALUES (40, '与万物对话：霍金传', '群言出版社', '鹿理梅', '2015', '传记', 15.1, 3, 'http://epaper.ntrb.com.cn/new/ntrb/res/1/143/2016-03/06/A04/res04_attpic_brief.jpg');
INSERT INTO `t_book` VALUES (41, '写给儿童的中国历史', '新世界出版社', '陈卫平', '2014', '中国儿童文学', 18, 2, 'http://5b0988e595225.cdn.sohucs.com/images/20181120/a09425adaba74bd686c1727df305bfd1.jpeg');
INSERT INTO `t_book` VALUES (42, '没头脑和不高兴(注音版）', '浙江少年儿童出版社', '任溶溶', '2018', '中国儿童文学', 8.1, 2, 'http://www.kfzimg.com/G06/M00/59/53/p4YBAFsBG7uAKKi3AAFQ4TGOqiY347_n.jpg');
INSERT INTO `t_book` VALUES (43, '窗边的小豆豆', '南海出版公司', '黑柳彻子', '2018', '外国儿童文学', 19.8, 2, 'https://pic4.zhimg.com/v2-b6d947aa74922c99f202ec801cb8c878_r.jpg');
INSERT INTO `t_book` VALUES (44, '千秋好诗词：3～6岁诵读版', '海豚出版社', '杨云柯、傅微薇', '2016', '幼儿读物', 45.6, 1, 'http://5b0988e595225.cdn.sohucs.com/images/20180716/8bd87ffb45e14f44859a470b29802a41.jpeg');
INSERT INTO `t_book` VALUES (45, '做内心强大的自己——歪歪兔逆商教育系列图画书', '海豚出版社', '歪歪兔关键期早教项目组', '2012', '幼儿读物', 40, 1, 'http://p1.pstatp.com/large/4870009a81e42adb516');
INSERT INTO `t_book` VALUES (46, '偷窥者：法医秦明系列第六季', '湖南文艺出版社', '秦明', '2017', '悬疑小说', 17.1, 2, 'http://img60.ddimg.cn/digital/product/3/63/1900710363_ii_cover.jpg?version=d9ab0f4c-f249-4dfd-ba6e-eefe5d98789c');
INSERT INTO `t_book` VALUES (47, '丁香妈妈科学养育：百位医生给新手妈妈的育儿解决方案', '中信出版社', '丁香妈妈', '2020', '育儿', 74.3, 1, 'http://www.wingsbook.com/img/big/752171364.jpg');
INSERT INTO `t_book` VALUES (48, '实用程序育儿法(新版)', '北京联合出版社', '特雷西·霍格、梅琳达·布劳', '2016', '育儿', 21, 2, 'http://img.135995.com/img.php?tag=a&url=mmbiz.qpic.cn/mmbiz_jpg/VTvpvIDUoTYibaXEicEfawJ7yecSJbqeByUTHRmmh0ybW6JQwbO4hSJ7ib8RyurOK3zZPTjITRTVejMTp7BIxCJicA/0?wx_fmt=jpeg');
INSERT INTO `t_book` VALUES (49, '郑玉巧育儿经 幼儿卷', '21世纪出版社', '郑玉巧', '2013', '育儿', 39.3, 2, 'https://pic.baike.soso.com/ugc/baikepic2/9564/20141203065450-1275055721.jpg/0');
INSERT INTO `t_book` VALUES (50, '四千年农夫', '东方出版社', '富兰克林·H·金', '2016', '农业/林业', 22.5, 1, 'http://5b0988e595225.cdn.sohucs.com/images/20171017/8b1b5028b9594cf7a2b35b4352b0c425.jpeg');
INSERT INTO `t_book` VALUES (51, '海水鱼大图鉴', '中国友谊出版公司', '加藤昌一', '2019', '农业/林业', 75.1, 1, 'http://www.kfzimg.com/sw/kfzimg/955/aa35cdcaafad7311_n.jpg');
INSERT INTO `t_book` VALUES (52, '资治通鉴', '商务印书馆', '司马光', '2019', '古籍', 34.9, 2, 'http://5b0988e595225.cdn.sohucs.com/images/20190520/bfa92fea4197435eb6408c24117ed496.jpeg');
INSERT INTO `t_book` VALUES (53, '史记', '商务印书馆', '司马迁', '2016', '古籍', 64, 2, 'http://www.xinhuanet.com/book/2019-11/13/138551908_15736342259551n.jpg');
INSERT INTO `t_book` VALUES (54, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (55, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (56, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (57, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (58, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (59, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (60, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (61, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (62, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (63, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (64, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (65, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (66, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (67, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (68, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (69, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (70, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (71, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (72, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (73, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (74, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (75, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (76, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (77, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (78, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (79, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (80, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (81, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (82, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (83, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (84, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (85, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (86, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (87, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (88, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (89, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (90, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (91, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (92, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (93, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (94, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (95, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (96, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (98, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (99, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (100, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (101, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (102, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (103, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (104, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (105, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (106, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (107, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (108, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (109, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (110, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (111, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (112, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (113, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (114, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (115, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (116, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (117, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (118, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (119, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (120, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (121, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (122, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (123, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (124, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (125, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (126, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (127, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (128, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (129, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (130, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (131, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (132, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (133, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (134, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (135, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (136, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (137, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (138, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (139, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (140, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (141, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (142, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (143, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (144, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (145, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (146, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (147, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (148, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (149, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (150, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (151, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (152, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (153, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (154, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (155, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (156, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (157, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (158, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (159, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (160, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (161, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (162, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (163, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (164, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (165, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (166, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (167, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (168, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (169, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (170, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (171, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (172, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (173, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (174, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (175, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (176, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (177, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (178, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (179, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (180, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (181, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (182, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (183, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (184, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (185, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (186, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (187, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (188, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (189, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (190, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (191, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (192, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (193, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (194, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (195, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (196, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (197, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (198, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (199, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (200, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (201, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (202, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (203, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (204, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (205, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (206, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (207, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (208, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (209, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (210, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (211, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (212, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (213, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (214, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (215, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (216, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (217, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (218, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (219, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (220, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (221, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (222, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (223, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (224, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (225, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (226, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (227, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (228, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (229, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (230, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (231, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (232, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (233, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (234, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (235, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (236, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (237, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (238, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (239, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (240, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (241, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (242, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (243, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (244, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (245, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (246, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (247, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (248, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (249, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (250, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (251, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (252, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (253, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (254, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (255, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (256, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (257, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (258, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (259, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (260, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (261, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (262, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (263, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (264, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (265, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (266, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (267, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (268, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (269, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (270, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (271, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (272, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (273, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (280, '', '', '', '', '', 0, 0, NULL);
INSERT INTO `t_book` VALUES (281, '', '', '', '', '', 0, 0, NULL);
INSERT INTO `t_book` VALUES (282, '', '', '', '', '', 0, 0, NULL);
INSERT INTO `t_book` VALUES (283, '', '', '', '', '', 0, 0, NULL);
INSERT INTO `t_book` VALUES (291, '213', '31231', '3213', '3123', '青春文学', 312, 312, NULL);
INSERT INTO `t_book` VALUES (294, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (295, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (296, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (297, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (298, '测试1', '测试1', '测试1', '测试1', '青春文学', 11, 11, NULL);
INSERT INTO `t_book` VALUES (301, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (302, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (303, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (304, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (305, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (306, 'qqqs', 'yyyy', 'dddd', '2001', NULL, 0, 0, NULL);
INSERT INTO `t_book` VALUES (307, '测试', '测试', '测试', '测试', NULL, 0, 0, NULL);

-- ----------------------------
-- Table structure for t_borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `t_borrow_record`;
CREATE TABLE `t_borrow_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `borrow_date` datetime NULL DEFAULT NULL,
  `return_date` datetime NULL DEFAULT NULL,
  `is_returned` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_BORROW_USER`(`user_id`) USING BTREE,
  CONSTRAINT `FK_BORROW_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_borrow_record
-- ----------------------------
INSERT INTO `t_borrow_record` VALUES (1, 1, 1, '2020-06-23 19:34:50', '2020-07-07 19:34:50', 1);
INSERT INTO `t_borrow_record` VALUES (4, 6, 2, '2020-06-24 03:46:32', '2020-07-08 19:35:50', 1);
INSERT INTO `t_borrow_record` VALUES (5, 1, 4, '2020-06-24 03:46:32', '2020-07-10 19:36:50', 1);
INSERT INTO `t_borrow_record` VALUES (6, 6, 5, '2020-06-24 03:46:32', '2020-07-24 19:37:50', 1);
INSERT INTO `t_borrow_record` VALUES (7, 5, 1, '2020-07-10 02:25:33', '2020-08-09 02:25:33', 1);
INSERT INTO `t_borrow_record` VALUES (8, 5, 2, '2020-07-10 03:42:40', '2020-08-09 03:42:40', 1);
INSERT INTO `t_borrow_record` VALUES (9, 5, 4, '2020-07-10 03:42:55', '2020-08-09 03:42:55', 1);
INSERT INTO `t_borrow_record` VALUES (10, 5, 5, '2020-07-10 03:43:42', '2020-08-09 03:43:42', 1);
INSERT INTO `t_borrow_record` VALUES (11, 5, 29, '2020-07-10 03:50:25', '2020-08-09 03:50:25', 1);
INSERT INTO `t_borrow_record` VALUES (12, 5, 284, '2020-07-10 03:50:45', '2020-08-09 03:50:45', 0);
INSERT INTO `t_borrow_record` VALUES (13, 5, 39, '2020-07-10 04:19:49', '2020-08-09 04:19:49', 1);
INSERT INTO `t_borrow_record` VALUES (14, 5, 26, '2020-07-10 04:25:13', '2020-08-09 04:25:13', 1);
INSERT INTO `t_borrow_record` VALUES (15, 5, 19, '2020-07-10 14:57:08', '2020-08-09 14:57:08', 1);
INSERT INTO `t_borrow_record` VALUES (16, 5, 8, '2020-07-10 15:00:31', '2020-08-09 15:00:31', 0);
INSERT INTO `t_borrow_record` VALUES (17, 35, 1, '2020-07-10 15:16:13', '2020-08-09 15:16:13', 1);
INSERT INTO `t_borrow_record` VALUES (18, 35, 2, '2020-07-10 15:17:03', '2020-08-09 15:17:03', 1);
INSERT INTO `t_borrow_record` VALUES (19, 5, 11, '2020-07-10 23:40:05', '2020-08-09 23:40:05', 1);
INSERT INTO `t_borrow_record` VALUES (20, 5, 6, '2020-07-11 00:36:40', '2020-08-10 00:36:40', 1);
INSERT INTO `t_borrow_record` VALUES (21, 45, 1, '2020-07-11 11:23:32', '2020-08-10 11:23:32', 1);
INSERT INTO `t_borrow_record` VALUES (22, 45, 38, '2020-07-11 13:41:29', '2020-08-10 13:41:29', 1);
INSERT INTO `t_borrow_record` VALUES (23, 59, 1, '2020-07-11 19:09:24', '2020-08-10 19:09:24', 1);
INSERT INTO `t_borrow_record` VALUES (24, 62, 1, '2020-07-11 19:48:59', '2020-08-10 19:48:59', 1);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单名',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '前端菜单访问地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_authority`;
CREATE TABLE `t_menu_authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_MENU_AUTHORITY`(`menu_id`) USING BTREE,
  INDEX `FK_AUTHORITY_MENU`(`auth_id`) USING BTREE,
  CONSTRAINT `FK_MENU_AUTHORITY` FOREIGN KEY (`menu_id`) REFERENCES `t_authority` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_AUTHORITY_MENU` FOREIGN KEY (`auth_id`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_menu_authority
-- ----------------------------

-- ----------------------------
-- Table structure for t_return_record
-- ----------------------------
DROP TABLE IF EXISTS `t_return_record`;
CREATE TABLE `t_return_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NULL DEFAULT NULL,
  `return_date` datetime NULL DEFAULT NULL,
  `is_overdue` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_RETURN_USER`(`user_id`) USING BTREE,
  CONSTRAINT `FK_RETURN_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_return_record
-- ----------------------------
INSERT INTO `t_return_record` VALUES (1, 5, 1, '2020-06-24 06:17:44', 0);
INSERT INTO `t_return_record` VALUES (3, 5, 2, '2020-06-24 06:24:33', 1);
INSERT INTO `t_return_record` VALUES (4, 5, 1, '2020-07-10 04:14:38', 0);
INSERT INTO `t_return_record` VALUES (5, 5, 29, '2020-07-10 04:19:16', 0);
INSERT INTO `t_return_record` VALUES (6, 5, 39, '2020-07-10 04:23:55', 0);
INSERT INTO `t_return_record` VALUES (7, 5, 1, '2020-07-10 04:25:02', 0);
INSERT INTO `t_return_record` VALUES (8, 5, 26, '2020-07-10 04:25:23', 0);
INSERT INTO `t_return_record` VALUES (9, 5, 26, '2020-07-10 04:25:49', 0);
INSERT INTO `t_return_record` VALUES (10, 5, 26, '2020-07-10 04:25:59', 0);
INSERT INTO `t_return_record` VALUES (11, 5, 1, '2020-07-10 04:26:50', 0);
INSERT INTO `t_return_record` VALUES (12, 5, 1, '2020-07-10 04:26:56', 0);
INSERT INTO `t_return_record` VALUES (13, 5, 1, '2020-07-10 04:32:43', 0);
INSERT INTO `t_return_record` VALUES (14, 5, 2, '2020-07-10 04:40:18', 0);
INSERT INTO `t_return_record` VALUES (15, 5, 19, '2020-07-10 14:57:54', 0);
INSERT INTO `t_return_record` VALUES (16, 35, 1, '2020-07-10 15:16:20', 0);
INSERT INTO `t_return_record` VALUES (17, 35, 1, '2020-07-10 15:16:48', 0);
INSERT INTO `t_return_record` VALUES (18, 35, 2, '2020-07-10 15:17:10', 0);
INSERT INTO `t_return_record` VALUES (19, 5, 11, '2020-07-10 23:40:19', 0);
INSERT INTO `t_return_record` VALUES (20, 5, 4, '2020-07-11 00:22:03', 0);
INSERT INTO `t_return_record` VALUES (21, 5, 6, '2020-07-11 00:36:49', 0);
INSERT INTO `t_return_record` VALUES (22, 5, 5, '2020-07-11 00:37:29', 0);
INSERT INTO `t_return_record` VALUES (23, 45, 1, '2020-07-11 11:23:51', 0);
INSERT INTO `t_return_record` VALUES (24, 45, 38, '2020-07-11 13:42:31', 0);
INSERT INTO `t_return_record` VALUES (25, 59, 1, '2020-07-11 19:09:47', 0);
INSERT INTO `t_return_record` VALUES (26, 62, 1, '2020-07-11 19:49:37', 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` tinyint(11) NULL DEFAULT NULL,
  `valid` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '小余', '$2a$10$kPHRU4wFim6k3mimGBtuLeZqpFFSMJzaSFoJV2vVnnlC2Ar471K/u', 'xiaoyuou@aliyun.com', '女士', '18706704062', 20, 0);
INSERT INTO `t_user` VALUES (5, 'admin', '$2a$10$IOPEzFfYxrY0qZv35jiZ9edkwKlXI94ULFKHvaG6ELd8nCXe491ma', 'test', '先生', '12312312', 21, 0);
INSERT INTO `t_user` VALUES (6, 'asdas', '$2a$10$FfMp8umJqroVIAaThQqvFOy8.8P.dtTD5.gPs0dllsv4Z95fQrChW', '942609405@qq.com', '女士', '12312312', 21, 0);
INSERT INTO `t_user` VALUES (7, 'dddddd', '$2a$10$tMtsvnJ1.eit1Z62iLNp8uc0qdMjS95QEhpPQGKewgesgsGo9bKR.', 'asd', 'asd', '421432245', 2, 0);
INSERT INTO `t_user` VALUES (18, 'wwwww', '$2a$10$xNIsPNrngks6qA2qThamSuloON3lIchM4xZeUm974.tjywqBHuI3C', 'test', '先生', '12312312', 45, 0);
INSERT INTO `t_user` VALUES (19, 'wwwwww', '$2a$10$z0JB6ujtoOfP3B7VLijtNuq9YgaLZUsGrBdNUodD/pxah/.sYvMFy', 'test', '先生', '12312312', 45, 0);
INSERT INTO `t_user` VALUES (20, 'ttttttt', '$2a$10$R5.nk4Qxr6SVKTTz8lldcOTi1bC3KYDWZgFQFbcfUy.qe.zU6D.xK', 'test', '先生', '12312312', 45, 0);
INSERT INTO `t_user` VALUES (21, 'tttttdftt', '$2a$10$lPJjV5peYsQiTLgMVXmVseEx/cH8ufZeIWaoSTsI/3QXU24Ow9ylu', 'test', '先生', '12312312', 45, 0);
INSERT INTO `t_user` VALUES (22, '231', '$2a$10$.fxDPPB0xN22lvWW1.kO9OzD28Qz5rAbC48z.xGWk6aIJxcpCMnkS', '3122131', '先生', '31231231231', 12, 0);
INSERT INTO `t_user` VALUES (23, '4234', '$2a$10$wznzey.aXRgVm5C5pzh17OG.YM7PTYWMPOoswfgf.bJBZj5Oi8xpO', '423424', '女士', '42342342342', 11, 0);
INSERT INTO `t_user` VALUES (25, '341234', '$2a$10$Bal.EoFiNEaNlW65ckQzp.rQS940IZ9UNcjCyscVBfMGkBF1m3ODe', '13441234', '女士', '4132413412', 12, 0);
INSERT INTO `t_user` VALUES (26, '231', '$2a$10$VXyaLXUjslJS3FUHld8/7OY3dIR8OQlE2vZQEiUIsTC3Tv4rBpfca', '331231', '先生', '211221212', 12, 0);
INSERT INTO `t_user` VALUES (27, 'user', '$2a$10$kZ6Fa6PEavHhaDLHW0mA../V4mxf27v2U/92uuewC51JzkF30oid2', 'ldld99@qq.com', '先生', '12131231231', 20, 0);
INSERT INTO `t_user` VALUES (28, 'this.form.userName', '$2a$10$siTJTkDSjTxpc.RivVB50OS2wh.xSEWYg9gLnUCBCIKIZ205YSlVe', 'this.form.email', NULL, NULL, 0, 0);
INSERT INTO `t_user` VALUES (29, 'user01', '$2a$10$X1y9Pi8enHLUW9XwQVhQFeFfIRzbU74MbYnwvjrHIO3lDrxOOdrRq', 'ldld99@qq.com', NULL, NULL, 0, 0);
INSERT INTO `t_user` VALUES (30, 'user02', '$2a$10$o3LRMKnrFAFuPFYcf8phqOEImROWjbx3HWIlK3UF7YQnlZvPN/sEW', 'ldld99@qq.com', NULL, NULL, 0, 0);
INSERT INTO `t_user` VALUES (31, 'user123', '$2a$10$cTG45EN0HHv03tpTGZbnguZgEsuIZGguv8UTPXsDfMxNgSZr7c45e', '213412341234', NULL, NULL, 0, 0);
INSERT INTO `t_user` VALUES (32, 'user1234', '$2a$10$8OnhPjvPDh0TH2r43JkRZ.mtm.IniUihGG6e0YXmlrSD7qXBpsTd2', '413241234', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (33, 'user111111', '$2a$10$3rzduRy4h1MkyHpvIZBgVuEJfjcW6lneVKVVtfpKUM3h.OaWHOSSG', '31231231312', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (34, 'user12123', '$2a$10$EHLtMccrmSp0NnM493G1Ve94zBbUdGAcF0UfUjXRBAnCKM2no5I/6', '3213123123', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (35, 'user0219', '$2a$10$YixFmg9NFl.IPaoDFXaWB.Jt5Ar25J8Xjz9zlEIOUl3Fb2py0xPi6', '13412351235', '先生', '1243213423', 21, 0);
INSERT INTO `t_user` VALUES (36, '', '$2a$10$jv8rClqNLBrAHkaEsJYBiOUWyigCAj4TZQM3j0PwNBbxHUJa0QLFW', '', '', '', 0, 0);
INSERT INTO `t_user` VALUES (37, '1231', '$2a$10$cKLKofPHJ4pVdr.hXWbgbOekDaSGG5m1eCCWZKa2fh1yT55AYWQeS', '31231', '女士', '123133123', 31, 0);
INSERT INTO `t_user` VALUES (38, '312314', '$2a$10$zBQhmBn0/c1wrWv7t3uQmOZAYzOUZ7IytmNZB3UXrEvONU9CLK75i', '32131231231', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (39, '3123', '$2a$10$X50YIaB6MIOSYpeJAv4fa.EQc0sVQtu/Uy2Av3XKO5ltGqpwaxp0i', '12', '先生', '2312312331', 21, 0);
INSERT INTO `t_user` VALUES (40, '31231', '$2a$10$x3f0QvHm3lsQpBSvkXqB1ubm/ENkwradXl965.Bw2WZc1a7KI1ef.', '12', '女士', '1321331231', 123, 0);
INSERT INTO `t_user` VALUES (41, 'user123123s', '$2a$10$oSuCTBXdtVyICp.UDpNB8OGMBpFEDsEawx1A3mWrysBXvqnGT8tK.', '3123123123', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (42, 'qewret', '$2a$10$qpj.29IVIPiX2ak8y9jVQ.Vj8J2QKbGvu50BWt4tgsH0eZnl9AaGC', '213412413', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (43, '42341234', '$2a$10$t0852S8s7yiG5EOc3UnsJu7lzxr0XVKqR5/PoAYCNCrREivCMESka', '412341234', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (44, '3123124142', '$2a$10$bGfTGHPu1.t3zX48RBo3Zey3VhgC3VoxHY5LmD21GDlKBIbKdaQzC', '41234123412', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (45, 'lbbjzz', '$2a$10$H/OLnsoOGiYlfDh2q/19suYndx9ZO5iDSH6Qb7Gc2DRYt4d/uKdxO', '123123123', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (46, '14234123', '$2a$10$A5Uet6/WiSppeeG274hRKep0jsOQ1r7GHJZPBPdSG4yZewN0KCpLS', '4132412341', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (47, '1244331ss', '$2a$10$ukk3IPxNYlh6p0wKC50suuQc/rODOsCT2QBEDARIXnxJL3T4T2MdO', '4143251', '女士', '412413414341', 22, 0);
INSERT INTO `t_user` VALUES (48, '41234sss', '$2a$10$3EncErK95ziun2/1xJqVsuHoeZkDPURt/YBbVmhn.CE9cKm7Ext1K', '4123413434', '女士', NULL, 0, 0);
INSERT INTO `t_user` VALUES (49, '', '', '', '', NULL, 0, 0);
INSERT INTO `t_user` VALUES (50, 'dsfsfsdf', '$2a$10$h18uPsvfG97gH6bFKzJWLO5A9GqPswYl212NR1WOXgAGGZFm3mGtW', 'ldld99@qq.com', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (51, 'eqweweqwe', '$2a$10$zepv6EBB.LloYoP/wVsk.ucIIf9/g7JGGgT4CN2A.XtUcfIG8VRl2', '14234123', '女士', NULL, 0, 0);
INSERT INTO `t_user` VALUES (52, 'sadasdasdasdas', '$2a$10$AVcVerUrFbkIvE/Pgqbv4OtXxSoD9W1DeXZN/B8gAbRpKatJngWxO', '31231312', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (53, 'test111111', '$2a$10$Qkhm.OvPPuxfAaqn0Ge40u7LgF7ipFwqiZyGam.DTQrui9E83WwuW', '31313', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (54, '214', '$2a$10$cQ7nVJJzhMBQecr1gra1f.etTlHfRJlr2u36XWngE21ga31KuKPW2', '3214143', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (55, 'testcode', '$2a$10$qN3A8zcBxkvOobZH4C6uyOywDykguMFAsbq9CpO0cxPd4n8RjykiK', 'ldld99@qq.com', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (56, 'testcodewww', '$2a$10$IOPEzFfYxrY0qZv35jiZ9edkwKlXI94ULFKHvaG6ELd8nCXe491ma', 'ldld99@qq.com', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (58, 'adminddd', '$2a$10$IOPEzFfYxrY0qZv35jiZ9edkwKlXI94ULFKHvaG6ELd8nCXe491ma', 'ldld99@qq.com', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (59, '0987654', '$2a$10$a5PlamU816voXDiG7ET11ObbxiFLBQZsnGV3myVpfEVyawpX/yA/e', 'ldld99@qq.com', '先生', '412351451345', 20, 0);
INSERT INTO `t_user` VALUES (60, '098765', '$2a$10$KPmma.4TogEvZWoHqQA.KeikvxhMMG/qyl5O9H/vfqZnqozUFkMOS', 'ldld99@qq.com', '先生', NULL, 0, 0);
INSERT INTO `t_user` VALUES (61, '41324123413', '$2a$10$2aw/Hz0B0Zr6DXpX6FQr8OV2bfptN4BrNA5TpEZW3dEW8r1mKJG4a', '4412341234', '女士', '413412342134', 12, 0);
INSERT INTO `t_user` VALUES (62, 'test0000', '$2a$10$0ComnenRXTvvIOiigRNXfebG32AetyLgdCCyNC96FSo3t6B5YtMxa', 'ldld99@qq.com', '先生', NULL, 0, 0);

-- ----------------------------
-- Table structure for t_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_authority`;
CREATE TABLE `t_user_authority`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `authority_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_AUTHORITY`(`authority_id`) USING BTREE,
  INDEX `FK_USER`(`user_id`) USING BTREE,
  CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_AUTHORITY` FOREIGN KEY (`authority_id`) REFERENCES `t_authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_authority
-- ----------------------------
INSERT INTO `t_user_authority` VALUES (1, 1, 1);
INSERT INTO `t_user_authority` VALUES (2, 1, 2);
INSERT INTO `t_user_authority` VALUES (3, 5, 2);
INSERT INTO `t_user_authority` VALUES (4, 6, 2);
INSERT INTO `t_user_authority` VALUES (5, 7, 2);
INSERT INTO `t_user_authority` VALUES (6, 18, 2);
INSERT INTO `t_user_authority` VALUES (7, 20, 2);
INSERT INTO `t_user_authority` VALUES (8, 21, 2);
INSERT INTO `t_user_authority` VALUES (9, 22, 2);
INSERT INTO `t_user_authority` VALUES (10, 23, 2);
INSERT INTO `t_user_authority` VALUES (11, 25, 2);
INSERT INTO `t_user_authority` VALUES (12, 25, 2);
INSERT INTO `t_user_authority` VALUES (13, 27, 2);
INSERT INTO `t_user_authority` VALUES (14, 28, 2);
INSERT INTO `t_user_authority` VALUES (15, 29, 2);
INSERT INTO `t_user_authority` VALUES (16, 30, 2);
INSERT INTO `t_user_authority` VALUES (17, 31, 2);
INSERT INTO `t_user_authority` VALUES (18, 33, 2);
INSERT INTO `t_user_authority` VALUES (19, 34, 2);
INSERT INTO `t_user_authority` VALUES (20, 35, 2);
INSERT INTO `t_user_authority` VALUES (21, 36, 2);
INSERT INTO `t_user_authority` VALUES (22, 37, 2);
INSERT INTO `t_user_authority` VALUES (23, 38, 2);
INSERT INTO `t_user_authority` VALUES (24, 39, 2);
INSERT INTO `t_user_authority` VALUES (25, 40, 2);
INSERT INTO `t_user_authority` VALUES (26, 40, 2);
INSERT INTO `t_user_authority` VALUES (27, 41, 2);
INSERT INTO `t_user_authority` VALUES (28, 42, 2);
INSERT INTO `t_user_authority` VALUES (29, 43, 2);
INSERT INTO `t_user_authority` VALUES (30, 44, 2);
INSERT INTO `t_user_authority` VALUES (31, 45, 2);
INSERT INTO `t_user_authority` VALUES (32, 46, 2);
INSERT INTO `t_user_authority` VALUES (33, 47, 2);
INSERT INTO `t_user_authority` VALUES (34, 48, 2);
INSERT INTO `t_user_authority` VALUES (35, 50, 2);
INSERT INTO `t_user_authority` VALUES (36, 51, 2);
INSERT INTO `t_user_authority` VALUES (37, 52, 2);
INSERT INTO `t_user_authority` VALUES (38, 53, 2);
INSERT INTO `t_user_authority` VALUES (39, 54, 2);
INSERT INTO `t_user_authority` VALUES (40, 55, 2);
INSERT INTO `t_user_authority` VALUES (41, 59, 2);
INSERT INTO `t_user_authority` VALUES (42, 60, 2);
INSERT INTO `t_user_authority` VALUES (43, 61, 2);
INSERT INTO `t_user_authority` VALUES (44, 61, 2);
INSERT INTO `t_user_authority` VALUES (45, 62, 2);

SET FOREIGN_KEY_CHECKS = 1;
