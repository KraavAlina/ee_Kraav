create table FLOWERS(
    id bigint primary key auto_increment,
    title varchar(30) not null,
    price decimal check (price >= 0),
    count int check (count >= 0),
    image varchar(255)
);

insert into FLOWERS values (null, 'Роза', 200, 200, '/static/images/rose.jpg');
insert into FLOWERS values (null, 'Ромашка', 150.5, 300, '/static/images/chamomile.jpg');
insert into FLOWERS values (null, 'Георгина', 150.25, 300, '/static/images/georgina.jpg');
insert into FLOWERS values (null, 'Лилия', 250, 100, '/static/images/lily.jpg');
insert into FLOWERS values (null, 'Пион', 150, 300, '/static/images/peony.jpg');