package dev.mvc.member;

import java.util.ArrayList;
import java.util.Map;

public interface MemberMapperInter {
  /**
   * ���ڵ带 ����մϴ�.
   * <insert id="create" parameterType="MemberVO">
   * @param vo ����� ������ ��ü
   * @return ��ϵ� ���ڵ� ��
   */
  public int create(MemberVO memberVO);

  /**
   * �ߺ� ���̵� �˻��մϴ�.
   * <select id='chkid' resultType='int' parameterType="String">
   * @param nick ���̵�
   * @return 0: �ߺ��ƴ�, 1: �ߺ�
   */
  public int chkid(String id);
  
  /**
   * �ߺ� �̸��� �˻��մϴ�.
   * <select id="chkemail" resultType='int' parameterType='String'>
   * @param email
   * @return
   */
  public int chkemail(String email);
  
  
  /**
   * ȸ����ü���
   * <select id='list' resultType="MemberVO">
   * @return ȸ�����
   */ 
  public ArrayList<MemberVO> list();
  
  /**#��ȸ(ȸ��������ȸ)
   * <select id="read" resultType="MemberVO" parameterType="int">
   * @return 
   */
  public MemberVO read(int mno);
  
  /**
   * ȸ������ ����
   * <update id="update" parameterType="MemberVO">
   * @param memberVO
   * @return ������ ���ڵ� ����
   */
  public int update(MemberVO memberVO);
  
  /**
   * �н����带 �˻�
   * <select id="passwdCheck" resultType="int" parameterType="Map">
   * @param memberVO
   * @return 0: , 1: 
   */
  public int passwdCheck(Map map);  
  
  
  /**�н���������� �ߺ��˻�
   * <update id="update_passwd" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int update_passwd(MemberVO memberVO);
  
  /**����
   * <select id="delete" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int delete(MemberVO memberVO); 
  
  /**�α���
   * <select id="login" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int login(MemberVO memberVO);  
  
}


