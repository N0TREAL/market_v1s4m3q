1) ���̺� ����
DROP TABLE asdf;

CREATE TABLE asdf(

) COMMENT='��α׳���';


2) ���

INSERT INTO asdf(asdf, asdf, asdf, asdf, asdf, asdf, asdf, adsf)
VALUES('����1', '����1', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 1);

INSERT INTO asdf(asdf, asdf, asdf, asdf, asdf, asdf, asdf, adsf)
VALUES('����1', '����1', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 5);

INSERT INTO asdf(asdf, asdf, adsf, asdf, asdf, asdf, asdf, asdf)
VALUES('����2', '����2', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 5);

INSERT INTO asdf(title, asdf, asdf, asdf, asdf, asdf, asdf, asdf)
VALUES('����3', '����3', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 5);

SELECT * FROM asdf;


      

3) ���
SELECT asdfno, title, good, rdate, file, file1, replycnt, asdfcategoryno
FROM asdf
ORDER BY asdfno DESC;

 asdfno title good rdate                 file       file1                 replycnt asdfcategoryno
 ------ ----- ---- --------------------- ---------- --------------------- -------- --------------
      4 ��        0 2016-01-25 15:49:24.0                                         0              1
      3 ����2      0 2016-01-25 11:31:00.0 winter.jpg spring.jpg/summer.jpg        0              5
      2 ����1      0 2016-01-25 11:30:59.0 winter.jpg spring.jpg/summer.jpg        0              5
      1 ����1      0 2016-01-25 11:30:58.0 winter.jpg spring.jpg/summer.jpg        0              1



4) ��ȸ
SELECT asdfno, title, content, good, rdate, file, file1, replycnt, asdfcategoryno
FROM asdf
WHERE asdfno=1;

 asdfno title content good rdate                 file       file1                 replycnt asdfcategoryno
 ------ ----- ------- ---- --------------------- ---------- --------------------- -------- --------------
      1 ����1   ����1        0 2016-01-25 11:30:58.0 winter.jpg spring.jpg/summer.jpg        0              1



5) ����
UPDATE asdf
SET title='', content='', file='', file1='' 
WHERE asdfno=1;


6) ����
DELETE FROM asdf
WHERE asdfno=1;


7) asdf�� asdfcategory�� ����
asdf ���̺��� asdfcategoryno �� �������� ���� �� �ִ�.

SELECT asdfno, title, content, good, SUBSTRING(rdate, 1, 10) as rdate, file, file1, replycnt, asdfcategoryno
FROM asdf
WHERE asdfcategoryno = 4
OREDER BY asdfno DESC;
