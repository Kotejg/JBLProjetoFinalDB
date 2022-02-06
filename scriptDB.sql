create database db_final_project;
use db_final_project; 
create table users(
id int(3) not null auto_increment, 
nome varchar (120) not null, 
email varchar(220) not null, 
telefone varchar(20) null,
pais varchar(220),
primary key (id) 
); 

select * from users;
 drop table users;
show tables;
