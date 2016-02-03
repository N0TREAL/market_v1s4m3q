package dev.mvc.item;
 
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import web.tool.Tool;
import web.tool.Upload;

@Controller
public class ItemCont {
  @Autowired
  @Qualifier("dev.mvc.item.itemDAO")
  private ItemDAO itemDAO;
  
  public ItemCont(){
    System.out.println("--> ItemCont created.");
  }
  
  @RequestMapping(value="/item/create.do", method=RequestMethod.GET)
  public ModelAndView create(ItemVO itemVO){
    // System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/create");   // /webapp/item/create.jsp
    mav.addObject("itemVO", itemVO);
    
    return mav;
  }

  @RequestMapping(value="/item/create.do", method=RequestMethod.POST)
  public ModelAndView create(ItemVO itemVO, HttpServletRequest request){
    // System.out.println("--> create() POST called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
  
    if (itemDAO.create(itemVO) == 1){ 
      msgs.add("���� ����߽��ϴ�.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    }else{
      msgs.add("�� ��Ͽ� �����߽��ϴ�.");
      msgs.add("�ٽ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./home.do'\">Ȩ������</button>");
    links.add("<button type='button' onclick=\"location.href='./list2.do?itemno="+itemVO.getItemno()+"'\">���</button>");
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  @RequestMapping(value = "/item/list.do", method = RequestMethod.GET)
  public ModelAndView list(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/list");
    mav.addObject("list", itemDAO.list());
    
    return mav;
  }

}