INSERT INTO PERMISSION (ID, PERMISSION_NAME) VALUES 
(1, 'CREATE_NOTE'), 
(2, 'EDIT_NOTE'), 
(3, 'DELETE_NOTE'), 
(4, 'VIEW_ALL_NOTE'), 
(5, 'VIEW_NOTE');

INSERT INTO ROLE (ID, ROLE_NAME) VALUES 
(1, 'ADMINISTRATOR'),
(2, 'AUDITOR');

INSERT INTO USER (ID, NAME, USERNAME, EMAIL_ID, PASSWORD)
VALUES (1, 'Santosh Kumar Kar', 'santosh', 'skkar.2k2@gmail.com','$2a$10$jbIi/RIYNm5xAW9M7IaE5.WPw6BZgD8wcpkZUg0jm8RHPtdfDcMgm');

INSERT INTO USER (ID, NAME, USERNAME, EMAIL_ID, PASSWORD)
VALUES (2, 'Aniket Kar', 'aniket', 'aniket@gmail.com','$2a$10$jbIi/RIYNm5xAW9M7IaE5.WPw6BZgD8wcpkZUg0jm8RHPtdfDcMgm');

INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (3, 1);
INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (4, 1);
INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (5, 1);

INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (4, 2);
INSERT INTO ASSIGN_PERMISSION_TO_ROLE (PERMISSION_ID, ROLE_ID) VALUES (5, 2);

INSERT INTO ASSIGN_USER_TO_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO ASSIGN_USER_TO_ROLE (USER_ID, ROLE_ID) VALUES (2, 2);