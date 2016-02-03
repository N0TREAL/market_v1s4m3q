package dev.mvc.member;

public class MemberVO {
/*
    mno                               MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '회원번호',
    id                                VARCHAR(20)    NOT NULL COMMENT '아이디',
    passwd                            VARCHAR(20)    NOT NULL COMMENT '비밀번호',
    email                             VARCHAR(50)    NOT NULL COMMENT '이메일',
    sms                               CHAR(1)    NOT NULL COMMENT 'SMS여부',
    visible                           CHAR(1)    NOT NULL COMMENT '열람권한',
    mname                             VARCHAR(20)    NOT NULL COMMENT '이름',
    sex                               CHAR(1)    NOT NULL COMMENT '성별',
    birth                             VARCHAR(20)    NOT NULL COMMENT '생년월일',
    phone                             VARCHAR(14)    NOT NULL COMMENT '핸드폰번호',
    zipcode                           VARCHAR(5)     NULL  COMMENT '우편번호',
    address1                          VARCHAR(80)    NULL  COMMENT '주소',
    address2                          VARCHAR(50)    NULL  COMMENT '상세주소',
    mdate                             DATETIME     NOT NULL COMMENT '등록일',
*/
  
  private int mno;
  private String id;
  private String passwd;
  private String email;
  private String sms;
  private String visible;
  private String mname;
  private String sex;
  private String birth;
  private String phone;
  private String zipcode;
  private String address1;
  private String address2;
  private String mdate;
  
  /** 기존패스워드/ 로직관련 */
  private String old_passwd;
  /** 아이디 저장여부 */
  private String id_save;
  /** 패스워드 저장여부 */
  private String passwd_save;
  /** 이동할 주소 저장 */
  private String url_address;
  
  
  
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPasswd() {
    return passwd;
  }
  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getSms() {
    return sms;
  }
  public void setSms(String sms) {
    this.sms = sms;
  }
  public String getVisible() {
    return visible;
  }
  public void setVisible(String visible) {
    this.visible = visible;
  }
  public String getMname() {
    return mname;
  }
  public void setMname(String mname) {
    this.mname = mname;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public String getBirth() {
    return birth;
  }
  public void setBirth(String birth) {
    this.birth = birth;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getZipcode() {
    return zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public String getAddress1() {
    return address1;
  }
  public void setAddress1(String address1) {
    this.address1 = address1;
  }
  public String getAddress2() {
    return address2;
  }
  public void setAddress2(String address2) {
    this.address2 = address2;
  }
  public String getMdate() {
    return mdate;
  }
  public void setMdate(String mdate) {
    this.mdate = mdate;
  }
  public String getOld_passwd() {
    return old_passwd;
  }
  public void setOld_passwd(String old_passwd) {
    this.old_passwd = old_passwd;
  }
  public String getId_save() {
    return id_save;
  }
  public void setId_save(String id_save) {
    this.id_save = id_save;
  }
  public String getPasswd_save() {
    return passwd_save;
  }
  public void setPasswd_save(String passwd_save) {
    this.passwd_save = passwd_save;
  }
  public String getUrl_address() {
    return url_address;
  }
  public void setUrl_address(String url_address) {
    this.url_address = url_address;
  }
  
  

  
}
