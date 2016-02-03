package dev.mvc.storage;
 
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository("dev.mvc.storage.StorageDAO")
public class StorageDAO implements StorageMapperInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 연결 객체
  
  public StorageDAO(){
    System.out.println("--> StorageDAO created.");
  }
  
  public StorageMapperInter mapper(){
    StorageMapperInter mapper = sqlSession.getMapper(StorageMapperInter.class);    
    
    return mapper;
  }
  
  /**
   * 등록
   * <insert id="create" parameterType="StorageVO">
   */
  @Override
  public int create(StorageVO storageVO){
    return mapper().create(storageVO);
  }
  
  /**
   * 목록
   * <select id="list" resultType="StorageVO">
   */
  @Override
  public ArrayList<StorageVO> list(){
    return mapper().list();
  }
  
  /**
   * 수정
   * <update id="update" parameterType="StorageVO">
   */
  @Override
  public int update(StorageVO storageVO){
    return mapper().update(storageVO);
  }

  /**
   * 삭제
   * <delete id="delete" parameterType="int">
   */
  @Override
  public int delete(int storageno){
    return mapper().delete(storageno);
  }
  
  
  
}






