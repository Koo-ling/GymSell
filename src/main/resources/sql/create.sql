-- 创建数据库
CREATE DATABASE gymsell;

USE gymsell;

-- 创建表
-- 用户表
CREATE TABLE `user_`
(
    `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `name` varchar(64) NOT NULL COMMENT '用户姓名',
    `password` varchar(20) NOT NULL COMMENT '用户密码',
    `role` int(2) NOT NULL DEFAULT '0' COMMENT '权限',
    `sex` char(2) DEFAULT NOT NULL COMMENT '性别',
    `address` varchar(64) DEFAULT NOT NULL COMMENT '地址',
    `phone` varchar(11) NOT NULL COMMENT '手机号',
    `email` varchar(32) NOT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 10001 DEFAULT CHARSET = UTF8;

-- 比赛场馆信息表
CREATE TABLE `gym_info`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `gym_id` int NOT NULL COMMENT '比赛场馆信息id',
    `name` varchar(64) NOT NULL COMMENT '场馆名称',
    `location` varchar(64) NOT NULL COMMENT '地理位置',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

-- 比赛场馆信息座席信息表
CREATE TABLE `gym_site`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `gym_id` int NOT NULL COMMENT '比赛场馆信息表',
    `gym_name` varchar(64) NOT NULL COMMENT '场馆名称',
    `site_id` int NOT NULL COMMENT '座席id',
    `site_level` int(2) NOT NULL COMMENT '座席等级,0为贵宾,1为标准,2为低价',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

-- 赛事信息表
CREATE TABLE `game_info`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `game_id` int NOT NULL COMMENT '比赛场次id',
    `game_name` varchar(64) NOT NULL COMMENT '比赛名称',
    `game_type` varchar(64) NOT NULL COMMENT '比赛类型',
    `game_organizer` varchar(64) NOT NULL COMMENT '赛事组织者',
    `game_member` varchar(64) NOT NULL COMMENT '赛事参加者',
    `game_time` datetime NOT NULL COMMENT '赛事时间',
    `game_location` varchar(64) NOT NULL COMMENT '比赛场馆',
    `game_result` varchar(32) NOT NULL COMMENT '比赛结果',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

-- 赛事票信息
CREATE TABLE `game_ticket`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `game_id` int NOT NULL COMMENT '比赛场次id',
    `ticket_money` decimal(10, 2) NOT NULL COMMENT '比赛金额',
    `ticket_quantity` int NOT NULL COMMENT '票源数量',
    `ticket_createTime` varchar(32) NOT NULL COMMENT '售票开始时间',
    `ticket_closeTime` varchar(32) NOT NULL COMMENT '售票结束时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;

-- 留言板
CREATE TABLE `message`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(32) NOT NULL COMMENT '留言标题',
    `author` varchar(64) NOT NULL COMMENT '留言人',
    `text` text NOT NULL COMMENT '留言内容',
    `create_time` datetime NOT NULL COMMENT '留言创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE message
(
    id int not null,
    message_id int not null comment '留言主题id',
    text varchar(255) not null comment '留言内容',
    create_time timestamp not null default current_timestamp comment '留言时间',
    constraint message_pk
        primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = UTF8;
