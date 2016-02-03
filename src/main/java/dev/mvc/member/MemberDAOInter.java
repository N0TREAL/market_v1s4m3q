package dev.mvc.member;

import java.util.ArrayList;
import java.util.Map;

public interface MemberDAOInter {
  /**
   * 레코드를 등록합니다.
   * <insert id="create" parameterType="MemberVO">
   * @param vo 등록할 데이터 객체
   * @return 등록된 레코드 수
   */
  public int create(MemberVO memberVO);
  /**
   * 중복 아이디를 검사합니다.
   * <select id='chkid' resultType='int' parameterType="String">
   * @param nick 아이디
   * @return 0: 중복아님, 1: 중복
   */
  public int chkid(String id);

  /**
   * 중복 이메일 검사합니다.
   * <select id="chkemail" resultType='int' parameterType='String'>
   * @param email
   * @return
   */
  public int chkemail(String email);
  
  /**
   * 회원전체목록
   * <select id='list' resultType="MemberVO">
   * @return 회원목록
   */ 
  public ArrayList<MemberVO> list();

  /**#조회(회원정보조회)
   * <select id="read" resultType="MemberVO" parameterType="int">
   * @return 
   */
  public MemberVO read(int mno);
  
  /**
   * 회원을 수정합니다.
   * <update id="update" parameterType="MemberVO">
   * @param memberVO
   * @return 수정된 레코드 갯수
   */
  public int update(MemberVO memberVO);
  
/*  *//**
   * 회원권한 변경
   * <update id="update_visible" parameterType="MemberVO">
   * @param memberVO
   * @return
   *//*
  public int update_visible(int mno);*/
  
  /**
   * 패스워드를 검사합니다.
   * <select id="passwdCheck" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return 0: 중복아님, 1: 중복
   */
  public int passwdCheck(MemberVO memberVO); 
  
  /**패스워드수정시 중복검사
   * <update id="update_passwd" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int update_passwd(MemberVO memberVO);

  /**삭제
   * <select id="delete" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int delete(MemberVO memberVO); 
  
  /**로그인
   * <select id="login" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int login(MemberVO memberVO); 
  
}
