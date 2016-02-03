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
  private SqlSession sqlSession; // MyBATIS 3 연결 객체
  
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
   
  /**#조회(회원정보조회)
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
   * 기존 등록된 패스워드를 검사합니다.
   * 실제컴럼과 VO의 변수가 다른경우의 처리, Map사용
   * <select id="passwdCheck" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return 0: , 1: 
   */  
  @Override
  public int passwdCheck(MemberVO memberVO){
    int mno = memberVO.getMno();
    String passwd = memberVO.getOld_passwd(); // 기존 패스워드
      
    Map map = new HashMap(); 
    map.put("mno", mno);
    map.put("passwd", passwd);
    return mapper().passwdCheck(map);
  }
  
  @Override
  public int update_passwd(MemberVO memberVO){
    return mapper().update_passwd(memberVO);
  }
  
  /**삭제
   * <select id="delete" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  @Override 
  public int delete(MemberVO memberVO){
    return mapper().delete(memberVO);
  }

  /**로그인
   * <select id="login" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  @Override
  public int login(MemberVO memberVO){
    return mapper().login(memberVO);
  }


}



