DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, name VARCHAR(255), price integer, in_stock integer, PRIMARY KEY (id));
INSERT INTO products(name, price, in_stock) values ('Apple', 10, 2019);
INSERT INTO products(name, price, in_stock) values ('Pear', 30, 659);
INSERT INTO products(name, price, in_stock) values ('Orange', 5, 500);
INSERT INTO products(name, price, in_stock) values ('Grapes', 20, 1000);

DROP TABLE clients IF EXISTS;
CREATE TABLE IF NOT EXISTS clients
(
        id bigserial,
        first_name VARCHAR(255) not null ,
        last_name varchar(255),
        middle_name varchar(255),
        email varchar(255) not null,
        delivery_address varchar(500),
        PRIMARY KEY (id)
);
/*
INSERT INTO clients(name) values ('Katya');
INSERT INTO clients(name) values ('Yulia');
*/
DROP TABLE orders IF EXISTS;
CREATE TABLE IF NOT EXISTS orders
(
    id               bigserial,
    order_num        VARCHAR(255),
    state            integer, --new, payed
    client_id        bigint,
    delivery_address varchar(500),
    total            numeric,
    primary key (id), foreign key(client_id) references clients(id)
);
/*
INSERT INTO orders(order_num, client_id) values ('ORD-1',1);
INSERT INTO orders(order_num, client_id) values ('ORD-2',1);
INSERT INTO orders(order_num, client_id) values ('ORD-3',2);
INSERT INTO orders(order_num, client_id) values ('ORD-4',2);
*/
DROP TABLE order_spec IF EXISTS;
CREATE TABLE IF NOT EXISTS order_spec( id bigserial, order_id bigint,  product_id bigint, quantity integer,  price integer, primary key (id),    foreign key (order_id) references orders(id),    foreign key (product_id) references products(id));
/*INSERT INTO order_spec(order_id,product_id,quantity,price) values (1,1,2,10);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (1,2,3,5);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (2,3,4,20);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (2,4,5,46);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (3,2,6,12);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (3,3,7,45);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (4,4,8,30);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (4,1,9,32);
*/
drop table cart if exists;
create table if not exists cart
(
    id bigserial,
    session_id varchar(32), --uuid
    client_id bigint,
    product_id bigint not null,
    quantity integer not null,
    price integer not null,
    total integer not null,
    primary key(id),
    foreign key (product_id) references products(id),
    foreign key (client_id) references clients(id)
);


--Админка
create table users
(
    id bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    created_At timestamp default current_timestamp,
    updated_At timestamp default current_timestamp,
    primary key (id)
);

create table roles
(
    id serial,
    name varchar(30) not null,
    created_At timestamp default current_timestamp,
    updated_At timestamp default current_timestamp,
    primary key (id)
);

create table users_roles(
    user_id bigint not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);
/*
insert into roles (name)
values('ROLE_USER'), ('ROLE_ADMIN');

insert into users(username, password)
values('user','$2a$12$YYrnrwuM0PMdIdaJG1Pf4OSKKkT90ONSdq0O05geJT3aBeT0lJVdy');
values('admin','$2a$12$YYrnrwuM0PMdIdaJG1Pf4OSKKkT90ONSdq0O05geJT3aBeT0lJVdy');

insert into users_roles values(1,1);values(2,2);*/
