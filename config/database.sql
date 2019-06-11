create table user
(
    id       int auto_increment
        primary key,
    login    varchar(50) null,
    password longblob    null
);


create table role
(
    id   int auto_increment
        primary key,
    name varchar(50) not null,
    constraint role_name_uindex
        unique (name)
);

create table user_role
(
    user_id int null,
    role_id int null,
    constraint user_role_role_id_fk
        foreign key (role_id) references role (id),
    constraint user_role_user_id_fk
        foreign key (user_id) references user (id)
);