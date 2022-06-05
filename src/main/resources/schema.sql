create table tb_list(
	list_no int auto_increment primary key,
	list_title varchar(300),
	list_content varchar(500),
	list_date DATETIME default CURRENT_TIMESTAMP
);


insert into tb_list(list_title, list_content, list_date)
values('글제목1','글내용1',CURRENT_TIMESTAMP);
insert into tb_list(list_title, list_content, list_date)
values('글제목2','글내용2',CURRENT_TIMESTAMP);
insert into tb_list(list_title, list_content, list_date)
values('글제목3','글내용3',CURRENT_TIMESTAMP);
