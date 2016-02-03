/**********************************/
/* Table Name: ȸ�� */
/**********************************/
CREATE TABLE member(
		mno                           		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT 'ȸ����ȣ',
		id                            		VARCHAR(20)		 NOT NULL COMMENT '���̵�',
		passwd                        		VARCHAR(20)		 NOT NULL COMMENT '��й�ȣ',
		email                         		VARCHAR(50)		 NOT NULL COMMENT '�̸���',
		sms                           		CHAR(1)		 NOT NULL COMMENT 'SMS����',
		visible                       		CHAR(1)		 NOT NULL COMMENT '��������',
		mname                         		VARCHAR(20)		 NOT NULL COMMENT '�̸�',
		sex                           		CHAR(1)		 NOT NULL COMMENT '����',
		birth                         		VARCHAR(20)		 NOT NULL COMMENT '�������',
		phone                         		VARCHAR(14)		 NOT NULL COMMENT '�ڵ�����ȣ',
		zipcode                       		VARCHAR(5)		 NULL  COMMENT '�����ȣ',
		address1                      		VARCHAR(80)		 NULL  COMMENT '�ּ�',
		address2                      		VARCHAR(50)		 NULL  COMMENT '���ּ�',
		mdate                         		DATETIME		 NOT NULL COMMENT '�����',
  CONSTRAINT email UNIQUE (email),
  CONSTRAINT id UNIQUE (id)
) COMMENT='ȸ��';

/**********************************/
/* Table Name: ���������� */
/**********************************/
CREATE TABLE mypage(
		mypageno                      		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '������������ȣ',
		upload_itemno                 		MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '���ε幰ǰ��',
		profil_content                		VARCHAR(300)		 NOT NULL COMMENT '������',
		profil_file                   		VARCHAR(300)		 NULL  COMMENT '������_����',
		replycnt                      		SMALLINT		 DEFAULT 0		 NOT NULL COMMENT '��ۼ�',
		mno                           		MEDIUMINT		 NULL  COMMENT 'ȸ����ȣ',
  FOREIGN KEY (mno) REFERENCES memberv1 (mno)
) COMMENT='����������';

/**********************************/
/* Table Name: �޼����� */
/**********************************/
CREATE TABLE message(
		messageno                     		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '������ȣ',
		title                         		VARCHAR(200)		 NOT NULL COMMENT '��������',
		content                       		VARCHAR(300)		 NOT NULL COMMENT '��������',
		rdate                         		DATETIME		 NOT NULL COMMENT '�����',
		mypageno                      		MEDIUMINT		 NULL  COMMENT '������������ȣ',
  FOREIGN KEY (mypageno) REFERENCES mypage (mypageno)
) COMMENT='�޼�����';

