package dev.mvc.item;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class ItemDAO implements ItemMapperInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ¿¬°á °´Ã¼
  
  public ItemDAO(){
    System.out.println("--> CodeDAO created.");
  }
  
  public ItemMapperInter mapper(){
    ItemMapperInter mapper = sqlSession.getMapper(ItemMapperInter.class);    
    
    return mapper;
  }
  
}