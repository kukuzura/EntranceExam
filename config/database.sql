create table user
(
    id       int auto_increment primary key,
    login    varchar(50) null,
    password longblob    null
);


create table role
(
    id   int auto_increment primary key,
    name varchar(50) not null,
    constraint role_name_uindex unique (name)
);

create table student
(
    id   int auto_increment primary key,
    passport_id varchar(10) not null primary key,
    first_name  varchar(30) null,
    last_name   varchar(30) null,
    patronymic  varchar(30) null,
    user_id     int         null,
    constraint student_user_id_uindex unique (user_id),
    constraint student_user_id_fk foreign key (user_id)
        references user (id)
        on update cascade on delete cascade
);

create table user_role
(
    user_id int null,
    role_id int null,
    constraint user_role_role_id_fk foreign key (role_id) references role (id),
    constraint user_role_user_id_fk foreign key (user_id) references user (id)
);