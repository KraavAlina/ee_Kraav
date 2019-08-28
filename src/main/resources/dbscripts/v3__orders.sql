create table ORDERS(
    id bigint primary key auto_increment,
    owner_login varchar(30),
    status varchar(10) check (status in ('CREATED', 'PAID', 'CLOSED')),
    fullPrice decimal not null check (fullPrice >= 0),
    discountPrice decimal not null check (discountPrice >= 0),
    dateCreation timestamp not null,
    dateClosing timestamp,
    foreign key (owner_login) references USERS(login)
);

insert into ORDERS values (null, 'alina', 'CREATED', 851.5, 808.93, '2019-04-15 10:00:00', null);
insert into ORDERS values (null, 'alina', 'CLOSED', 2251, 2138.45,'2019-03-15 10:00:00', '2019-03-17 10:00:00');
insert into ORDERS values (null, 'alina', 'PAID', 2000, 1900,'2019-04-15 12:00:00', null);
insert into ORDERS values (null, 'alex', 'CREATED', 451, 419.43, '2019-04-13 12:00:00', null);