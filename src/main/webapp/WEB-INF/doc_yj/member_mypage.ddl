/**********************************/
/* Table Name: 회원 */
/**********************************/
CREATE TABLE member(
		mno                           		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '회원번호',
		id                            		VARCHAR(20)		 NOT NULL COMMENT '아이디',
		passwd                        		VARCHAR(20)		 NOT NULL COMMENT '비밀번호',
		email                         		VARCHAR(50)		 NOT NULL COMMENT '이메일',
		sms                           		CHAR(1)		 NOT NULL COMMENT 'SMS여부',
		visible                       		CHAR(1)		 NOT NULL COMMENT '열람권한',
		mname                         		VARCHAR(20)		 NOT NULL COMMENT '이름',
		sex                           		CHAR(1)		 NOT NULL COMMENT '성별',
		birth                         		VARCHAR(20)		 NOT NULL COMMENT '생년월일',
		phone                         		VARCHAR(14)		 NOT NULL COMMENT '핸드폰번호',
		zipcode                       		VARCHAR(5)		 NULL  COMMENT '우편번호',
		address1                      		VARCHAR(80)		 NULL  COMMENT '주소',
		address2                      		VARCHAR(50)		 NULL  COMMENT '상세주소',
		mdate                         		DATETIME		 NOT NULL COMMENT '등록일',
  CONSTRAINT email UNIQUE (email),
  CONSTRAINT id UNIQUE (id)
) COMMENT='회원';

/**********************************/
/* Table Name: 마이페이지 */
/**********************************/
CREATE TABLE mypage(
		mypageno                      		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '마이페이지번호',
		upload_itemno                 		MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '업로드물품수',
		profil_content                		VARCHAR(300)		 NOT NULL COMMENT '프로필',
		profil_file                   		VARCHAR(300)		 NULL  COMMENT '프로필_사진',
		replycnt                      		SMALLINT		 DEFAULT 0		 NOT NULL COMMENT '댓글수',
		mno                           		MEDIUMINT		 NULL  COMMENT '회원번호',
  FOREIGN KEY (mno) REFERENCES memberv1 (mno)
) COMMENT='마이페이지';

/**********************************/
/* Table Name: 메세지함 */
/**********************************/
CREATE TABLE message(
		messageno                     		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '쪽지번호',
		title                         		VARCHAR(200)		 NOT NULL COMMENT '쪽지제목',
		content                       		VARCHAR(300)		 NOT NULL COMMENT '쪽지내용',
		rdate                         		DATETIME		 NOT NULL COMMENT '등록일',
		mypageno                      		MEDIUMINT		 NULL  COMMENT '마이페이지번호',
  FOREIGN KEY (mypageno) REFERENCES mypage (mypageno)
) COMMENT='메세지함';

