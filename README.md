# Librarianship
我和朋友一起的期末作业

后端：SpringBoot 3.30、Mybatis、MySQL

前端：Vue3、Vue Router
## 默认管理账号密码
账号：admin

密码：123456
## MySQL数据表结构
### book表
|     字段      | 类型  |   介绍   |  别名  |
|:-----------:|:---:|:------:|:----:|
|     id      | int | 非空自增主键 | 书籍编号 |
|    name     |varchar(255)|| 书籍名称 |
|   writer    |varchar(255)||  作者  |
|    form     |int|| 书籍分类 |
| description |varchar(255)|| 书籍介绍 |
| publisher |varchar(255)|| 出版社  |
| create_time |datetime|| 创建日期 |
| update_time |datetime|| 修改日期 |
### form表
|        字段        | 类型  |   介绍   |  别名  |
|:----------------:|:---:|:------:|:----:|
|     form_id      | int | 非空自增主键 | 书籍编号 |
|    form_name     |varchar(255)|| 分类名称 |
| form_description |varchar(255)|| 分类介绍 |
| create_time |datetime|| 创建日期 |
| update_time |datetime|| 修改日期 |
### user表
|     字段      |      类型      |   介绍   |        别名        |
|:-----------:|:------------:|:------:|:----------------:|
|     id      |     int      | 非空自增主键 |       用户编号       |
|  username   |     int      |        |        账号        |
|  password   | varchar(255) | MD5加密  |        密码        |
| create_time |   datetime   |        |       创建日期       |
| update_time |   datetime   |        |       修改日期       |