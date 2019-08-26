create table USERS(
    login varchar(30) primary key,
    password varchar(30) not null,
    fullName varchar(50) not null,
    address varchar(50),
    phone varchar(20),
    balance decimal check (balance >= 0),
    discount int check (discount >= 0)
);

insert into USERS values('admin', 'admin123', 'admin', 'unknown', '+0(000)000-00-00', 0, 0);
insert into USERS values('alina', '123', 'Алина', 'г. Тверь, ул. Можайского, д.53, кв.5', '+7(980)641-1970', 2000, 5);