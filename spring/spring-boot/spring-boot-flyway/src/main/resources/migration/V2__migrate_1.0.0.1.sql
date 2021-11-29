alter table `user`
    add t_name1 varchar(2000) null;

alter table `user`
    add t_name2 varchar(2000) null;

update `user`
set `user`.t_name1 = `user`.id;

update `user`
set `user`.t_name2 = `user`.username;


