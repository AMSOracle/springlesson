DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, name VARCHAR(255), price integer , PRIMARY KEY (id));
INSERT INTO products(name, price) values ('Apple', 10);
INSERT INTO products(name, price) values ('Pear', 30);
INSERT INTO products(name, price) values ('Orange', 5);
INSERT INTO products(name, price) values ('Grapes', 20);

DROP TABLE clients IF EXISTS;
CREATE TABLE IF NOT EXISTS clients (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO clients(name) values ('Katya');
INSERT INTO clients(name) values ('Yulia');

DROP TABLE orders IF EXISTS;
CREATE TABLE IF NOT EXISTS orders( id bigserial, order_num VARCHAR(255), client_id bigint, primary key (id), foreign key(client_id) references clients(id));
INSERT INTO orders(order_num, client_id) values ('ORD-1',1);
INSERT INTO orders(order_num, client_id) values ('ORD-2',1);
INSERT INTO orders(order_num, client_id) values ('ORD-3',2);
INSERT INTO orders(order_num, client_id) values ('ORD-4',2);

DROP TABLE order_spec IF EXISTS;
CREATE TABLE IF NOT EXISTS order_spec( id bigserial, order_id bigint,  product_id bigint, quantity integer,  price integer, primary key (id),    foreign key (order_id) references orders(id),    foreign key (product_id) references products(id));
INSERT INTO order_spec(order_id,product_id,quantity,price) values (1,1,2,10);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (1,2,3,5);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (2,3,4,20);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (2,4,5,46);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (3,2,6,12);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (3,3,7,45);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (4,4,8,30);
INSERT INTO order_spec(order_id,product_id,quantity,price) values (4,1,9,32);

drop table cart if exists;
create table if not exists cart(id bigserial, product_id bigint, quantity integer, price integer, total integer, primary key(id), foreign key (product_id) references products(id) );
