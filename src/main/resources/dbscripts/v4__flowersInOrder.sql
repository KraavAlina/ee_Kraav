create table FLOWERS_IN_ORDER(
    id bigint primary key auto_increment,
    order_id bigint,
    flower_id bigint,
    count int check (count >= 0),
    price decimal check (price >= 0),
    foreign key (order_id) references ORDERS(id),
    foreign key (flower_id) references FLOWERS(id)
);


insert into FLOWERS_IN_ORDER values (null, 1, 1, 2, 400.00);
insert into FLOWERS_IN_ORDER values (null, 1, 2, 3, 451.50);
insert into FLOWERS_IN_ORDER values (null, 2, 4, 3, 750.00);
insert into FLOWERS_IN_ORDER values (null, 2, 5, 6, 900.00);
insert into FLOWERS_IN_ORDER values (null, 2, 3, 4, 601.00);
insert into FLOWERS_IN_ORDER values (null, 3, 4, 4, 1000.00);
insert into FLOWERS_IN_ORDER values (null, 3, 1, 5, 1000.00);
insert into FLOWERS_IN_ORDER values (null, 4, 5, 1, 150.00);
insert into FLOWERS_IN_ORDER values (null, 4, 2, 2, 301.00);

