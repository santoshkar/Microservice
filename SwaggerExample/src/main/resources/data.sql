INSERT INTO dept VALUES (1, 'IT');
INSERT INTO dept VALUES (2, 'HR');
INSERT INTO dept VALUES	 (3, 'ADMIN');

INSERT INTO emp(name, email, dept_id) VALUES ('Santosh Kumar', 'santosh@gmail.com', 1);
INSERT INTO emp(name, email, dept_id) VALUES ('Sudhakar', 'sudhakar@gmail.com', 1);
INSERT INTO emp(name, email, dept_id) VALUES ('Nirmala', 'nirmala@gmail.com', 1);
INSERT INTO emp(name, email, dept_id) VALUES ('Rohit', 'rohit@gmail.com', 1);

INSERT INTO roles VALUES (1, 'ADMIN');
INSERT INTO roles VALUES (2, 'USER');
INSERT INTO roles VALUES (3, 'DBA');

INSERT INTO users(id, username, password) VALUES (1, 'santosh', 'letmein');
INSERT INTO users(id, username, password) VALUES (2, 'sudhakar', 'letmein');
INSERT INTO users(id, username, password) VALUES (3, 'nirmala', 'letmein');
INSERT INTO users(id, username, password) VALUES (4, 'rohit', 'letmein');


INSERT INTO user_role(user_id, role_id) VALUES(	1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(	1, 2);
INSERT INTO user_role(user_id, role_id) VALUES(	1, 3);
INSERT INTO user_role(user_id, role_id) VALUES(	2, 1);
INSERT INTO user_role(user_id, role_id) VALUES(	2, 2);
INSERT INTO user_role(user_id, role_id) VALUES(	2, 3);
INSERT INTO user_role(user_id, role_id) VALUES(	3, 1);
INSERT INTO user_role(user_id, role_id) VALUES(	3, 2);
INSERT INTO user_role(user_id, role_id) VALUES(	3, 3);
INSERT INTO user_role(user_id, role_id) VALUES(	4, 1);
INSERT INTO user_role(user_id, role_id) VALUES(	4, 2);
INSERT INTO user_role(user_id, role_id) VALUES(	4, 3);
