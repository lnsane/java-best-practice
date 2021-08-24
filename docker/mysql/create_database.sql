# 查看所有数据库
show databases;

# 使用 information_schema 数据库
use information_schema;

# 查看所有的表
show tables;

# 查看所有的编码方式
select *
from CHARACTER_SETS;

# 查看关于utf8的编码类型
select *
from CHARACTER_SETS
where CHARACTER_SET_NAME like '%utf8%';

# 查看所有的列的编码格式
select *
from COLLATION_CHARACTER_SET_APPLICABILITY;


# 查询所有的utf8的列的编码格式
select *
from COLLATION_CHARACTER_SET_APPLICABILITY
         inner join
     (select CHARACTER_SET_NAME as chart
      from CHARACTER_SETS
      where CHARACTER_SET_NAME like '%utf8%') as charts on CHARACTER_SET_NAME = charts.chart;

# 删除一下test数据库
drop database if exists `test`;

# 创建数据库
create database if not exists `test`
    character set utf8mb4
    collate utf8mb4_general_ci;

