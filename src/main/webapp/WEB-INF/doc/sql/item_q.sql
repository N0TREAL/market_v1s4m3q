/**********************************/
/* Table Name: �ڵ� code_q.sql */
/**********************************/
1. ���̺� ����
DROP TABLE item;

CREATE TABLE item(
		itemno                     MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '�Խù� ��ȣ',
		uploader                   VARCHAR(20)		 NOT NULL COMMENT '�ۼ���',
		title                          VARCHAR(20)		 NOT NULL COMMENT '����',
		content                     VARCHAR(200)	 NOT NULL COMMENT '����',
		rdate                         DATE		 		 NOT NULL COMMENT '�����',
		udate                        DATE		 			 NOT NULL COMMENT '������',
		thumb_file1               VARCHAR(100)		 NULL  COMMENT '������1',
		thumb_file2               VARCHAR(100)		 NULL  COMMENT '������2',
		thumb_file3               VARCHAR(100)		 NULL  COMMENT '������3',
		file1                       	VARCHAR(300)		 NOT NULL COMMENT '�����̸�1',
		file2                       	VARCHAR(300)		 NULL  COMMENT '�����̸�2',
		file3                         	VARCHAR(300)		 NULL  COMMENT '�����̸�3',
		cnt                           	MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '��ȸ��',
		recom                       	MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '��õ��',
		replycnt                    	SMALLINT		 	 DEFAULT 0		 NOT NULL COMMENT '��ۼ�',
		itemcategory1no        MEDIUMINT		 NOT NULL  COMMENT '�ߺз�'
) COMMENT='����';
 
 
 
2. ���
INSERT INTO item(uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no)
VALUES ('�Ʒι�', '�����Ⱦƿ�', '�����Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.', now(), now(), 'a_thumb.png', 'b_thumb.png', 'c_thumb.png', 'a.png', 'b.png', 'c.png', 0, 0, 0, 1);
 
INSERT INTO item(uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no)
VALUES ('�մ���', '�Ź��Ⱦƿ�', '�Ź��Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.', now(), now(), 'a_thumb.png', 'b_thumb.png', 'c_thumb.png', 'a.png', 'b.png', 'c.png', 0, 0, 0, 2);

INSERT INTO item(uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no)
VALUES ('������', '�������Ⱦƿ�', '�������Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.', now(), now(), 'a_thumb.png', 'b_thumb.png', 'c_thumb.png', 'a.png', 'b.png', 'c.png', 0, 0, 0, 3); 
 
SELECT * FROM item;
 
 itemno uploader title  content                           rdate      udate      thumb_file1 thumb_file2 thumb_file3 file1 file2 file3 cnt recom replycnt itemcategory1no
 ------ -------- ------ --------------------------------- ---------- ---------- ----------- ----------- ----------- ----- ----- ----- --- ----- -------- ---------------
      1 �Ʒι�      �����Ⱦƿ�  �����Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               1
      2 �մ���      �Ź��Ⱦƿ�  �Ź��Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               2
      3 ������      �������Ⱦƿ� �������Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�. 2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               3

 

3. ���
1) ��ü ���
SELECT itemno, uploader, title, content, rdate, udate, thumb_file1, thumb_file2, thumb_file3, file1, file2, file3, cnt, recom, replycnt, itemcategory1no
FROM item
ORDER BY itemno DESC;
 
 itemno uploader title  content                           rdate      udate      thumb_file1 thumb_file2 thumb_file3 file1 file2 file3 cnt recom replycnt itemcategory1no
 ------ -------- ------ --------------------------------- ---------- ---------- ----------- ----------- ----------- ----- ----- ----- --- ----- -------- ---------------
      3 ������      �������Ⱦƿ� �������Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�. 2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               3
      2 �մ���      �Ź��Ⱦƿ�  �Ź��Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               2
      1 �Ʒι�      �����Ⱦƿ�  �����Դϴ�. ��� ������ �ʾҾ��. ���� ���� �߰��Դϴ�.  2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0               1

 

4. ����
1) ÷������ ���� ����
UPDATE item
SET title='������', content='�����Ǿ����ϴ�.', udate=now(), itemcategory1no=10
WHERE itemno=1;
 
 itemno uploader title  content                           rdate      udate      thumb_file1 thumb_file2 thumb_file3 file1 file2 file3 cnt recom replycnt itemcategory1no
 ------ -------- ------ --------------------------------- ---------- ---------- ----------- ----------- ----------- ----- ----- ----- --- ----- -------- ---------------
      1 �Ʒι�      ������    �����Ǿ����ϴ�.           2016-02-02 2016-02-02 a_thumb.png b_thumb.png c_thumb.png a.png b.png c.png   0     0        0              10

2) ÷������ ���� 
????????


5. ����
DELETE FROM item
WHERE itemno=1;

