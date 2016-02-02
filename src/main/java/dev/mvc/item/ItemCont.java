package dev.mvc.item;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
 
@Controller
public class ItemCont {
  @Autowired
  @Qualifier("dev.mvc.item.itemDAO")
  private ItemDAO itemDAO;
  
  public ItemCont(){
    System.out.println("--> ItemCont created.");
  }
}