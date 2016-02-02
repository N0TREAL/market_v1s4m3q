package dev.mvc.item;

import org.springframework.web.multipart.MultipartFile;

public class ItemVO {
/*	CREATE TABLE item(
			itemno                     MEDIUMINT		 NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '게시물 번호',
			uploader                   VARCHAR(20)		 NOT NULL COMMENT '작성자',
			title                          VARCHAR(20)		 NOT NULL COMMENT '제목',
			content                     VARCHAR(200)	 NOT NULL COMMENT '내용',
			rdate                         DATE		 		 NOT NULL COMMENT '등록일',
			udate                        DATE		 			 NOT NULL COMMENT '수정일',
			thumb_file1               VARCHAR(100)		 NULL  COMMENT '썸파일1',
			thumb_file2               VARCHAR(100)		 NULL  COMMENT '썸파일2',
			thumb_file3               VARCHAR(100)		 NULL  COMMENT '썸파일3',
			file1                       	VARCHAR(300)		 NOT NULL COMMENT '파일이름1',
			file2                       	VARCHAR(300)		 NULL  COMMENT '파일이름2',
			file3                         	VARCHAR(300)		 NULL  COMMENT '파일이름3',
			cnt                           	MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '조회수',
			recom                       	MEDIUMINT		 DEFAULT 0		 NOT NULL COMMENT '추천수',
			replycnt                    	SMALLINT		 	 DEFAULT 0		 NOT NULL COMMENT '댓글수',
			itemcategory1no        MEDIUMINT		 NOT NULL  COMMENT '중분류'
	) COMMENT='물건';*/
	
	private int itemno;
	private String uploader;
	private String title;
	private String content;
	private String rdate;
	private String udate;
	private String thumb_file1;
	private String thumb_file2;
	private String thumb_file3;
	private String file1;
	private String file2;
	private String file3;
	private int cnt;
	private int recom;
	private int replycnt;
	private int itemcategory1no;
	
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getThumb_file1() {
		return thumb_file1;
	}
	public void setThumb_file1(String thumb_file1) {
		this.thumb_file1 = thumb_file1;
	}
	public String getThumb_file2() {
		return thumb_file2;
	}
	public void setThumb_file2(String thumb_file2) {
		this.thumb_file2 = thumb_file2;
	}
	public String getThumb_file3() {
		return thumb_file3;
	}
	public void setThumb_file3(String thumb_file3) {
		this.thumb_file3 = thumb_file3;
	}
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile2() {
		return file2;
	}
	public void setFile2(String file2) {
		this.file2 = file2;
	}
	public String getFile3() {
		return file3;
	}
	public void setFile3(String file3) {
		this.file3 = file3;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getRecom() {
		return recom;
	}
	public void setRecom(int recom) {
		this.recom = recom;
	}
	public int getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	public int getItemcategory1no() {
		return itemcategory1no;
	}
	public void setItemcategory1no(int itemcategory1no) {
		this.itemcategory1no = itemcategory1no;
	}
	
}
