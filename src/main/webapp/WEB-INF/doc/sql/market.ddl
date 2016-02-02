/**********************************/
/* Table Name: ��з� */
/**********************************/
CREATE TABLE itemcategory2(
		itemcategory2no               		MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '��з�',
		itemclass2                    		VARCHAR(30)		 NOT NULL COMMENT '��з���',
		tiemclass1                    		VARCHAR(30)		 NOT NULL COMMENT '�ߺз�'
) COMMENT='��з�';

/**********************************/
/* Table Name: �ߺз� */
/**********************************/
CREATE TABLE itemcategory1(
		itemcategory1no               		MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '�ߺз�',
		itemclass1                    		VARCHAR(30)		 NOT NULL COMMENT '�ߺз���',
		itemclass2                    		VARCHAR(30)		 NOT NULL COMMENT '��з���',
		itemcategory2no               		MEDIUMINT		 NOT NULL COMMENT '��з�'
) COMMENT='�ߺз�';

/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE item(
		itemno                        		MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '�Խù� ��ȣ',
		uploader                      		VARCHAR(20)		 NOT NULL COMMENT '�ۼ���',
		title                         		VARCHAR(20)		 NOT NULL COMMENT '����',
		content                       		VARCHAR(200)		 NOT NULL COMMENT '����',
		rdate                         		DATE		 NOT NULL COMMENT '�����',
		udate                         		DATE		 NOT NULL COMMENT '������',
		thumb_file1                   		VARCHAR(100)		 NULL  COMMENT '������1',
		thumb_file2                   		VARCHAR(100)		 NULL  COMMENT '������2',
		thumb_file3                   		VARCHAR(100)		 NULL  COMMENT '������3',
		file1                         		VARCHAR(300)		 NOT NULL COMMENT '�����̸�1',
		file2                         		VARCHAR(300)		 NULL  COMMENT '�����̸�2',
		file3                         		VARCHAR(300)		 NULL  COMMENT '�����̸�3',
		cnt                           		MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '��ȸ��',
		recom                         		MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '��õ��',
		replycnt                      		SMALLINT		 DEFAULT 0		 NOT NULL COMMENT '��ۼ�',
		itemcategory1no               		MEDIUMINT		 NULL  COMMENT '�ߺз�'
) COMMENT='����';

/**********************************/
/* Table Name: ���� ��� */
/**********************************/
CREATE TABLE itemreply(
		itemreplyno                   		MEDIUMINT		 NOT NULL COMMENT '���� ��� ��ȣ',
		itemreplycontent              		VARCHAR(200)		 NOT NULL COMMENT '��� ����',
		itemno                        		MEDIUMINT		 NOT NULL COMMENT '�Խù� ��ȣ'
) COMMENT='���� ���';

/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE storage(
		storageno                     		MEDIUMINT		 NOT NULL AUTO_INCREMENT COMMENT '���� ��ȣ',
		title                         		VARCHAR(20)		 NOT NULL COMMENT '��ǰ����',
		content                       		VARCHAR(200)		 NOT NULL COMMENT '��ǰ����',
		rdate                         		DATE		 NOT NULL COMMENT '�����',
		thumb_file1                   		VARCHAR(100)		 NULL  COMMENT '������1',
		itemno                        		MEDIUMINT		 NOT NULL AUTO_INCREMENT COMMENT '�Խù� ��ȣ'
) COMMENT='����';

/**********************************/
/* Table Name: ȸ�� */
/**********************************/
CREATE TABLE member(
		mno                           		INT(10)		 NOT NULL COMMENT 'ȸ����ȣ',
		id                            		VARCHAR(20)		 NOT NULL COMMENT '���̵�',
		passwd                        		VARCHAR(20)		 NOT NULL COMMENT '��й�ȣ',
		email                         		VARCHAR(50)		 NOT NULL COMMENT '�̸���',
		mail                          		CHAR(1)		 NOT NULL COMMENT '�̸�������',
		visible                       		CHAR(1)		 NOT NULL COMMENT '��������',
		mname                         		VARCHAR(20)		 NOT NULL COMMENT '����',
		sex                           		VARCHAR(10)		 NOT NULL COMMENT '����',
		profil                        		VARCHAR(200)		 NOT NULL COMMENT '�����ʼҰ�',
		profil_picture                		VARCHAR(300)		 NOT NULL COMMENT '�����ʻ���',
		tel                           		VARCHAR(14)		 NOT NULL COMMENT '����ȭ',
		phone                         		VARCHAR(14)		 NOT NULL COMMENT '�ڵ�����ȣ',
		sms                           		CHAR(1)		 NOT NULL COMMENT '��������',
		zipcode                       		VARCHAR(5)		 NULL  COMMENT '�����ּ�',
		address1                      		VARCHAR(80)		 NULL  COMMENT '�ּ�',
		address2                      		VARCHAR(50)		 NULL  COMMENT '���ּ�',
		mdate                         		DATETIME		 NOT NULL COMMENT '������'
) COMMENT='ȸ��';

/**********************************/
/* Table Name: ���������� */
/**********************************/
CREATE TABLE mypage(
		mypageno                      		MEDIUMINT(10)		 NOT NULL COMMENT '������������ȣ',
		mno                           		MEDIUMINT(10)		 NOT NULL COMMENT 'ģ����ȣ',
		upload_itemno                 		MEDIUMINT(100)		 NOT NULL COMMENT '���ε幰ǰ��',
		title                         		VARCHAR(200)		 NOT NULL COMMENT '����<�ӽ�>',
		content                       		VARCHAR(300)		 NOT NULL COMMENT '����<�ӽ�>',
		thumb_file1                   		VARCHAR(300)		 NOT NULL COMMENT '������1<�ӽ�>',
		rdate                         		TIMESTAMP		 NOT NULL COMMENT '�����<�ӽ�>',
		udate                         		TIMESTAMP		 NOT NULL COMMENT '������<�ӽ�>',
		replycnt                      		SMALLINT		 DEFAULT 0		 NOT NULL COMMENT '���',
		itemno                        		MEDIUMINT		 NULL  COMMENT '�Խù� ��ȣ'
) COMMENT='����������';


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

