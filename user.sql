TRUNCATE TABLE test.user;
INSERT INTO test.user (email, nick_name, PASSWORD, reg_time, user_name,age)
VALUES('aa@sbds.com', 'the flying snake', '666666', SYSDATE(), 'aa',28);
INSERT INTO test.user (email, nick_name, PASSWORD, reg_time, user_name,age)
VALUES('bb@sbds.com', 'the flying sheep', '888888', SYSDATE(), 'bb',32);