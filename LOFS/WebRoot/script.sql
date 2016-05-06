drop table if exists t_user;
create table t_user(
id bigint primary key auto_increment,
username varchar(20) unique,
password varchar(10),
name varchar(20),
age int(3),
gendar char(1),
phone varchar(20));

drop table if exists t_pic;
create table t_pic(
id bigint primary key auto_increment,
picName varchar(100),
userId bigint
);

drop table if exists t_basic;
create table t_basic(
	id bigint primary key auto_increment,
	stature varchar(3),
	education char(1),
	marriage char(1),
	salary char(1),
	province varchar(2),
	city varchar(2),
	house char(1),
	car char(1),
	userId bigint
);

drop table if exists t_choose;
create table t_choose(
	id bigint primary key auto_increment,
	stature char(1),
	education char(1),
	marriage char(1),
	province varchar(2),
	city varchar(2),
	userId bigint
);

drop table if exists t_note;
create table t_note(
id bigint primary key auto_increment,
note text,
userId bigint);

drop table if exists t_message;
create table t_message(
	id bigint primary key auto_increment,
	sendId bigint,
	sendName varchar(20),
	receiverId bigint,
	content varchar(255),
	status tinyint
);

drop table if exists t_mail;
create table t_mail(
	id bigint primary key auto_increment,
	sendId bigint,
	sendName varchar(20),
	sendTime datetime,
	receiverId bigint,
	title varchar(50),
	content text,
	status tinyint
);




