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
INSERT INTO users (name, email, password, role) VALUES('user', 'user@test.ru', 'user', '0');
INSERT INTO users (name, email, password, role) VALUES('manager', 'manager@test.ru', 'manager', '1');
INSERT INTO users (name, email, password, role) VALUES('admin', 'admin@test.ru', 'admin', '2');

-- SELECT DATABASE mywebapp;
SHOW TABLES;
DESCRIBE user;
select * from user;

-- DROP DATABASE mywebapp;
