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
    
    // --------------------------------------------------
    // Thumb ���� ���� ����
    // --------------------------------------------------
    String file = "";
    String absPath = Tool.getRealPath(request, "/item/storage");
    MultipartFile fileMF = itemVO.getFileMF();
    if (fileMF != null){
      if (fileMF.getSize() > 0){
        file = Upload.saveFileSpring(fileMF, absPath);
        itemVO.setFile(file); // ���۵� ���ϸ� ����
      }
    }
    // --------------------------------------------------

    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------
    String file1 = "";
    MultipartFile file1MF = itemVO.getFile1MF();
    if (file1MF != null){
      if (file1MF.getSize() > 0){
        file1 = Upload.saveFileSpring(file1MF, absPath);
        itemVO.setFile1(file1); // ���۵� ���ϸ� ����
      }
    }
    // --------------------------------------------------
    
    if (itemDAO.create(itemVO) == 1){ 
      msgs.add("���� ����߽��ϴ�.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    }else{
      msgs.add("�� ��Ͽ� �����߽��ϴ�.");
      msgs.add("�ٽ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./home.do'\">Ȩ������</button>");
    links.add("<button type='button' onclick=\"location.href='./list2.do?itemcategoryno="+itemVO.getItemcategoryno()+"'\">���</button>");
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
  
  /**
   * ���� ��ȸ�մϴ�
   * @param mno
   * @return
   */
  @RequestMapping(value = "/item/read.do", method = RequestMethod.GET)
  public ModelAndView read(int itemno, int itemcategoryno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/read");
    mav.addObject("itemVO", itemDAO.read(itemno));
    
    ItemcategoryVO vo = itemcategoryDAO.read(itemcategoryno);
    mav.addObject("title", vo.getTitle());

    return mav;
  }
  
  /**
   * ������
   * @param itemno
   * @return
   */
  @RequestMapping(value="/item/update.do", 
      method=RequestMethod.GET)
  public ModelAndView update(int itemno){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/update");
    
    ItemVO itemVO = itemDAO.read(itemno);
    mav.addObject("itemVO", itemDAO.read(itemno)); 
    
    ItemcategoryVO vo = itemcategoryDAO.read(itemVO.getItemcategoryno());
    mav.addObject("title", vo.getTitle());
    
    return mav;

  }
   
  /**
   * ���� ó��
   * @param itemVO
   * @return
   */
  @RequestMapping(value="/item/update.do", method=RequestMethod.POST) 
  public ModelAndView update(ItemVO itemVO, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    // --------------------------------------------------
    // Thumb ���� ���� ����
    // --------------------------------------------------
    String file = "";
    String absPath = Tool.getRealPath(request, "/item/storage");
    MultipartFile fileMF = itemVO.getFileMF();
    

    if (fileMF != null){
      if (fileMF.getSize() > 0){
        Tool.deleteFile(absPath + itemVO.getOldfile());
        file = Upload.saveFileSpring(fileMF, absPath);
        itemVO.setFile(file); // ���۵� ���ϸ� ����
      }
    }
    // --------------------------------------------------

    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------
    String file1 = "";
    absPath = Tool.getRealPath(request, "/item/storage");
    MultipartFile file1MF = itemVO.getFile1MF();
    if (file1MF != null){
      if (file1MF.getSize() > 0){
        Tool.deleteFile(absPath + itemVO.getOldfile1());
        file1 = Upload.saveFileSpring(file1MF, absPath);
        itemVO.setFile1(file1); // ���۵� ���ϸ� ����
      }
    }
    // --------------------------------------------------
    
    if(itemDAO.update(itemVO) == 1){
      // ������ ��ȸ�� �ڵ� �̵�
      mav.setViewName("redirect:/item/read.do?itemno=" + itemVO.getItemno() + "&itemcategoryno=" + itemVO.getItemcategoryno()); // Ȯ���� ���
    }else{
      msgs.add("�Խ��� ������ ���� �ϼ̽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do?itemcategoryno="+itemVO.getItemcategoryno()+"'\">���</button>");
      mav.addObject("msgs", msgs);
      mav.addObject("links", links);
    }
    
    return mav;
  }
  
  /**
   * ������
   * @param itemno
   * @return
   */
  @RequestMapping(value = "/item/delete.do", method = RequestMethod.GET)
  public ModelAndView delete(int itemno, int itemcategoryno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/delete"); // /webapp/member/delete.jsp
    mav.addObject("itemno", itemno);
    mav.addObject("itemcategoryno", itemcategoryno);
    
    ItemcategoryVO vo = itemcategoryDAO.read(itemcategoryno);
    mav.addObject("title", vo.getTitle());
    
    return mav;
  }
  
  /**
   * ���� ó��
   * @param itemVO
   * @return
   */
  @RequestMapping(value = "/item/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(ItemVO itemVO,
                                        HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    // --------------------------------------------------
    // Thumb ���� ����
    // --------------------------------------------------
    ItemVO vo = itemDAO.read(itemVO.getItemno());
    String absPath = Tool.getRealPath(request, "/item/storage");
    Tool.deleteFile(absPath + vo.getOldfile());
    // --------------------------------------------------

    // --------------------------------------------------
    // ���� ���� ����
    // --------------------------------------------------
    Tool.deleteFile(absPath + vo.getOldfile1());
    // --------------------------------------------------
    
    if (itemDAO.delete(itemVO.getItemno()) == 1) {
      mav.setViewName("redirect:/item/list2.do?itemcategoryno=" + itemVO.getItemcategoryno());//Ȯ���� ���
    } else {
      msgs.add("�� ������ �����߽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='./home.do'\">Ȩ������</button>");
      links.add("<button type='button' onclick=\"location.href='./list2.do?itemcategoryno="+itemVO.getItemcategoryno()+"'\">���</button>");
    }
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

  /**
   * �Խ��Ǻ� ���
   * @param itemVO itemcategoryno�� ���� ������ ���
   * @return
   */
  @RequestMapping(value = "/item/list2.do", method = RequestMethod.GET)
  public ModelAndView list2(ItemVO itemVO){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/item/list2");
    mav.addObject("list", itemDAO.list2(itemVO));
    mav.addObject("itemVO", itemVO);

    ItemcategoryVO vo = itemcategoryDAO.read(itemVO.getItemcategory1no());
    mav.addObject("title", vo.getTitle());
    
    return mav;
  }

}