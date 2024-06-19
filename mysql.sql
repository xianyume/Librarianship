DROP DATABASE IF EXISTS librarianship;
CREATE DATABASE librarianship
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE librarianship;
DROP TABLE IF EXISTS `book`;
DROP TABLE IF EXISTS `form`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `librarianship`.`book` (
                                        `id` int NOT NULL AUTO_INCREMENT COMMENT '书籍编号' ,
                                        `name` varchar(255) NULL COMMENT '书籍名称',
                                        `author` varchar(255) NULL COMMENT '作者',
                                        `form` int NULL COMMENT '书籍分类',
                                        `description` varchar(255) NULL COMMENT '书籍介绍',
                                        `publisher` varchar(255) NULL COMMENT '出版社',
                                        `create_time` datetime NULL,
                                        `update_time` datetime NULL,
                                        PRIMARY KEY (`id` ASC)
);
INSERT INTO `librarianship`.`book` (`name`, `author`, `form`, `description`, `publisher`, `create_time`, `update_time`)
VALUES ('呐喊', '鲁迅', '2', '短篇小说集。','北京新潮社', NOW(), NOW());
INSERT INTO `librarianship`.`book` (`name`, `author`, `form`, `description`, `publisher`, `create_time`, `update_time`)
VALUES ('西游记', '吴承恩', '1', '明代中期长篇章回体小说，是我国神魔小说的典范性作品。','人民文学出版社', NOW(), NOW());

CREATE TABLE `librarianship`.`form` (
                                        `id` int NOT NULL AUTO_INCREMENT COMMENT '书籍类别' ,
                                        `name` varchar(255) NULL COMMENT '书籍类别名称',
                                        `description` varchar(255) NULL COMMENT '书籍类别介绍',
                                        `create_time` datetime NULL,
                                        `update_time` datetime NULL,
                                        PRIMARY KEY (`id` ASC)
);

INSERT INTO `librarianship`.`form` (`name`, `description`, `create_time`, `update_time`)
VALUES ('无分类', '全部书籍算作此分类', NOW(), NOW());
INSERT INTO `librarianship`.`form` (`name`, `description`, `create_time`, `update_time`)
VALUES ('近代文学', '近代文学，指1840年鸦片战争至1919年五四运动前夕的文学，即中国现代化孕育期的文学，反映了中国文学挥别传统、重塑现代的特殊精神追求。', NOW(), NOW());
INSERT INTO `librarianship`.`form` (`name`, `description`, `create_time`, `update_time`)
VALUES ('古典文学', '中国古典文学是中国文学史上闪烁着灿烂光辉的经典性作品或优秀作品，它是世界文学宝库中令人瞩目的瑰宝。', NOW(), NOW());

CREATE TABLE `librarianship`.`user`  (
                                         `id` int NOT NULL AUTO_INCREMENT COMMENT '用户编号',
                                         `username` varchar(255) NULL COMMENT '账号',
                                         `nickname` varchar(255) NULL COMMENT '昵称',
                                         `password` varchar(255) NULL COMMENT '密码',
                                         `permission` int NULL COMMENT '用户权限',
                                         `create_time` datetime NULL COMMENT '创建日期',
                                         `update_time` datetime NULL COMMENT '更新日期',
                                         PRIMARY KEY (`id` ASC)
);

-- 管理员账号--
-- 123456 的 md5 为 e10adc3949ba59abbe56e057f20f883e --
INSERT INTO `librarianship`.`user` (`username`, `nickname`, `password`, `permission`,`create_time`, `update_time`)
VALUES ('admin', '管理员admin', 'e10adc3949ba59abbe56e057f20f883e', '2', NOW(), NOW());

-- 测试账号 --
-- 88888888 的 md5 为 8ddcff3a80f4189ca1c9d4d902c3c909 --
INSERT INTO `librarianship`.`user` (`username`, `nickname`, `password`, `permission`,`create_time`, `update_time`)
VALUES ('ceshi1', '普通用户1', '8ddcff3a80f4189ca1c9d4d902c3c909', '0', NOW(), NOW());
