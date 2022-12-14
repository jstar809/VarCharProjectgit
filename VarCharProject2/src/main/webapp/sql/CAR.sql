CREATE TABLE CAR(
   CNUM INT PRIMARY KEY,
   CTITLE VARCHAR(300) NOT NULL,
   CSUBTITLE VARCHAR(300) NOT NULL, 
   CYEAR INT NOT NULL,
   CFUEL VARCHAR(20) NOT NULL,
   CKM INT NOT NULL,
   CPRICE INT NOT NULL,
   CCITY VARCHAR(20) NOT NULL,
   CIMG VARCHAR(500) NOT NULL
);

--   CIMG
SELECT * FROM CAR;
SELECT * FROM CFUEL WHERE TABLE_NAME='CAR';
DROP TABLE CAR;
SELECT * FROM (SELECT C.*, ROWNUM FROM (SELECT * FROM CAR ORDER BY ROWNUM ) C WHERE ROWNUM <= 12*1 ) WHERE ROWNUM >= 1
SELECT * FROM (SELECT C.*, ROWNUM FROM (SELECT * FROM CAR ORDER BY ROWNUM ) C WHERE ROWNUM <= 12*3 ) WHERE ROWNUM >= (1+(12*2))
SELECT * FROM CAR WHERE CTITLE IN (SELECT CTITLE FROM CAR) AND CYEAR IN(2019) AND CFUEL IN('가솔린') AND CKM IN(10000) AND CPRICE IN(33000);

