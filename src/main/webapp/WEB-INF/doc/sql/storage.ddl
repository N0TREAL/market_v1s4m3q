/**********************************/
/* Table Name: ���� ��ȣ */
/**********************************/
CREATE TABLE storage(
		storageno                     		MEDIUMINT(10)		 NOT NULL		 PRIMARY KEY COMMENT '���� ��ȣ',
		title                         		VARCHAR(20)		 NOT NULL COMMENT '��ǰ����',
		content                       		VARCHAR(200)		 NOT NULL COMMENT '��ǰ����',
		rdate                         		DATE		 NOT NULL COMMENT '�����',
		thumb_file1                   		VARCHAR(100)		 NULL  COMMENT '������1',
		itemno                        		MEDIUMINT		 NOT NULL COMMENT '�Խù� ���'
) COMMENT='���� ��ȣ';

