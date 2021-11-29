create table if not exists test.`user`
(
    id          varchar(60)  not null comment '主键',
    username    varchar(255) not null comment '姓名',
    sex         tinyint(1)   not null default '0' comment '性别 0 -> 未知 1-> 男 2-> 女',
    create_time datetime     not null comment '创建时间',
    update_time datetime     not null comment '更新时间',
    constraint user_pk
        primary key (id)
) comment '用户表';