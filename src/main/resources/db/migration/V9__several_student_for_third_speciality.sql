insert into user
values (27, 'user24', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (28, 'user25', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (29, 'user26', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (30, 'user27', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (31, 'user28', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');
insert into user
values (32, 'user29', '$2a$11$W9qSly4OW6RF6ioxJNpvK.NAt8NVmYFFAuqWNzRmv7CY0GomETnJ2');

insert into user_role
values (27, 1);
insert into user_role
values (28, 1);
insert into user_role
values (29, 1);
insert into user_role
values (30, 1);
insert into user_role
values (31, 1);
insert into user_role
values (32, 1);

insert into student
values (12312378, 'Прокопович', 'Андрей', 'Николаевич', 27, 24, 0, 'NEW_STUDENT');
insert into student
values (22456864, 'Васнецова', 'Елена', 'Алексеевна', 28, 25, 0, 'NEW_STUDENT');
insert into student
values (69006864, 'Иванов', 'Вячеслав', 'Владимирович', 29, 26, 0, 'NEW_STUDENT');
insert into student
values (29506864, 'Баканов', 'Сергей', 'Александрович', 30, 27, 0, 'NEW_STUDENT');
insert into student
values (09306864, 'Рязанова', 'Мария', 'Вительевна', 31, 28, 0, 'NEW_STUDENT');
insert into student
values (32506864, 'Архипенко', 'Евгения', 'Чеслававна', 32, 29, 0, 'NEW_STUDENT');

insert into grade
values (24, 3, 0, 72);
insert into grade
values (25, 3, 0, 73);
insert into grade
values (26, 3, 0, 74);
insert into grade
values (27, 3, 0, 75);
insert into grade
values (28, 3, 0, 76);
insert into grade
values (29, 3, 0, 77);

insert into grade
values (24, 6, 0, 78);
insert into grade
values (25, 6, 0, 79);
insert into grade
values (26, 6, 0, 80);
insert into grade
values (27, 6, 0, 81);
insert into grade
values (28, 6, 0, 82);
insert into grade
values (29, 6, 0, 83);

insert into grade
values (24, 9, 0, 84);
insert into grade
values (25, 9, 0, 85);
insert into grade
values (26, 9, 0, 86);
insert into grade
values (27, 9, 0, 87);
insert into grade
values (28, 9, 0, 88);
insert into grade
values (29, 9, 0, 89);

update exam
set speciality_id=3
where id = 3
   or id = 6
   or id = 9;

update exam
set subject_id=2
where id = 3;

update exam
set teacher_id=1
where id = 3;

update exam
set subject_id=3
where id = 6;

update exam
set subject_id=4
where id = 9;

update exam
set speciality_id=1
where id = 7;

update exam
set speciality_id=2
where id = 8

