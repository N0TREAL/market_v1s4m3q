/**********************************/
/* Table Name: 대분류 */
/**********************************/
CREATE TABLE itemcategory2(
		itemcategory2no               		MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '대분류',
		itemclass2                    		VARCHAR(30)		 NOT NULL COMMENT '대분류명',
		tiemclass1                    		VARCHAR(30)		 NOT NULL COMMENT '중분류'
) COMMENT='대분류';

/**********************************/
/* Table Name: 중분류 */
/**********************************/
CREATE TABLE itemcategory1(
		itemcategory1no               		MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '중분류',
		itemclass1                    		VARCHAR(30)		 NOT NULL COMMENT '중분류명',
		itemclass2                    		VARCHAR(30)		 NOT NULL COMMENT '대분류명',
		itemcategory2no               		MEDIUMINT		 NOT NULL COMMENT '대분류'
) COMMENT='중분류';

/**********************************/
/* Table Name: 물건 */
/**********************************/
CREATE TABLE item(
		itemno                        		MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '게시물 번호',
		uploader                      		VARCHAR(20)		 NOT NULL COMMENT '작성자',
		title                         		VARCHAR(20)		 NOT NULL COMMENT '제목',
		content                       		VARCHAR(200)		 NOT NULL COMMENT '내용',
		rdate                         		DATE		 NOT NULL COMMENT '등록일',
		udate                         		DATE		 NOT NULL COMMENT '수정일',
		thumb_file1                   		VARCHAR(100)		 NULL  COMMENT '썸파일1',
		thumb_file2                   		VARCHAR(100)		 NULL  COMMENT '썸파일2',
		thumb_file3                   		VARCHAR(100)		 NULL  COMMENT '썸파일3',
		file1                         		VARCHAR(300)		 NOT NULL COMMENT '파일이름1',
		file2                         		VARCHAR(300)		 NULL  COMMENT '파일이름2',
		file3                         		VARCHAR(300)		 NULL  COMMENT '파일이름3',
		cnt                           		MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '조회수',
		recom                         		MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '추천수',
		replycnt                      		SMALLINT		 DEFAULT 0		 NOT NULL COMMENT '댓글수',
		itemcategory1no               		MEDIUMINT		 NULL  COMMENT '중분류'
) COMMENT='물건';

/**********************************/
/* Table Name: 물건 댓글 */
/**********************************/
CREATE TABLE itemreply(
		itemreplyno                   		MEDIUMINT		 NOT NULL COMMENT '물건 댓글 번호',
		itemreplycontent              		VARCHAR(200)		 NOT NULL COMMENT '댓글 내용',
		itemno                        		MEDIUMINT		 NOT NULL COMMENT '게시물 번호'
) COMMENT='물건 댓글';

/**********************************/
/* Table Name: 찜목록 */
/**********************************/
CREATE TABLE storage(
		storageno                     		MEDIUMINT		 NOT NULL AUTO_INCREMENT COMMENT '찜목록 번호',
		title                         		VARCHAR(20)		 NOT NULL COMMENT '상품제목',
		content                       		VARCHAR(200)		 NOT NULL COMMENT '상품내용',
		rdate                         		DATE		 NOT NULL COMMENT '등록일',
		thumb_file1                   		VARCHAR(100)		 NULL  COMMENT '썸파일1',
		itemno                        		MEDIUMINT		 NOT NULL AUTO_INCREMENT COMMENT '게시물 번호'
) COMMENT='찜목록';

/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE member(
		mno                           		INT(10)		 NOT NULL COMMENT '회원번호',
		id                            		VARCHAR(20)		 NOT NULL COMMENT '아이디',
		passwd                        		VARCHAR(20)		 NOT NULL COMMENT '비밀번호',
		email                         		VARCHAR(50)		 NOT NULL COMMENT '이메일',
		mail                          		CHAR(1)		 NOT NULL COMMENT '이메일전송',
		visible                       		CHAR(1)		 NOT NULL COMMENT '열람권한',
		mname                         		VARCHAR(20)		 NOT NULL COMMENT '성명',
		sex                           		VARCHAR(10)		 NOT NULL COMMENT '성별',
		profil                        		VARCHAR(200)		 NOT NULL COMMENT '프로필소개',
		profil_picture                		VARCHAR(300)		 NOT NULL COMMENT '프로필사진',
		tel                           		VARCHAR(14)		 NOT NULL COMMENT '집전화',
		phone                         		VARCHAR(14)		 NOT NULL COMMENT '핸드폰번호',
		sms                           		CHAR(1)		 NOT NULL COMMENT '문자전송',
		zipcode                       		VARCHAR(5)		 NULL  COMMENT '우편주소',
		address1                      		VARCHAR(80)		 NULL  COMMENT '주소',
		address2                      		VARCHAR(50)		 NULL  COMMENT '상세주소',
		mdate                         		DATETIME		 NOT NULL COMMENT '가입일'
) COMMENT='회원';

/**********************************/
/* Table Name: 마이페이지 */
/**********************************/
CREATE TABLE mypage(
		mypageno                      		MEDIUMINT(10)		 NOT NULL COMMENT '마이페이지번호',
		mno                           		MEDIUMINT(10)		 NOT NULL COMMENT '친구번호',
		upload_itemno                 		MEDIUMINT(100)		 NOT NULL COMMENT '업로드물품수',
		title                         		VARCHAR(200)		 NOT NULL COMMENT '제목<임시>',
		content                       		VARCHAR(300)		 NOT NULL COMMENT '내용<임시>',
		thumb_file1                   		VARCHAR(300)		 NOT NULL COMMENT '썸파일1<임시>',
		rdate                         		TIMESTAMP		 NOT NULL COMMENT '등록일<임시>',
		udate                         		TIMESTAMP		 NOT NULL COMMENT '수정일<임시>',
		replycnt                      		SMALLINT		 DEFAULT 0		 NOT NULL COMMENT '댓글',
		itemno                        		MEDIUMINT		 NULL  COMMENT '게시물 번호'
) COMMENT='마이페이지';


ALTER TABLE itemcategory2 ADD CONSTRAINT IDX_itemcategory2_PK PRIMARY KEY (itemcategory2no);

ALTER TABLE itemcategory1 ADD CONSTRAINT IDX_itemcategory1_PK PRIMARY KEY (itemcategory1no);
ALTER TABLE itemcategory1 ADD CONSTRAINT IDX_itemcategory1_FK0 FOREIGN KEY (itemcategory2no) REFERENCES itemcategory2 (itemcategory2no);

ALTER TABLE item ADD CONSTRAINT IDX_item_PK PRIMARY KEY (itemno);
ALTER TABLE item ADD CONSTRAINT IDX_item_FK0 FOREIGN KEY (itemcategory1no) REFERENCES itemcategory1 (itemcategory1no);

ALTER TABLE itemreply ADD CONSTRAINT IDX_itemreply_PK PRIMARY KEY (itemreplyno);
ALTER TABLE itemreply ADD CONSTRAINT IDX_itemreply_FK0 FOREIGN KEY (itemno) REFERENCES item (itemno);

ALTER TABLE storage ADD CONSTRAINT IDX_storage_PK PRIMARY KEY (storageno);
ALTER TABLE storage ADD CONSTRAINT IDX_storage_FK0 FOREIGN KEY (itemno) REFERENCES item (itemno);

ALTER TABLE member ADD CONSTRAINT IDX_member_PK PRIMARY KEY (mno);

ALTER TABLE mypage ADD CONSTRAINT IDX_mypage_PK PRIMARY KEY (mypageno);
ALTER TABLE mypage ADD CONSTRAINT IDX_mypage_FK0 FOREIGN KEY (itemno) REFERENCES item (itemno);
ALTER TABLE mypage ADD CONSTRAINT IDX_mypage_FK1 FOREIGN KEY (mno) REFERENCES member (mno);

