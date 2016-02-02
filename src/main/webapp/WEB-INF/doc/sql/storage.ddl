/**********************************/
/* Table Name: 찜목록 번호 */
/**********************************/
CREATE TABLE storage(
		storageno                     		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '찜목록 번호',
		title                         		VARCHAR(20)		 NOT NULL COMMENT '상품제목',
		content                       		VARCHAR(200)		 NOT NULL COMMENT '상품내용',
		rdate                         		DATE		 NOT NULL COMMENT '등록일',
		thumb_file1                   		VARCHAR(100)		 NULL  COMMENT '썸파일1',
		itemno                        		MEDIUMINT		 NOT NULL COMMENT '게시물 목록'
) COMMENT='찜목록 번호';

