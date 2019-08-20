use examsdb;

INSERT INTO subject
values (1, 'subject_1');
INSERT INTO subject
values (2, 'subject_2');
INSERT INTO subject
values (3, 'subject_3');
INSERT INTO subject
values (4, 'subject_4');
INSERT INTO subject
values (5, 'subject_5');

INSERT into role
values (1, 'ROLE_STUDENT');
INSERT into role
values (2, 'ROLE_TEACHER');

insert into user
values (1, 'user', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (2, 'user1', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (3, 'user2', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (4, 'user3', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (5, 'user4', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (6, 'user5', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (7, 'user6', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (8, 'user7', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (9, 'user8', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (10, 'user9', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (11, 'user10', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (12, 'teacher', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (13, 'teacher2', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');
insert into user
values (14, 'teacher3', '$2y$12$zrKXSo4qiLjcpfubuyFxLuA0t7DeV8qlZuptV0S3Owh4PxAvNC/i6');

insert into user_role
values (1, 1);
insert into user_role
values (2, 1);
insert into user_role
values (3, 1);
insert into user_role
values (4, 1);
insert into user_role
values (5, 1);
insert into user_role
values (6, 1);
insert into user_role
values (7, 1);
insert into user_role
values (8, 1);
insert into user_role
values (9, 1);
insert into user_role
values (10, 1);
insert into user_role
values (11, 1);
insert into user_role
values (12, 2);
insert into user_role
values (13, 2);
insert into user_role
values (14, 2);

insert into student
values (12345678, 'Нестеров', 'Мирон', 'Миронович', 1, 1, 0, 'NEW_STUDENT');
insert into student
values (12456864, 'Васнецова', 'Любава', 'Алексеевна', 2, 2, 0, 'NEW_STUDENT');
insert into student
values (12406864, 'Якимович', 'Ростислав', 'Давыдович', 3, 3, 0, 'NEW_STUDENT');
insert into student
values (22406864, ' Седыха', 'Рада', 'Захаровна', 4, 4, 0, 'NEW_STUDENT');
insert into student
values (22406864, 'Скуратова', 'Любава', 'Антониновна', 5, 5, 0, 'NEW_STUDENT');
insert into student
values (82406864, 'Рябов', 'Арсений', 'Остапович', 6, 6, 0, 'NEW_STUDENT');
insert into student
values (82456784, 'Пугачёв', 'Святослав', 'Климентович', 7, 7, 0, 'NEW_STUDENT');
insert into student
values (80956784, 'Буров', 'Иосиф', 'Николаевич', 8, 8, 0, 'NEW_STUDENT');
insert into student
values (80956784, 'Бобкова', 'Роза', 'Юлиевна', 9, 9, 0, 'NEW_STUDENT');
insert into student
values (80764784, 'Ярова', 'Алиса', 'Олеговна', 10, 10, 0, 'NEW_STUDENT');
insert into student
values (83216784, 'Царицын', 'Казимир', 'Аполлинариевич', 11, 11, 0, 'NEW_STUDENT');
insert into teacher
values (1, 'Карташёв', 'Капитон', 'Аникитевич', 12);
insert into teacher
values (2, 'Строганов', 'Виктор', 'Несторович', 13);
insert into teacher
values (3, 'Берлунова', 'Софья', 'Елисеевна', 14);

insert into exam
values (1, 1, 1, 1, 0);
insert into exam
values (2, 2, 2, 1, 0);
insert into exam
values (3, 3, 3, 1, 0);
insert into exam
values (4, 1, 1, 2, 0);
insert into exam
values (5, 2, 2, 2, 0);
insert into exam
values (6, 3, 3, 2, 0);
insert into exam
values (7, 1, 1, 3, 0);
insert into exam
values (8, 2, 4, 3, 0);
insert into exam
values (9, 3, 3, 3, 0);

insert into grade
values (1, 1, 0, 1);
insert into grade
values (2, 1, 0, 2);
insert into grade
values (3, 1, 0, 3);
insert into grade
values (4, 1, 0, 4);
insert into grade
values (5, 1, 0, 5);
insert into grade
values (6, 1, 0, 6);
insert into grade
values (7, 1, 0, 7);
insert into grade
values (8, 1, 0, 8);
insert into grade
values (9, 1, 0, 9);
insert into grade
values (10, 1, 0, 10);
insert into grade
values (11, 1, 0, 11);