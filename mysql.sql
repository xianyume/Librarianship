DROP DATABASE IF EXISTS librarianship;
CREATE DATABASE librarianship
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE librarianship;
DROP TABLE IF EXISTS `book`;
DROP TABLE IF EXISTS `form`;

CREATE TABLE `librarianship`.`book` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '书籍编号' ,
  `name` varchar(255) NULL COMMENT '书籍名称',
  `writer` varchar(255) NULL COMMENT '作者',
  `form` int NULL COMMENT '书籍分类',
  `description` varchar(255) NULL COMMENT '书籍介绍',
  `publisher` varchar(255) NULL COMMENT '出版社',
  `create_time` datetime NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`id` DESC)
);
INSERT INTO `librarianship`.`book` (`name`, `writer`, `form`, `description`, `publisher`, `create_time`, `update_time`)
VALUES ('呐喊', '鲁迅', '2', '短篇小说集。','北京新潮社', NOW(), NOW());
INSERT INTO `librarianship`.`book` (`name`, `writer`, `form`, `description`, `publisher`, `create_time`, `update_time`)
VALUES ('西游记', '吴承恩', '1', '明代中期长篇章回体小说，是我国神魔小说的典范性作品。','人民文学出版社', NOW(), NOW());

CREATE TABLE `librarianship`.`form` (
  `form_id` int NOT NULL AUTO_INCREMENT COMMENT '书籍类别' ,
  `form_name` varchar(255) NULL COMMENT '书籍类别名称',
  `form_description` varchar(255) NULL COMMENT '书籍类别介绍',
  `create_time` datetime NULL,
  `update_time` datetime NULL,
  PRIMARY KEY (`form_id` DESC)
);

INSERT INTO `librarianship`.`form` (`form_name`, `form_description`, `create_time`, `update_time`)
VALUES ('古典文学', '中国古典文学是中国文学史上闪烁着灿烂光辉的经典性作品或优秀作品，它是世界文学宝库中令人瞩目的瑰宝。', NOW(), NOW());
INSERT INTO `librarianship`.`form` (`form_name`, `form_description`, `create_time`, `update_time`)
VALUES ('近代文学', '近代文学，指1840年鸦片战争至1919年五四运动前夕的文学，即中国现代化孕育期的文学，反映了中国文学挥别传统、重塑现代的特殊精神追求。', NOW(), NOW());