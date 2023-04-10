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

INSERT INTO USER (first_name, last_name, email) VALUES ('Person A', 'Surname A', 'persona@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person B', 'Surname B', 'personb@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person C', 'Surname C', 'personc@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person D', 'Surname D', 'persond@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person E', 'Surname E', 'persone@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person F', 'Surname F', 'personf@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person G', 'Surname G', 'persong@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person H', 'Surname H', 'personh@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person I', 'Surname I', 'personi@randomdomain.com');
INSERT INTO USER (first_name, last_name, email) VALUES ('Person J', 'Surname J', 'personj@randomdomain.com');

INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist ABCDF', 1);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist WXYZA', 1);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist LMNOE', 2);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist RSTUX', 2);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist MNOPF', 3);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist ENOPF', 3);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist IJKLH', 4);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist WXYZU', 4);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist BCDEG', 5);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist JKLWD', 5);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist LMNRR', 6);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist GMNRR', 6);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist DEFGR', 7);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist TUVWR', 7);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist QRSHT', 8);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist VWXYB', 8);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist EFGHN', 9);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist MNOPV', 9);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist PQRSY', 10);
INSERT INTO wishlist(wishlist_title, user_id) VALUES ('Wishlist IJKYH', 10);


INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item ABCD', 'https://randomlink.com/abcd', 1234, 1, 1);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item DEFG', 'https://randomlink.com/defg', 4567, 2, 1);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item GHJI', 'https://randomlink.com/ghji', 8901, 3, 2);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item XYZA', 'https://randomlink.com/xyza', 3456, 1, 2);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item BCDE', 'https://randomlink.com/bcde', 6789, 2, 3);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item FGHI', 'https://randomlink.com/fghi', 0123, 3, 3);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item JKLM', 'https://randomlink.com/jklm', 4567, 1, 4);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item NOPQ', 'https://randomlink.com/nopq', 8901, 2, 4);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item RSTU', 'https://randomlink.com/rstu', 2345, 3, 5);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item VWXY', 'https://randomlink.com/vwxy', 1234, 1, 5);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item ZABC', 'https://randomlink.com/zabc', 5678, 2, 6);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item DEFG', 'https://randomlink.com/defg', 9012, 3, 6);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item HIJK', 'https://randomlink.com/hijk', 2345, 1, 7);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item LMNO', 'https://randomlink.com/lmno', 6789, 2, 7);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item PQRS', 'https://randomlink.com/pqrs', 0123, 3, 8);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item TUVW', 'https://randomlink.com/tuvw', 4567, 1, 8);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item XYZA', 'https://randomlink.com/xyza', 8901, 2, 9);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item BCDE', 'https://randomlink.com/bcde', 2345, 3, 9);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item FGHI', 'https://randomlink.com/fghi', 5678, 1, 10);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item JKLM', 'https://randomlink.com/jklm', 9012, 2, 10);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item NOPQ', 'https://randomlink.com/nopq', 3456, 3, 11);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item RSTU', 'https://randomlink.com/rstu', 7890, 1, 11);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item VWXY', 'https://randomlink.com/vwxy', 1234, 2, 12);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item ZABC', 'https://randomlink.com/zabc', 5678, 3, 12);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item LMNO', 'https://randomlink.com/lmno', 2345, 1, 13);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item PQRS', 'https://randomlink.com/pqrs', 6789, 2, 13);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item TUVW', 'https://randomlink.com/tuvw', 2123, 3, 14);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item XYZA', 'https://randomlink.com/xyza', 4567, 1, 14);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item BCDE', 'https://randomlink.com/bcde', 8901, 2, 15);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item FGHI', 'https://randomlink.com/fghi', 2345, 3, 15);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item ABCD', 'https://randomlink.com/abcd', 1234, 1, 16);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item DEFG', 'https://randomlink.com/defg', 4567, 2, 16);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item GHJI', 'https://randomlink.com/ghji', 8901, 3, 17);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item XYZA', 'https://randomlink.com/xyza', 3456, 1, 17);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item BCDE', 'https://randomlink.com/bcde', 6789, 2, 18);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item FGHI', 'https://randomlink.com/fghi', 0123, 3, 18);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item JKLM', 'https://randomlink.com/jklm', 4567, 1, 19);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item NOPQ', 'https://randomlink.com/nopq', 8901, 2, 19);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item RSTU', 'https://randomlink.com/rstu', 2345, 3, 20);
INSERT INTO item (item_name, item_link, item_price, item_quantity, wishlist_id) VALUES ('Item VWXY', 'https://randomlink.com/vwxy', 1234, 1, 20);