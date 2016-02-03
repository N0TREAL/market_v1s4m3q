package dev.mvc.item;
 
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.mvc.item.ItemVO;
 
@Repository("dev.mvc.item.ItemDAO")
public class ItemDAO implements ItemMapperInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ¿¬°á °´Ã¼
  
  public ItemDAO(){
    System.out.println("--> ItemDAO created.");
  }
  
  public ItemMapperInter mapper(){
    ItemMapperInter mapper = sqlSession.getMapper(ItemMapperInter.class);    
    
    return mapper;
  }
  
  @Override
  public int create(ItemVO itemVO) {
    return mapper().create(itemVO);
  }

  @Override
  public ArrayList<ItemVO> list() {
    return mapper().list();
  }

  @Override
  public ItemVO read(int itemno) {
    return mapper().read(itemno);
  }

  @Override
  public int update(ItemVO itemVO) {
    return mapper().update(itemVO);
  }

  @Override
  public int delete(int itemno) {
    return mapper().delete(itemno);
  }

  
}