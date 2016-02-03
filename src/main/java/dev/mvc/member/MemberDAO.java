package dev.mvc.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.ReverbType;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;  

@Repository("dev.mvc.member.MemberDAO")
public class MemberDAO implements MemberDAOInter {
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ���� ��ü
  
  public MemberDAO(){
    System.out.println("--> MemberDAO created.");
  }
  
  public MemberMapperInter mapper(){
    MemberMapperInter mapper = sqlSession.getMapper(MemberMapperInter.class);    
    
    return mapper;
  }

  @Override
  public int create(MemberVO memberVO) {
    return mapper().create(memberVO);
  }
  
  @Override
  public int chkid(String id) {
    return mapper().chkid(id);
  }  
  
  @Override
  public int chkemail(String email) {
    return mapper().chkemail(email);
  }
 
  @Override
  public ArrayList<MemberVO> list(){ 
    return mapper().list();  
  }
   
  /**#��ȸ(ȸ��������ȸ)
   * <select id="read" resultType="MemberVO" parameterType="int">
   * @return 
   */
  @Override
  public MemberVO read(int mno){
    return mapper().read(mno);
  }    
 
  @Override 
  public int update(MemberVO memberVO){
    return mapper().update(memberVO);
  }
  
  /**
   * ���� ��ϵ� �н����带 �˻��մϴ�.
   * �����ķ��� VO�� ������ �ٸ������ ó��, Map���
   * <select id="passwdCheck" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return 0: , 1: 
   */  
  @Override
  public int passwdCheck(MemberVO memberVO){
    int mno = memberVO.getMno();
    String passwd = memberVO.getOld_passwd(); // ���� �н�����
      
    Map map = new HashMap(); 
    map.put("mno", mno);
    map.put("passwd", passwd);
    return mapper().passwdCheck(map);
  }
  
  @Override
  public int update_passwd(MemberVO memberVO){
    return mapper().update_passwd(memberVO);
  }
  
  /**����
   * <select id="delete" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  @Override 
  public int delete(MemberVO memberVO){
    return mapper().delete(memberVO);
  }

  /**�α���
   * <select id="login" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  @Override
  public int login(MemberVO memberVO){
    return mapper().login(memberVO);
  }


}



