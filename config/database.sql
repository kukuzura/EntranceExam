create table role
(
    id   int auto_increment
        primary key,
    name varchar(50) not null,
    constraint role_name_uindex
        unique (name)
);

create table speciality
(
    id             int auto_increment
        primary key,
    name           varchar(50)      null,
    entering_grade double default 0 not null
);

create table subject
(
    id   int auto_increment
        primary key,
    name varchar(30) null
);

create table user
(
    id       int auto_increment
        primary key,
    login    varchar(50) null,
    password longblob    null
);

create table student
(
    passport_id varchar(10)                                                                        not null,
    first_name  varchar(30)                                                                        null,
    last_name   varchar(30)                                                                        null,
    patronymic  varchar(30)                                                                        null,
    user_id     int                                                                                null,
    id          int                                                                                not null,
    grade       double                                                       default 0             not null,
    status      enum ('NEW_STUDENT', 'PASS_EXAMS', 'ENTER', 'DID_NOT_ENTER') default 'NEW_STUDENT' null,
    constraint student_id_uindex
        unique (id),
    constraint student_user_id_uindex
        unique (user_id),
    constraint student_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

alter table student
    add primary key (id);

create table teacher
(
    id         int auto_increment
        primary key,
    first_name varchar(30) null,
    last_name  varchar(30) null,
    patronymic varchar(30) null,
    user_id    int         null,
    constraint teacher_user_id_fk
        foreign key (user_id) references user (id)
            on delete cascade
);

create table exam
(
    id            int auto_increment
        primary key,
    teacher_id    int                  null,
    subject_id    int                  null,
    speciality_id int                  null,
    is_graded     tinyint(1) default 0 null,
    constraint exam_speciality_id_fk
        foreign key (speciality_id) references speciality (id)
            on update cascade on delete set null,
    constraint exam_subject_id_fk
        foreign key (subject_id) references subject (id)
            on update cascade on delete set null,
    constraint exam_teacher_id_fk
        foreign key (teacher_id) references teacher (id)
            on update cascade on delete set null
);

create table grade
(
    student_id int           null,
    exam_id    int           null,
    grade      int default 0 null,
    id         int auto_increment
        primary key,
    constraint grade_exam_id_fk
        foreign key (exam_id) references exam (id)
            on update cascade on delete set null,
    constraint grade_student_id_fk
        foreign key (student_id) references student (id)
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

