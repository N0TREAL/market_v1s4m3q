1) 테이블 구조
DROP TABLE asdf;

CREATE TABLE asdf(

) COMMENT='블로그내용';


2) 등록

INSERT INTO asdf(asdf, asdf, asdf, asdf, asdf, asdf, asdf, adsf)
VALUES('제목1', '내용1', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 1);

INSERT INTO asdf(asdf, asdf, asdf, asdf, asdf, asdf, asdf, adsf)
VALUES('제목1', '내용1', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 5);

INSERT INTO asdf(asdf, asdf, adsf, asdf, asdf, asdf, asdf, asdf)
VALUES('제목2', '내용2', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 5);

INSERT INTO asdf(title, asdf, asdf, asdf, asdf, asdf, asdf, asdf)
VALUES('제목3', '내용3', 0, now(), 'winter.jpg', 'spring.jpg/summer.jpg', 0, 5);

SELECT * FROM asdf;


      

3) 목록
SELECT asdfno, title, good, rdate, file, file1, replycnt, asdfcategoryno
FROM asdf
ORDER BY asdfno DESC;

 asdfno title good rdate                 file       file1                 replycnt asdfcategoryno
 ------ ----- ---- --------------------- ---------- --------------------- -------- --------------
      4 봄        0 2016-01-25 15:49:24.0                                         0              1
      3 제목2      0 2016-01-25 11:31:00.0 winter.jpg spring.jpg/summer.jpg        0              5
      2 제목1      0 2016-01-25 11:30:59.0 winter.jpg spring.jpg/summer.jpg        0              5
      1 제목1      0 2016-01-25 11:30:58.0 winter.jpg spring.jpg/summer.jpg        0              1



4) 조회
SELECT asdfno, title, content, good, rdate, file, file1, replycnt, asdfcategoryno
FROM asdf
WHERE asdfno=1;

 asdfno title content good rdate                 file       file1                 replycnt asdfcategoryno
 ------ ----- ------- ---- --------------------- ---------- --------------------- -------- --------------
      1 제목1   내용1        0 2016-01-25 11:30:58.0 winter.jpg spring.jpg/summer.jpg        0              1



5) 수정
UPDATE asdf
SET title='', content='', file='', file1='' 
WHERE asdfno=1;


6) 삭제
DELETE FROM asdf
WHERE asdfno=1;


7) asdf와 asdfcategory의 연동
asdf 테이블을 asdfcategoryno 값 기준으로 나눌 수 있다.

SELECT asdfno, title, content, good, SUBSTRING(rdate, 1, 10) as rdate, file, file1, replycnt, asdfcategoryno
FROM asdf
WHERE asdfcategoryno = 4
OREDER BY asdfno DESC;
