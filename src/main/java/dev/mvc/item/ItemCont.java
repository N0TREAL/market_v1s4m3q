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
    // Thumb 파일 전송 관련
    // --------------------------------------------------
    String file = "";
    String absPath = Tool.getRealPath(request, "/item/storage");
    MultipartFile fileMF = itemVO.getFileMF();
    if (fileMF != null){
      if (fileMF.getSize() > 0){
        file = Upload.saveFileSpring(fileMF, absPath);
        itemVO.setFile(file); // 전송된 파일명 저장
      }
    }
    // --------------------------------------------------

    // --------------------------------------------------
    // 파일 전송 관련
    // --------------------------------------------------
    String file1 = "";
    MultipartFile file1MF = itemVO.getFile1MF();
    if (file1MF != null){
      if (file1MF.getSize() > 0){
        file1 = Upload.saveFileSpring(file1MF, absPath);
        itemVO.setFile1(file1); // 전송된 파일명 저장
      }
    }
    // --------------------------------------------------
    
    if (itemDAO.create(itemVO) == 1){ 
      msgs.add("글을 등록했습니다.");
      links.add("<button type='button' onclick=\"location.href='./create.do'\">계속 등록</button>");
    }else{
      msgs.add("글 등록에 실패했습니다.");
      msgs.add("다시 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./home.do'\">홈페이지</button>");
    links.add("<button type='button' onclick=\"location.href='./list2.do?itemcategoryno="+itemVO.getItemcategoryno()+"'\">목록</button>");
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
   * 글을 조회합니다
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
   * 수정폼
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
   * 수정 처리
   * @param itemVO
   * @return
   */
  @RequestMapping(value="/item/update.do", method=RequestMethod.POST) 
  public ModelAndView update(ItemVO itemVO, HttpServletRequest request){
    ModelAndView mav = new ModelAndView();
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    // --------------------------------------------------
    // Thumb 파일 전송 관련
    // --------------------------------------------------
    String file = "";
    String absPath = Tool.getRealPath(request, "/item/storage");
    MultipartFile fileMF = itemVO.getFileMF();
    

    if (fileMF != null){
      if (fileMF.getSize() > 0){
        Tool.deleteFile(absPath + itemVO.getOldfile());
        file = Upload.saveFileSpring(fileMF, absPath);
        itemVO.setFile(file); // 전송된 파일명 저장
      }
    }
    // --------------------------------------------------

    // --------------------------------------------------
    // 파일 전송 관련
    // --------------------------------------------------
    String file1 = "";
    absPath = Tool.getRealPath(request, "/item/storage");
    MultipartFile file1MF = itemVO.getFile1MF();
    if (file1MF != null){
      if (file1MF.getSize() > 0){
        Tool.deleteFile(absPath + itemVO.getOldfile1());
        file1 = Upload.saveFileSpring(file1MF, absPath);
        itemVO.setFile1(file1); // 전송된 파일명 저장
      }
    }
    // --------------------------------------------------
    
    if(itemDAO.update(itemVO) == 1){
      // 수정후 조회로 자동 이동
      mav.setViewName("redirect:/item/read.do?itemno=" + itemVO.getItemno() + "&itemcategoryno=" + itemVO.getItemcategoryno()); // 확장자 명시
    }else{
      msgs.add("게시판 수정에 실패 하셨습니다.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do?itemcategoryno="+itemVO.getItemcategoryno()+"'\">목록</button>");
      mav.addObject("msgs", msgs);
      mav.addObject("links", links);
    }
    
    return mav;
  }
  
  /**
   * 삭제폼
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
   * 삭제 처리
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
    // Thumb 파일 삭제
    // --------------------------------------------------
    ItemVO vo = itemDAO.read(itemVO.getItemno());
    String absPath = Tool.getRealPath(request, "/item/storage");
    Tool.deleteFile(absPath + vo.getOldfile());
    // --------------------------------------------------

    // --------------------------------------------------
    // 파일 전송 관련
    // --------------------------------------------------
    Tool.deleteFile(absPath + vo.getOldfile1());
    // --------------------------------------------------
    
    if (itemDAO.delete(itemVO.getItemno()) == 1) {
      mav.setViewName("redirect:/item/list2.do?itemcategoryno=" + itemVO.getItemcategoryno());//확장자 명시
    } else {
      msgs.add("글 삭제에 실패했습니다.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
      links.add("<button type='button' onclick=\"location.href='./home.do'\">홈페이지</button>");
      links.add("<button type='button' onclick=\"location.href='./list2.do?itemcategoryno="+itemVO.getItemcategoryno()+"'\">목록</button>");
    }
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

  /**
   * 게시판별 목록
   * @param itemVO itemcategoryno를 구분 값으로 사용
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