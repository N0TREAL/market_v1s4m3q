package dev.mvc.storage;

public class StorageVO {

  /*
  CREATE TABLE storage(
      storageno                         MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '찜목록 번호',
      title                             VARCHAR(20)    NOT NULL COMMENT '상품제목',
      content                           VARCHAR(200)     NOT NULL COMMENT '상품내용',
      rdate                             DATE     NOT NULL COMMENT '등록일',
      thumb_file1                       VARCHAR(100)     NULL  COMMENT '썸파일1',
      itemno                            MEDIUMINT    NOT NULL COMMENT '게시물 목록'
  ) COMMENT='찜목록 번호';
  */
  
  private int storageno;
  private String title;
  private String content;
  private String rdate;
  private String thumb_file1;
  private int itemno;
  
  
  
  public int getStorageno() {
    return storageno;
  }
  public void setStorageno(int storageno) {
    this.storageno = storageno;
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
  public String getThumb_file1() {
    return thumb_file1;
  }
  public void setThumb_file1(String thumb_file1) {
    this.thumb_file1 = thumb_file1;
  }
  public int getItemno() {
    return itemno;
  }
  public void setItemno(int itemno) {
    this.itemno = itemno;
  }
  
  
  
}
