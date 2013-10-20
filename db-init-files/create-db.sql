CREATE DATABASE mywebapp CHARACTER SET utf8;
SHOW CREATE DATABASE mywebapp;

USE mywebapp;

CREATE TABLE
	user (
		id_user INT NOT NULL AUTO_INCREMENT,
		nick_name VARCHAR(30) NOT NULL,
		login VARCHAR(30) NOT NULL,
		password VARCHAR(30) NOT NULL,
		email VARCHAR(30) NOT NULL,
		role ENUM('user','manager','admin') NOT NULL DEFAULT 'user',
		PRIMARY KEY (id_user),
		UNIQUE KEY (nick_name),
		UNIQUE KEY (login),
		UNIQUE KEY (email)
		);

-- test data:

-- -- into table users:
INSERT INTO users (name, email, password, role) VALUES('user', 'user@test.ru', '1', '0');
INSERT INTO users (name, email, password, role) VALUES('manager', 'manager@test.ru', '1', '1');
INSERT INTO users (name, email, password, role) VALUES('admin', 'admin@test.ru', '1', '2');

-- -- into table categories:
INSERT INTO categories (name) VALUES('work');
INSERT INTO categories (name) VALUES('sport');
INSERT INTO categories (name) VALUES('art');
INSERT INTO categories (name) VALUES('fun');
INSERT INTO categories (name) VALUES('book');
INSERT INTO categories (name) VALUES('meeting');

-- SELECT DATABASE mywebapp;
SHOW TABLES;
DESCRIBE user;
select * from user;

-- DROP DATABASE mywebapp;
