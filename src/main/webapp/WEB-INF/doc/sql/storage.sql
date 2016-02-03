/**********************************/
/* Table Name: 찜목록 */
/**********************************/
CREATE TABLE storage(
    storageno                         MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '찜목록 번호',
    title                             VARCHAR(20)    NOT NULL COMMENT '상품제목',
    content                           VARCHAR(200)     NOT NULL COMMENT '상품내용',
    rdate                             DATE     NOT NULL COMMENT '등록일',
    thumb_file1                       VARCHAR(100)     NULL  COMMENT '썸파일1',
    itemno                            MEDIUMINT    NOT NULL COMMENT '게시물 목록'
) COMMENT='찜목록 번호';
 
 
 
2. 등록
INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('제목1', '내용1', now(), 'winter.jpg', 1);

INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('제목2', '내용2', now(), 'winter.jpg', 2);

INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('제목3', '내용3', now(), 'winter.jpg', 3);

INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('제목4', '내용4', now(), 'winter.jpg', 4);
 
 
 
SELECT * FROM storage;
 
 storageno title content rdate        thumb_file1     itemno
 --------- ----- ------- ----------   -----------     ------
         1 제목1   내용1     2016-02-02 winter.jpg       1
         2 제목2   내용2     2016-02-02 winter.jpg       2
         3 제목3   내용3     2016-02-02 winter.jpg       3
         4 제목4   내용4     2016-02-02 winter.jpg       4

 
      
3. 목록
1) 전체 목록
SELECT title, content, rdate, thumb_file1, itemno
FROM storage
ORDER BY storageno ASC;
 
 title content rdate      thumb_file1 itemno
 ----- ------- ---------- ----------- ------
 제목2   내용2     2016-02-02 winter.jpg       2
 제목3   내용3     2016-02-02 winter.jpg       3
 제목4   내용4     2016-02-02 winter.jpg       4

SELECT title, content, rdate, thumb_file1, itemno
FROM storage
ORDER BY storageno DESC;

 title content rdate      thumb_file1 itemno
 ----- ------- ---------- ----------- ------
 제목4   내용4     2016-02-02 winter.jpg       4
 제목3   내용3     2016-02-02 winter.jpg       3
 제목2   내용2     2016-02-02 winter.jpg       2

 
4. 수정
UPDATE storage
SET title='AAA'
WHERE storageno=1;
 
 
5. 삭제
DELETE FROM storage
WHERE storageno=1;

5-1)테이블 전체 삭제
DROP TABLE storage;



