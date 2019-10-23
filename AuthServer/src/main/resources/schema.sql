CREATE TABLE USER (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	USERNAME VARCHAR(100) NOT NULL,
	EMAIL_ID VARCHAR(255), 
	PASSWORD VARCHAR(1000),
	UNIQUE KEY unique_username (USERNAME)
);

CREATE TABLE PERMISSION (
	ID INT PRIMARY KEY AUTO_INCREMENT, 
	PERMISSION_NAME VARCHAR(20)
);

CREATE TABLE ROLE (
	ID INT PRIMARY KEY AUTO_INCREMENT, 
	ROLE_NAME VARCHAR(20)
);

CREATE TABLE ASSIGN_PERMISSION_TO_ROLE (
	ID INT PRIMARY KEY AUTO_INCREMENT, 
	PERMISSION_ID INT, 
	FOREIGN KEY(PERMISSION_ID) REFERENCES PERMISSION (ID), 
	ROLE_ID INT, 
	FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ID)
);

CREATE TABLE ASSIGN_USER_TO_ROLE (
	ID INT PRIMARY KEY AUTO_INCREMENT, 
	USER_ID INT, 
	FOREIGN KEY(USER_ID) REFERENCES USER(ID), 
	ROLE_ID INT, 
	FOREIGN KEY(ROLE_ID) REFERENCES ROLE(ID)
);

