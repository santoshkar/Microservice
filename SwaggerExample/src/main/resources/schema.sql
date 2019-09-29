CREATE TABLE DEPT(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(50) NOT NULL
);

CREATE TABLE EMP(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(50) NOT NULL,
	email varchar(50) DEFAULT NULL,
	dept_id INT,
	FOREIGN KEY (dept_id) REFERENCES dept(ID)
);

CREATE TABLE users (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password varchar(500) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY username (username)
);

CREATE TABLE roles (
  ID bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role varchar(45) NOT NULL,
  UNIQUE KEY role (role)
);

CREATE TABLE user_role (
  ID bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (ID),
  FOREIGN KEY (role_id) REFERENCES roles (ID)
);
