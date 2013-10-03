CREATE DATABASE mywebapp CHARACTER SET utf8;
SHOW CREATE DATABASE mywebapp;

USE mywebapp;

CREATE TABLE
	users (
		id_user INT (11) NOT NULL AUTO_INCREMENT,
		nickname VARCHAR(30) NOT NULL,
		login VARCHAR(30) NOT NULL,
		password VARCHAR(30) NOT NULL,
		email VARCHAR(30) NOT NULL,
		level ENUM('user','mang','admn') NOT NULL DEFAULT 'user',
		PRIMARY KEY (id_user),
		UNIQUE KEY (nickname),
		UNIQUE KEY (login),
		UNIQUE KEY (email)
		);

-- test data:

-- -- into table users:
INSERT INTO users (nickname, login, password, email) VALUES('alex', 'alex', '1234', 'alex@mail.com');
INSERT INTO users (nickname, login, password, email) VALUES('pavel', 'pavel', 'pavel1999', 'pavel@mail.com');
INSERT INTO users (nickname, login, password, email) VALUES('oleg', 'oleg', '3242', 'ыв@mail.com');
INSERT INTO users (nickname, login, password, email) VALUES('дима', 'дима', '34', 'dima@mail.com');

-- SELECT DATABASE mywebapp;
SHOW TABLES;
DESCRIBE users;
select * from users;

DROP DATABASE mywebapp;
