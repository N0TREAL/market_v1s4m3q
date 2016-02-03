package dev.mvc.storage;
 
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository("dev.mvc.storage.StorageDAO")
public class StorageDAO implements StorageMapperInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ���� ��ü
  
  public StorageDAO(){
    System.out.println("--> StorageDAO created.");
  }
  
  public StorageMapperInter mapper(){
    StorageMapperInter mapper = sqlSession.getMapper(StorageMapperInter.class);    
    
    return mapper;
  }
  
  /**
   * ���
   * <insert id="create" parameterType="StorageVO">
   */
  @Override
  public int create(StorageVO storageVO){
    return mapper().create(storageVO);
  }
  
  /**
   * ���
   * <select id="list" resultType="StorageVO">
   */
  @Override
  public ArrayList<StorageVO> list(){
    return mapper().list();
  }
  
  /**
   * ����
   * <update id="update" parameterType="StorageVO">
   */
  @Override
  public int update(StorageVO storageVO){
    return mapper().update(storageVO);
  }

  /**
   * ����
   * <delete id="delete" parameterType="int">
   */
  @Override
  public int delete(int storageno){
    return mapper().delete(storageno);
  }
  
  
  
}






