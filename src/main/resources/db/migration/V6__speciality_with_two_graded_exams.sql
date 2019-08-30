insert into user
values (15, 'user11', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (16, 'user12', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (17, 'user13', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (18, 'user14', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (19, 'user15', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (20, 'user16', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (21, 'user17', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (22, 'user18', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (23, 'user19', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (24, 'user20', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (25, 'user21', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (26, 'user22', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');


insert into user_role
values (15, 1);
insert into user_role
values (16, 1);
insert into user_role
values (17, 1);
insert into user_role
values (18, 1);
insert into user_role
values (19, 1);
insert into user_role
values (20, 1);
insert into user_role
values (21, 1);
insert into user_role
values (22, 1);
insert into user_role
values (23, 1);
insert into user_role
values (24, 1);
insert into user_role
values (25, 1);
insert into user_role
values (26, 1);

insert into student
values (312345678, 'Яковиченко', ' Лилия ', 'Анатолиевна', 15, 12, 2, 'PASS_EXAMS');
insert into student
values (13456864, 'Науменко', 'Екатерина', 'Александровна ', 16, 13, 4, 'PASS_EXAMS');
insert into student
values (12120686, 'Смехова', 'Ирина', 'Евгениевна', 17, 14, 6, 'PASS_EXAMS');
insert into student
values (32406864, 'Седыха', 'Рада', 'Захаровна', 18, 15, 8, 'PASS_EXAMS');
insert into student
values (89406864, 'Косомов', 'Остап', 'Онуфриевич', 19, 16, 10, 'PASS_EXAMS');
insert into student
values (56406864, 'Гавриленкова', 'Марианна', 'Петровна', 20, 17, 12, 'PASS_EXAMS');
insert into student
values (22456784, 'Зайцев ', 'Захар', 'Венедиктович', 21, 18, 14, 'PASS_EXAMS');
insert into student
values (21956784, 'Викаш', 'Григорий', 'Остапович', 22, 19, 16, 'PASS_EXAMS');
insert into student
values (67256784, 'Воскобойников', 'Анатолий', 'Адамович', 23, 20, 18, 'PASS_EXAMS');
insert into student
values (80476478, 'Мелехов', 'Юрий', 'Капитонович', 24, 21, 20, 'PASS_EXAMS');
insert into student
values (23816784, 'Дьяков', 'Архип', 'Ираклиевич', 25, 22, 22, 'PASS_EXAMS');
insert into student
values (23890784, 'Никитин', 'Виктор', 'Андреевич', 26, 23, 22, 'PASS_EXAMS');


update exam is_graded
set is_graded = 1
where id = 2;
update exam is_graded
set is_graded = 1
where id = 5;

insert into grade
values (12, 2, 1, 34);
insert into grade
values (13, 2, 1, 35);
insert into grade
values (14, 2, 0, 36);
insert into grade
values (15, 2, 2, 37);
insert into grade
values (16, 2, 2, 38);
insert into grade
values (17, 2, 0, 39);
insert into grade
values (18, 2, 3, 40);
insert into grade
values (19, 2, 3, 41);
insert into grade
values (20, 2, 0, 42);
insert into grade
values (21, 2, 4, 43);
insert into grade
values (22, 2, 4, 44);
insert into grade
values (23, 5, 0, 45);
insert into grade
values (12, 5, 5, 46);
insert into grade
values (13, 5, 5, 47);
insert into grade
values (14, 5, 0, 48);
insert into grade
values (15, 5, 6, 49);
insert into grade
values (16, 5, 6, 50);
insert into grade
values (17, 5, 0, 51);
insert into grade
values (18, 5, 7, 52);
insert into grade
values (19, 5, 7, 53);
insert into grade
values (20, 5, 0, 54);
insert into grade
values (21, 5, 8, 55);
insert into grade
values (22, 8, 8, 56);
insert into grade
values (23, 8, 0, 57);
insert into grade
values (12, 8, 9, 58);
insert into grade
values (13, 8, 9, 59);
insert into grade
values (14, 8, 0, 60);
insert into grade
values (15, 8, 10, 61);
insert into grade
values (16, 8, 10, 62);
insert into grade
values (17, 8, 0, 63);
insert into grade
values (18, 8, 11, 64);
insert into grade
values (19, 8, 11, 65);
insert into grade
values (20, 8, 0, 67);
insert into grade
values (21, 8, 12, 68);
insert into grade
values (22, 8, 12, 69);
insert into grade
values (23, 8, 0, 66);