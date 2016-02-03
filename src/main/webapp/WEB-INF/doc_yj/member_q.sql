/**********************************/
/* Table Name: ȸ�� */
/**********************************/
DROP TABLE memberv1;


CREATE TABLE memberv1(
    mno                               MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT 'ȸ����ȣ',
    id                                VARCHAR(20)    NOT NULL COMMENT '���̵�',
    passwd                            VARCHAR(20)    NOT NULL COMMENT '��й�ȣ',
    email                             VARCHAR(50)    NOT NULL COMMENT '�̸���',
    sms                               CHAR(1)    NOT NULL COMMENT 'SMS����',
    visible                           CHAR(1)    NOT NULL COMMENT '��������',
    mname                             VARCHAR(20)    NOT NULL COMMENT '�̸�',
    sex                               CHAR(1)    NOT NULL COMMENT '����',
    birth                             VARCHAR(20)    NOT NULL COMMENT '�������',
    phone                             VARCHAR(14)    NOT NULL COMMENT '�ڵ�����ȣ',
    zipcode                           VARCHAR(5)     NULL  COMMENT '�����ȣ',
    address1                          VARCHAR(80)    NULL  COMMENT '�ּ�',
    address2                          VARCHAR(50)    NULL  COMMENT '���ּ�',
    mdate                             DATETIME     NOT NULL COMMENT '�����',
  CONSTRAINT email UNIQUE (email),
  CONSTRAINT id UNIQUE (id)
) COMMENT='ȸ��';




2. ���

1) id �ߺ� Ȯ��
SELECT COUNT(id) as cnt
FROM member
WHERE id='user1';

 cnt
 ---
   0   �� �ߺ� ���� ����
   
2) ���
INSERT INTO memberv1(id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate)
VALUES ('user1', '1234', 'test1@naver.com', 'Y', 'Y', '��ö��', 'M', '870114', '000-0000-0000', '12345', '����� �����', '�ƹ���1��', now());

INSERT INTO memberv1(id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate)
VALUES ('user2', '1234', 'test2@naver.com', 'Y', 'Y', 'ȫ����', 'M', '920320', '000-0000-0000', '12345', '����� ���Ǳ�', '�ƹ���2��', now());

INSERT INTO memberv1(id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate)
VALUES ('user3', '1234', 'test3@naver.com', 'Y', 'Y', '�̿���', 'W', '941024', '000-0000-0000', '12345', '����� ���۱�', '�ƹ���3��', now());



3. ���
- �˻��� ���� �ʴ� ���, ��ü ��� ���
SELECT mno, id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate
FROM memberv1
ORDER BY mno ASC;

mno id    passwd email           sms visible mname sex birth  phone         zipcode address1 address2 mdate
 --- ----- ------ --------------- --- ------- ----- --- ------ ------------- ------- -------- -------- ---------------------
   1 user1 1234   test1@naver.com Y   Y       ��ö��   M   870114 000-0000-0000 12345   ����� �����  �ƹ���1��    2016-02-03 11:14:43.0
   2 user2 1234   test2@naver.com Y   Y       ȫ����   M   920320 000-0000-0000 12345   ����� ���Ǳ�  �ƹ���2��    2016-02-03 11:14:44.0
   3 user3 1234   test3@naver.com Y   Y       �̿���   W   941024 000-0000-0000 12345   ����� ���۱�  �ƹ���3��    2016-02-03 11:14:45.0

   
   
3. �ߺ�
SELECT COUNT(id) as cnt
FROM memberv1
WHERE id='user1';



4. ��ü��ȸ
SELECT mno, id, passwd, email, sms, visible, mname, sex, birth, phone, zipcode, address1, address2, mdate
FROM memberv1
WHERE mno = 1;

mno id    passwd email           sms visible mname sex birth  phone         zipcode address1 address2 mdate
 --- ----- ------ --------------- --- ------- ----- --- ------ ------------- ------- -------- -------- ---------------------
   1 user1 1234   test1@naver.com Y   Y       ��ö��   M   870114 000-0000-0000 12345   ����� �����  �ƹ���1��    2016-02-03 11:14:43.0

   
   
5. ����
1) �������
UPDATE member
SET mname='�մ���', tel='111-1111-1111', zipcode='00000',
    address1='��⵵', address2='���ֽ�'
WHERE mno = 1;

2) �н����� �˻�
SELECT COUNT(mno) as cnt
FROM member
WHERE mno=1 AND passwd='1234';

3) �н����� ����
UPDATE member
SET passwd='1111'
WHERE mno=1;



6. ����
1) ��� ����
DELETE FROM member;
 
2) Ư�� ȸ�� ����
DELETE FROM member
WHERE mno=1;



7. �α���
SELECT COUNT(mno) as cnt
FROM member
WHERE id='user1' AND passwd='1234';

cnt
---
 0


1) user1 ��� ���� ����





6. �˻�


7. ����¡



