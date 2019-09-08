alter table subject modify column name varchar(30) unique ;

alter table speciality modify column name varchar(50) unique ;

alter table user modify column login varchar(30) unique ;

alter table speciality modify column  name varchar(50) not null;

alter table subject modify column name varchar(30) not null;

alter table student modify column first_name varchar(30) not null;

alter table student modify column last_name varchar(30) not null;

alter table student modify column patronymic varchar(30) not null;

alter table teacher modify column first_name varchar(30) not null;

alter table teacher modify column last_name varchar(30) not null;

alter table teacher modify column patronymic varchar(30) not null;

alter table user modify column login varchar(30) not null;
