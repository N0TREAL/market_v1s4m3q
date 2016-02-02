/**********************************/
/* Table Name: 코드 code_q.sql */
/**********************************/
1. 테이블 생성
DROP TABLE item;

CREATE TABLE item(
		itemno                     MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '게시물 번호',
		uploader                   VARCHAR(20)		 NOT NULL COMMENT '작성자',
		title                          VARCHAR(20)		 NOT NULL COMMENT '제목',
		content                     VARCHAR(200)	 NOT NULL COMMENT '내용',
		rdate                         DATE		 		 NOT NULL COMMENT '등록일',
		udate                        DATE		 			 NOT NULL COMMENT '수정일',
		thumb_file1               VARCHAR(100)		 NULL  COMMENT '썸파일1',
		thumb_file2               VARCHAR(100)		 NULL  COMMENT '썸파일2',
		thumb_file3               VARCHAR(100)		 NULL  COMMENT '썸파일3',
		file1                       	VARCHAR(300)		 NOT NULL COMMENT '파일이름1',
		file2                       	VARCHAR(300)		 NULL  COMMENT '파일이름2',
		file3                         	VARCHAR(300)		 NULL  COMMENT '파일이름3',
		cnt                           	MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '조회수',
		recom                       	MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '추천수',
		replycnt                    	SMALLINT		 	 DEFAULT 0		 NOT NULL COMMENT '댓글수',
		itemcategory1no        MEDIUMINT		 NOT NULL  COMMENT '중분류'
) COMMENT='물건';
 
 
 
2. 등록
INSERT INTO item(uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no)
VALUES ('아로미', '가방팔아염', '가방입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.', now(), now(), 'a_thumb.png', 'b_thumb.png', 'c_thumb.png', 'a.png', 'b.png', 'c.png', 0, 0, 0, 1);
 
INSERT INTO item(uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no)
VALUES ('왕눈이', '신발팔아염', '신발입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.', now(), now(), 'a_thumb.png', 'b_thumb.png', 'c_thumb.png', 'a.png', 'b.png', 'c.png', 0, 0, 0, 2);

INSERT INTO item(uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no)
VALUES ('가가멜', '스머프팔아염', '스머프입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.', now(), now(), 'a_thumb.png', 'b_thumb.png', 'c_thumb.png', 'a.png', 'b.png', 'c.png', 0, 0, 0, 3); 
 
SELECT * FROM item;
 
 itemno uploader title  content                           rdate      udate      thumb_file1 thumb_file2 thumb_file3 file1 file2 file3 cnt recom replycnt itemcategory1no
 ------ -------- ------ --------------------------------- ---------- ---------- ----------- ----------- ----------- ----- ----- ----- --- ----- -------- ---------------
      1 아로미      가방팔아염  가방입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               1
      2 왕눈이      신발팔아염  신발입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               2
      3 가가멜      스머프팔아염 스머프입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다. 2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               3

 

3. 목록
1) 전체 목록
SELECT itemno, uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no
FROM item
ORDER BY itemno DESC;
 
 itemno uploader title  content                           rdate      udate      thumb_file1 thumb_file2 thumb_file3 file1 file2 file3 cnt recom replycnt itemcategory1no
 ------ -------- ------ --------------------------------- ---------- ---------- ----------- ----------- ----------- ----- ----- ----- --- ----- -------- ---------------
      3 가가멜      스머프팔아염 스머프입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다. 2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               3
      2 왕눈이      신발팔아염  신발입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               2
      1 아로미      가방팔아염  가방입니다. 몇번 쓰지도 않았어요. 새것 같은 중고입니다.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               1

 

4. 수정
1) 첨부파일 제외 수정
UPDATE item
SET title='수정됨', content='수정되었습니다.', udate=now(), itemcategory1no=10
WHERE itemno=1;
 
 itemno uploader title  content                           rdate      udate      thumb_file1 thumb_file2 thumb_file3 file1 file2 file3 cnt recom replycnt itemcategory1no
 ------ -------- ------ --------------------------------- ---------- ---------- ----------- ----------- ----------- ----- ----- ----- --- ----- -------- ---------------
      1 아로미      수정됨    수정되었습니다.           2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0              10

2) 첨부파일 수정 
????????


5. 삭제
DELETE FROM item
WHERE itemno=1;

