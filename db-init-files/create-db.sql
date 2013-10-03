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

INSER INTO users VALUES('alex-nick', 'alex-long', 'pass-12345', 'alex@mail.com');

-- SELECT DATABASE mywebapp;
DESCRIBE users;
select * from users;
SHOW TABLES;
DROP DATABASE mywebapp;