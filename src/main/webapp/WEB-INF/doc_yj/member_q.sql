/**********************************/
/* Table Name: 회원 */
/**********************************/
DROP TABLE memberv1;


CREATE TABLE memberv1(
    mno                               MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '회원번호',
    id                                VARCHAR(20)    NOT NULL COMMENT '아이디',
    passwd                            VARCHAR(20)    NOT NULL COMMENT '비밀번호',
    email                             VARCHAR(50)    NOT NULL COMMENT '이메일',
    sms                               CHAR(1)    NOT NULL COMMENT 'SMS여부',
    visible                           CHAR(1)    NOT NULL COMMENT '열람권한',
    mname                             VARCHAR(20)    NOT NULL COMMENT '이름',
    sex                               CHAR(1)    NOT NULL COMMENT '성별',
    birth                             VARCHAR(20)    NOT NULL COMMENT '생년월일',
    phone                             VARCHAR(14)    NOT NULL COMMENT '핸드폰번호',
    zipcode                           VARCHAR(5)     NULL  COMMENT '우편번호',
    address1                          VARCHAR(80)    NULL  COMMENT '주소',
    address2                          VARCHAR(50)    NULL  COMMENT '상세주소',
    mdate                             DATETIME     NOT NULL COMMENT '등록일',
  CONSTRAINT email UNIQUE (email),
  CONSTRAINT id UNIQUE (id)
) COMMENT='회원';




2. 등록

1) id 중복 확인
SELECT COUNT(id) as cnt
FROM member
WHERE id='user1';

 cnt
 ---
   0   ← 중복 되지 않음
   
2) 등록
INSERT INTO memberv1(id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate)
VALUES ('user1', '1234', 'test1@naver.com', 'Y', 'Y', '김철수', 'M', '870114', '000-0000-0000', '12345', '서울시 노원구', '아무개1동', now());

INSERT INTO memberv1(id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate)
VALUES ('user2', '1234', 'test2@naver.com', 'Y', 'Y', '홍영희', 'M', '920320', '000-0000-0000', '12345', '서울시 관악구', '아무개2동', now());

INSERT INTO memberv1(id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate)
VALUES ('user3', '1234', 'test3@naver.com', 'Y', 'Y', '이영수', 'W', '941024', '000-0000-0000', '12345', '서울시 동작구', '아무개3동', now());



3. 목록
- 검색을 하지 않는 경우, 전체 목록 출력
SELECT mno, id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate
FROM memberv1
ORDER BY mno ASC;

mno id    passwd email           sms visible mname sex birth  phone         zipcode address1 address2 mdate
 --- ----- ------ --------------- --- ------- ----- --- ------ ------------- ------- -------- -------- ---------------------
   1 user1 1234   test1@naver.com Y   Y       김철수   M   870114 000-0000-0000 12345   서울시 노원구  아무개1동    2016-02-03 11:14:43.0
   2 user2 1234   test2@naver.com Y   Y       홍영희   M   920320 000-0000-0000 12345   서울시 관악구  아무개2동    2016-02-03 11:14:44.0
   3 user3 1234   test3@naver.com Y   Y       이영수   W   941024 000-0000-0000 12345   서울시 동작구  아무개3동    2016-02-03 11:14:45.0

   
   
3. 중복
SELECT COUNT(id) as cnt
FROM memberv1
WHERE id='user1';



4. 전체조회
SELECT mno, id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate
FROM memberv1
WHERE mno = 1;

mno id    passwd email           sms visible mname sex birth  phone         zipcode address1 address2 mdate
 --- ----- ------ --------------- --- ------- ----- --- ------ ------------- ------- -------- -------- ---------------------
   1 user1 1234   test1@naver.com Y   Y       김철수   M   870114 000-0000-0000 12345   서울시 노원구  아무개1동    2016-02-03 11:14:43.0

   
   
5. 수정
1) 내용수정
UPDATE member
SET mname='왕눈이', tel='111-1111-1111', zipcode='00000',
    address1='경기도', address2='파주시'
WHERE mno = 1;

2) 패스워드 검사
SELECT COUNT(mno) as cnt
FROM member
WHERE mno=1 AND passwd='1234';

3) 패스워드 수정
UPDATE member
SET passwd='1111'
WHERE mno=1;



6. 삭제
1) 모두 삭제
DELETE FROM member;
 
2) 특정 회원 삭제
DELETE FROM member
WHERE mno=1;



7. 로그인
SELECT COUNT(mno) as cnt
FROM member
WHERE id='user1' AND passwd='1234';

cnt
---
 0


1) user1 사원 정보 보기





6. 검색


7. 페이징



