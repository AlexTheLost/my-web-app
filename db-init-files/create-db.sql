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
INSERT INTO user (nick_name, login, password, email) VALUES('alex', 'alex', '1234', 'alex@mail.com');
INSERT INTO user (nick_name, login, password, email) VALUES('pavel', 'pavel', 'pavel1999', 'pavel@mail.com');
INSERT INTO user (nick_name, login, password, email) VALUES('oleg', 'oleg', '3242', 'ыв@mail.com');
INSERT INTO user (nick_name, login, password, email) VALUES('дима', 'дима', '34', 'dima@mail.com');

-- SELECT DATABASE mywebapp;
SHOW TABLES;
DESCRIBE user;
select * from user;

-- DROP DATABASE mywebapp;
