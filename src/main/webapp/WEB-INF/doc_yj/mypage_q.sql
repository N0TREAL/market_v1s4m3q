/**********************************/
/* Table Name: 마이페이지 */
/**********************************/
DROP TABLE mypage;
  
1) 테이블생성
CREATE TABLE mypage(
    mypageno                          MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '마이페이지번호',
    upload_itemno                     MEDIUMINT    DEFAULT 0     NOT NULL COMMENT '업로드물품수',
    profil_content                    VARCHAR(300)     NOT NULL COMMENT '프로필',
    profil_file                       VARCHAR(300)     NULL  COMMENT '프로필_사진',
    replycnt                          SMALLINT     DEFAULT 0     NOT NULL COMMENT '댓글수',
    mno                               MEDIUMINT    NULL  COMMENT '회원번호',
  FOREIGN KEY (mno) REFERENCES memberv1 (mno)
) COMMENT='마이페이지';



2) 등록
INSERT INTO mypage(mno, upload_itemno, profil_content, profil_file, replycnt)
VALUES ('1', '1', '안녕하세요. 좋은날씨입니다.', 'example01.png', 0);
 
INSERT INTO mypage(mno, upload_itemno, profil_content, profil_file, replycnt)
VALUES ('2', '2', '안녕하세요. 문자주세요.', 'example02.png', 0);

INSERT INTO mypage(mno, upload_itemno, profil_content, profil_file, replycnt)
VALUES ('3', '3', '안녕하세요. 전화주세요.', 'example03.png', 0);



3) 테이블 전체컬럼 검색
SELECT * FROM mypage;

mypageno upload_itemno profil_content  profil_file   replycnt mno
 -------- ------------- --------------- ------------- -------- ---
        1             1 안녕하세요. 좋은날씨입니다. example01.png        0   1
        2             2 안녕하세요. 문자주세요.     example02.png        0   2
        3             3 안녕하세요. 전화주세요.     example03.png        0   3


3. 목록
1) 기본목록
SELECT blogcategoryno, codeno, title, orderno, visible, ids, cnt
FROM blogcategory
ORDER BY codeno, orderno;

 blogcategoryno codeno title orderno visible ids         cnt
 -------------- --- ----- ------- ------- ----------- ---
              2   1 산           1 Y       admin         0
              3   1 바다          1 Y       admin         0
              4  24 경기도         1 Y       admin         0
              5  24 경기도         1 Y       admin         0
              6  24 강원도         1 Y       admin         0
              7  24 강원도         1 Y       admin         0
              1  24 캠핑장         2 N       admin/user1 100







