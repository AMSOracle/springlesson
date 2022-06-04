DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, name VARCHAR(255), price integer , PRIMARY KEY (id));
INSERT INTO products(name, price) values ('Apple', 10);
INSERT INTO products(name, price) values ('Pear', 30);
INSERT INTO products(name, price) values ('Orange', 5);
INSERT INTO products(name, price) values ('Grapes', 20);