/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE storage(
    storageno                         MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '���� ��ȣ',
    title                             VARCHAR(20)    NOT NULL COMMENT '��ǰ����',
    content                           VARCHAR(200)     NOT NULL COMMENT '��ǰ����',
    rdate                             DATE     NOT NULL COMMENT '�����',
    thumb_file1                       VARCHAR(100)     NULL  COMMENT '������1',
    itemno                            MEDIUMINT    NOT NULL COMMENT '�Խù� ���'
) COMMENT='���� ��ȣ';
 
 
 
2. ���
INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('����1', '����1', now(), 'winter.jpg', 1);

INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('����2', '����2', now(), 'winter.jpg', 2);

INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('����3', '����3', now(), 'winter.jpg', 3);

INSERT INTO storage(title, content, rdate, thumb_file1, itemno)
VALUES ('����4', '����4', now(), 'winter.jpg', 4);
 
 
 
SELECT * FROM storage;
 
 storageno title content rdate        thumb_file1     itemno
 --------- ----- ------- ----------   -----------     ------
         1 ����1   ����1     2016-02-02 winter.jpg       1
         2 ����2   ����2     2016-02-02 winter.jpg       2
         3 ����3   ����3     2016-02-02 winter.jpg       3
         4 ����4   ����4     2016-02-02 winter.jpg       4

 
      
3. ���
1) ��ü ���
SELECT title, content, rdate, thumb_file1, itemno
FROM storage
ORDER BY storageno ASC;
 
 title content rdate      thumb_file1 itemno
 ----- ------- ---------- ----------- ------
 ����2   ����2     2016-02-02 winter.jpg       2
 ����3   ����3     2016-02-02 winter.jpg       3
 ����4   ����4     2016-02-02 winter.jpg       4

SELECT title, content, rdate, thumb_file1, itemno
FROM storage
ORDER BY storageno DESC;

 title content rdate      thumb_file1 itemno
 ----- ------- ---------- ----------- ------
 ����4   ����4     2016-02-02 winter.jpg       4
 ����3   ����3     2016-02-02 winter.jpg       3
 ����2   ����2     2016-02-02 winter.jpg       2

 
4. ����
UPDATE storage
SET title='AAA'
WHERE storageno=1;
 
 
5. ����
DELETE FROM storage
WHERE storageno=1;

5-1)���̺� ��ü ����
DROP TABLE storage;



