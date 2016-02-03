/**********************************/
/* Table Name: ���������� */
/**********************************/
DROP TABLE mypage;
  
1) ���̺����
CREATE TABLE mypage(
    mypageno                          MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '������������ȣ',
    upload_itemno                     MEDIUMINT    DEFAULT 0     NOT NULL COMMENT '���ε幰ǰ��',
    profil_content                    VARCHAR(300)     NOT NULL COMMENT '������',
    profil_file                       VARCHAR(300)     NULL  COMMENT '������_����',
    replycnt                          SMALLINT     DEFAULT 0     NOT NULL COMMENT '��ۼ�',
    mno                               MEDIUMINT    NULL  COMMENT 'ȸ����ȣ',
  FOREIGN KEY (mno) REFERENCES memberv1 (mno)
) COMMENT='����������';



2) ���
INSERT INTO mypage(mno, upload_itemno, profil_content, profil_file, replycnt)
VALUES ('1', '1', '�ȳ��ϼ���. ���������Դϴ�.', 'example01.png', 0);
 
INSERT INTO mypage(mno, upload_itemno, profil_content, profil_file, replycnt)
VALUES ('2', '2', '�ȳ��ϼ���. �����ּ���.', 'example02.png', 0);

INSERT INTO mypage(mno, upload_itemno, profil_content, profil_file, replycnt)
VALUES ('3', '3', '�ȳ��ϼ���. ��ȭ�ּ���.', 'example03.png', 0);



3) ���̺� ��ü�÷� �˻�
SELECT * FROM mypage;

mypageno upload_itemno profil_content  profil_file   replycnt mno
 -------- ------------- --------------- ------------- -------- ---
        1             1 �ȳ��ϼ���. ���������Դϴ�. example01.png        0   1
        2             2 �ȳ��ϼ���. �����ּ���.     example02.png        0   2
        3             3 �ȳ��ϼ���. ��ȭ�ּ���.     example03.png        0   3


3. ���
1) �⺻���
SELECT blogcategoryno, codeno, title, orderno, visible, ids, cnt
FROM blogcategory
ORDER BY codeno, orderno;

 blogcategoryno codeno title orderno visible ids         cnt
 -------------- --- ----- ------- ------- ----------- ---
              2   1 ��           1 Y       admin         0
              3   1 �ٴ�          1 Y       admin         0
              4  24 ��⵵         1 Y       admin         0
              5  24 ��⵵         1 Y       admin         0
              6  24 ������         1 Y       admin         0
              7  24 ������         1 Y       admin         0
              1  24 ķ����         2 N       admin/user1 100







