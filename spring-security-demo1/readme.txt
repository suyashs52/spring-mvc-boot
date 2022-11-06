Installing mysql zip file

unzip the zip file
add location upto bin to env variable
create mydata folder
open cmd
mysqld --console --initialize --basedir=C:\Users\suysingh\Downloads\MySQL --datadir=C:\Users\suysingh\Downloads\MySQLData
mysqld --console --datadir=C:\Users\suysingh\Downloads\MySQLData
open another cmd
mysql -u root -p

change temp password 
alter user 'root'@'localhost' identified by 's';

show databases

create user 'hbstudent'@'localhost' identified by 'hbstudent';
 grant all privileges on * . * to 'hbstudent'@'localhost';

mysql -u hbstudent-p
------------spring mvc---------------------------
create database hb_student_tracker;
 use hb_student_tracker
create table student(id int(11) not null auto_increment,first_name varchar(45) default null, last_name varchar(45) default null, email varchar(45) default null, primary key(id))Engine=InnoDB auto_increment=6 default charset=latin1;


using hibernate 5.6.5 add required lib in lib sec
download driver from https://dev.mysql.com/
https://dev.mysql.com/downloads/connector/j/
download plateform independent zip file 
add lib into java project build class path


 alter table student auto_increment=3000;
 truncate student;// reset auto increment
 
  create table instructor_detail( id int(11) not null auto_increment,youtube_channel varchar(128) default null, hobby varchar(45) default null, primary key(id));
 create table instructor( id int(11) not null auto_increment,first_name varchar(45) default null, 
 last_name varchar(45) default null,email varchar(45) default null, instructor_detail_id int default null,   primary key(id));

alter table instructor add constraint fk_detail foreign key(instructor_detail_id) references instructor_detail(id);

show tables;



create table course(id int not null auto_increment, title varchar(45) default null, instructor_id int default null,
primary key(id), unique key(title));

alter table course add constraint fk_course_detail foreign key(instructor_id)
 references instructor(id);
 
 
 
 create table review(id int not null auto_increment, comment varchar(256) default null,course_id int default null,
 key fk_course_id_dtl(course_id), constraint fk_constraint foreign key(course_id)
 references course(id),primary key(id));
 
 
 create table course_student(
 course_id int not null,
 student_id int not null,
 primary key(course_id,student_id),
 constraint fk_id_course_student foreign key(course_id) references course(id),
  constraint fk_course_id_student foreign key(student_id) references student(id)

);



create user 'springstudent'@'localhost' identified by 'springstudent';
 grant all privileges on * . * to 'springstudent'@'localhost';

 create database web_customer_tracker
 
  create table customer( id int(11) not null auto_increment,first_name varchar(45) default null, 
 last_name varchar(45) default null,email varchar(45) default null,   primary key(id));
 
 insert into customer values(1,'David','Adams','david@gaml.com');
 
8TjyADX*cSc6



------spring security------------
create user 'springstudent'@'localhost' identified by 'springstudent';
ALTER USER 'springstudent'@'localhost' IDENTIFIED WITH mysql_native_password BY 'springstudent';
 grant all privileges on * . * to 'springstudent'@'localhost';
create database spring_security_demo_text;
use spring_security_demo_text;

create table users(username varchar(50) not null, password varchar(50) not null,
enabled tinyint(1) not null, primary key(username));
{noop} encoding algo means no operation
insert into users values('john','{noop}test123',1),('mary','{noop}test123',1),('susan','{noop}test123',1);

create table authorities(username varchar(50) not null,authority varchar(50),
unique key   (username,authority),
constraint   foreign key(username) references users(username));

insert into authorities values('john','ROLE_EMPLOYEE'),('mary','ROLE_EMPLOYEE'),('mary','ROLE_MANAGER'),('susan','ROLE_EMPLOYEE'),('susan','ROLE_ADMIN');

drop table authorities;
drop table users;

create table users(username varchar(50) not null, password char(68) not null,
enabled tinyint(1) not null, primary key(username));

insert into users values
('john','{bcrypt}$2a$12$78257rVNBsrtzpflyNy0se1m9AfHvtlIKy.Or4TKmgbLCDxGPSblS',1),
('mary','{bcrypt}$2a$12$78257rVNBsrtzpflyNy0se1m9AfHvtlIKy.Or4TKmgbLCDxGPSblS',1),
('susan','{bcrypt}$2a$12$78257rVNBsrtzpflyNy0se1m9AfHvtlIKy.Or4TKmgbLCDxGPSblS',1);

  create table customer( id int(11) not null auto_increment,first_name varchar(45) default null, 
 last_name varchar(45) default null,email varchar(45) default null,   primary key(id));
 
 insert into customer values(1,'David','Adams','david@gaml.com');
 
 
