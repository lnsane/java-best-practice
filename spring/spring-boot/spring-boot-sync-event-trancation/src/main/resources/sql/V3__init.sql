create table `order`
(
    id          varchar(60) not null
        primary key,
    order_name  varchar(255) null,
    state       int null comment '1 , 2, ,3 ',
    create_time datetime null,
    update_time datetime null
);