DROP DATABASE  IF EXISTS clouddb01;
CREATE DATABASE clouddb01 CHARACTER SET utf8;
USE clouddb01;
CREATE TABLE dept
(
	deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	dname VARCHAR(60),
	db_source VARCHAR(60)
);

INSERT INTO dept(dname,db_source) VALUES('机务产品部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('移动互联部',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('人事综合科',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('商务谈判部',DATABASE());

USE clouddb01;
SELECT * FROM dept;