DROP DATABASE IF EXISTS wishlist_db;
CREATE DATABASE wishlist_db;
USE wishlist_db;

CREATE TABLE user (
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255),
email VARCHAR(255),
PRIMARY KEY (id)
);

CREATE TABLE wishlist (
id INT NOT NULL AUTO_INCREMENT,
wishlist_title VARCHAR(255),
user_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE item (
id INT NOT NULL AUTO_INCREMENT,
item_name VARCHAR(255) NOT NULL,
item_link VARCHAR(255),
item_price INT,
item_quantity INT,
wishlist_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (wishlist_id) REFERENCES wishlist(id)
);

insert into user (first_name, last_name, email) values ('Liane', 'Risen', 'lrisen0@tamu.edu');
insert into user (first_name, last_name, email) values ('Cammi', 'Gillian', 'cgillian1@noaa.gov');
insert into user (first_name, last_name, email) values ('Fernanda', 'Dursley', 'fdursley2@altervista.org');
insert into user (first_name, last_name, email) values ('Philippe', 'Gethin', 'pgethin3@nationalgeographic.com');
insert into user (first_name, last_name, email) values ('Laurens', 'Marples', 'lmarples4@comcast.net');
insert into user (first_name, last_name, email) values ('Edward', 'Jenicek', 'ejenicek5@wp.com');
insert into user (first_name, last_name, email) values ('Margette', 'Stearn', 'mstearn6@economist.com');
insert into user (first_name, last_name, email) values ('Morry', 'Halfhead', 'mhalfhead7@trellian.com');
insert into user (first_name, last_name, email) values ('Gunilla', 'Filippucci', 'gfilippucci8@wufoo.com');
insert into user (first_name, last_name, email) values ('Jone', 'Gilbee', 'jgilbee9@google.ru');
insert into user (first_name, last_name, email) values ('Camila', 'Hrachovec', 'chrachoveca@oakley.com');
insert into user (first_name, last_name, email) values ('Analise', 'Dimsdale', 'adimsdaleb@cyberchimps.com');
insert into user (first_name, last_name, email) values ('Saunderson', 'Domican', 'sdomicanc@icq.com');
insert into user (first_name, last_name, email) values ('Prudy', 'Flag', 'pflagd@aboutads.info');
insert into user (first_name, last_name, email) values ('Elora', 'Dicty', 'edictye@about.me');
insert into user (first_name, last_name, email) values ('Kania', 'Lowings', 'klowingsf@privacy.gov.au');
insert into user (first_name, last_name, email) values ('Tonnie', 'Sutor', 'tsutorg@gnu.org');
insert into user (first_name, last_name, email) values ('Winfield', 'Heephy', 'wheephyh@woothemes.com');
insert into user (first_name, last_name, email) values ('Jo-anne', 'McCroary', 'jmccroaryi@blinklist.com');
insert into user (first_name, last_name, email) values ('Giovanna', 'Bellchamber', 'gbellchamberj@vinaora.com');


INSERT INTO wishlist(wishlist_title, user_id)
VALUES	('Mommys birthday', 1),
		('Sisters birthday', 2),
		('Grannys birthday', 3);

INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id)
VALUES	('Coffee cups', 'https://somerandomsite.com/1234', 184, 3, 1),
		('Iphone 12', 'https://somerandomsite.com/1234', 799, 0, 2),
		('Giftcard', 'https://somerandomsite.com/1234', 249, 0, 3);