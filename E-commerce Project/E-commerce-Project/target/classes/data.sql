-- create database
CREATE SCHEMA IF NOT EXISTS ecommjava;

-- create the category table
CREATE TABLE IF NOT EXISTS ecommjava.CATEGORY (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

-- insert default categories
INSERT INTO ecommjava.CATEGORY (name) VALUES
    ('Fruits'),
    ('Vegetables'),
    ('Meat'),
    ('Fish'),
    ('Dairy'),
    ('Bakery'),
    ('Drinks'),
    ('Sweets'),
    ('Other');

-- create the customer table
CREATE TABLE IF NOT EXISTS ecommjava.CUSTOMER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    username VARCHAR(255),
    UNIQUE (username)
);

-- insert default customers
INSERT INTO ecommjava.CUSTOMER (address, email, password, role, username) VALUES
    ('123, Albany Street', 'admin@nyan.cat', '123', 'ROLE_ADMIN', 'admin'),
    ('765, 5th Avenue', 'lisa@gmail.com', '765', 'ROLE_NORMAL', 'lisa');

-- create the product table
CREATE TABLE IF NOT EXISTS ecommjava.PRODUCT (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    image VARCHAR(255),
    name VARCHAR(255),
    price INT,
    quantity INT,
    weight INT,
    category_id INT,
    customer_id INT,
    FOREIGN KEY (category_id) REFERENCES ecommjava.CATEGORY (category_id),
    FOREIGN KEY (customer_id) REFERENCES ecommjava.CUSTOMER (id)
);

-- insert default products
INSERT INTO ecommjava.PRODUCT (description, image, name, price, quantity, weight, category_id) VALUES
    ('Fresh and juicy', 'https://freepngimg.com/save/9557-apple-fruit-transparent/744x744', 'Apple', 3, 40, 76, 1),
    ('Woops! There goes the eggs...', 'https://www.nicepng.com/png/full/813-8132637_poiata-bunicii-cracked-egg.png', 'Cracked Eggs', 1, 90, 43, 9);

-- create indexes
CREATE INDEX FK7u438kvwr308xcwr4wbx36uiw ON ecommjava.PRODUCT (category_id);
CREATE INDEX FKt23apo8r9s2hse1dkt95ig0w5 ON ecommjava.PRODUCT (customer_id);
