package dev.mvc.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import web.tool.Tool;
  
@Controller     
public class MemberCont {
  @Autowired
  @Qualifier("dev.mvc.member.MemberDAO")
  private MemberDAOInter memberDAO; //** MemberDAOInter 인터페이스 선언: 자동으로 구현클래스가 할당
  
  public MemberCont(){
    System.out.println("--> MemberCont created.");
  }

  @RequestMapping(value="/a_member/create.do", method=RequestMethod.GET)
  public ModelAndView create(){
    System.out.println("-->create () GET방식");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/create"); // /webapp/member/create.jsp
    
    return mav;
  }
  
  @RequestMapping(value="/a_member/create.do", method=RequestMethod.POST) 
  // 회원가입: create.jsp에서 method='POST'이기 때문에 .POST설정
  public ModelAndView create(MemberVO memberVO){ 
    System.out.println("-->create () POST방식");
    ModelAndView mav = new ModelAndView();
    //System.out.println("visible-->:" + memberVO.getVisible());
    //System.out.println("ids-->:" + memberVO.getIds());
   
    mav.setViewName("/a_member/message");
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.create(memberVO) == 1){
      msgs.add("회원가입이 처리되었습니다.");
      msgs.add("BaiBolg에 오신걸 환영합니다.");  // \: "으로 문자열 끝나는걸 막기위해 사용
      links.add("<button type='button' onclick=\"location.href='./login.do'\">로그인</button>");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">홈페이지</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">목록</button>");
    }else{
      msgs.add("회원가입에 실패 하셨습니다.");
      msgs.add("다시 한번 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">홈페이지</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">목록</button>");
    }
    
    mav.addObject("msgs", msgs); 
    mav.addObject("links", links);
    
    return mav;
  }
  
  /**
   * 중복 아이디을 검사합니다.
   * @param id
   * @param locale
   * @param model
   * @return
   */
  @ResponseBody  
  @RequestMapping(value = "/a_member/chkid.do", method = RequestMethod.POST,
                            produces="text/plain;charset=UTF-8") // 출력형식
  public String chkid(String id, Locale locale, Model model) {
  
    JSONObject obj = new JSONObject();
    
    int cnt = memberDAO.chkid(id);
    obj.put("cnt", cnt);
  
    System.out.println(id);
    System.out.println(cnt);
    return obj.toJSONString();
  }  
  
  /**
   * 중복 이메일를 검사합니다.
   * @param email
   * @param locale
   * @param model
   * @return
   */
  @ResponseBody  // Spring은 jsp를 사용해야하는데, jsp view를 이용하여 출력하지않고 단순 문자열을 출력할때 사용
  @RequestMapping(value = "/a_member/chkemail.do", method = RequestMethod.POST,
                            produces="text/plain;charset=UTF-8") // 출력형식
  public String chkemail(String email, Locale locale, Model model) {
  
    JSONObject obj = new JSONObject();
        
    int cnt = memberDAO.chkemail(email);
    obj.put("cnt", cnt);
  
    System.out.println(email);
    System.out.println(cnt);
    return obj.toJSONString();
  }

  /**
   * 전체 목록: 
   * @return
   */
  @RequestMapping(value="/a_member/list.do", method=RequestMethod.GET)
  public ModelAndView list(){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/list");
    mav.addObject("list", memberDAO.list());
    
    return mav;
  }
  
  /**
   * 인쇄용 목록: 페이지만 list2로 돌리고 list메서드 재활용
   * @return
   */
  @RequestMapping(value="/a_member/list2.do", method=RequestMethod.GET)
  public ModelAndView list2(){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/list2");
    mav.addObject("list", memberDAO.list());
    
    return mav;
  }
  
  /**#조회 
   * @param mno
   * @return
   */
  @RequestMapping(value="/member/read.do", method=RequestMethod.GET)
  public ModelAndView read(int mno){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/member/read");
    mav.addObject("memberVO", memberDAO.read(mno)); 
    
    return mav;
  }
  
  /**
   * 수정
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/a_member/update.do", method=RequestMethod.POST) 
  // 회원가입: create.jsp에서 method='POST'이기 때문에 .POST설정
  public ModelAndView update(MemberVO memberVO){ 
    System.out.println("-->update () POST방식");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); 
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.update(memberVO) == 1){
      msgs.add("회원정보가 수정되었습니다."); // \: "으로 문자열 끝나는걸 막기위해 사용
      links.add("<button type='button' onclick=\"location.href='./read.do?mno=" + memberVO.getMno() + "'\">변경된 회원정보 확인</button>");
    }else{
      msgs.add("회원정보 변경에 실패 하셨습니다.");
      msgs.add("다시 한번 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./list.do'\">목록</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

  
  /**
   * 권한모드(visible)변환
   * @param MemberVO 
   * @param blogcategoryVO
   * @return
   */
  /*@RequestMapping(value="/a_member/update_visible.do", method=RequestMethod.POST,
                        produces="text/plain;charset=UTF-8")
  public ModelAndView update_visible(MemberVO memberVO){
    ModelAndView mav = new ModelAndView(); 
    int mno = (Integer)memberVO;           
    System.out.println("/a_member/update_visible.do: POST방식"); 
    System.out.println("--> mno:" + mno);
    System.out.println("--> memberDAO.read(mno)" +  memberDAO.read(mno));
    
    mav.addObject("memberVO", memberDAO.read(mno));
    System.out.println("-------------------------------");
    System.out.println("--> memberDAO.read(member)" +  memberVO.getVisible());
     
    
    JSONObject obj = new JSONObject();
    
    int cnt = memberDAO.chkemail(email);
    obj.put("cnt", cnt);
  
    System.out.println(email);
    System.out.println(cnt);
    return obj.toJSONString();
    
    //System.out.println("--> memberVO" + memberVO.getVisible());
    //mav.addObject("memberVO", memberDAO.read(mno)); 
    
    if (memberVO.getVisible().equals("Y")){
      memberVO.setVisible("N");
    }else{
      memberVO.setVisible("Y");
    }
    
    memberDAO.update_visible(memberVO);
    
    mav.addObject("memberVO", memberVO);   
    mav.setViewName("redirect:/a_member/list.do");
    
    return mav;
   
  }*/
  
  @RequestMapping(value="/a_member/passwd.do", method=RequestMethod.GET)
  public ModelAndView passwd(int mno){ 
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/passwd"); // /webapp/member/passwd.jsp
    
    mav.addObject("mno", mno); // mno값을 해당 mno에 저장후 mav로 리턴  
    mav.addObject("memberVO", memberDAO.read(mno)); 
    // read로 통해서 개인정보를 불러와 memberVO에 저장 후 리턴하는 하기 때문에
    // get방식이여도 노출안됨
    return mav;
  }
  
  
  @RequestMapping(value="/a_member/passwd.do", method=RequestMethod.POST) 
  // 회원가입: create.jsp에서 method='POST'이기 때문에 .POST설정
  public ModelAndView update_passwd(MemberVO memberVO){ 
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); 
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.passwdCheck(memberVO) == 1){     // 현재패스워드 일치
      if(memberDAO.update_passwd(memberVO) == 1){ // 패스워드 변경 실행
        msgs.add("패스워드를 변경했습니다.");
        links.add("<button type='button' onclick=\"location.href='./index.do'\">홈페이지</button>");
      }else{
        msgs.add("패스워드변경에 실패했습니다.");
        msgs.add("다시 한번 시도해주세요.");
        links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");;
      }
  
    }else{
      msgs.add("현재패스워드가 일치하지 않습니다.");
      msgs.add("죄송하지만 다시한번 입력해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./list.do'\">목록</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  
  /**
   * 삭제: GET
   * @param mno
   * @return
   */
  @RequestMapping(value="/a_member/delete.do", method=RequestMethod.GET)
  public ModelAndView delete(int mno){
    System.out.println("-->delete () GET방식");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/delete"); // /webapp/member/delete.jsp
    
    mav.addObject("mno", mno); // mno를 가지고 delete.jsp를 감  
    mav.addObject("memberVO", memberDAO.read(mno)); 
    return mav;       
  }
  
  /**
   * 삭제: POST
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/a_member/delete.do", method=RequestMethod.POST) 
  public ModelAndView delete(MemberVO memberVO){ 
    System.out.println("-->delete () POST방식");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); 
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.delete(memberVO) == 1){
      msgs.add("해당 회원정보가 삭제되었습니다.");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">홈페이지</button>");
    }else{
      msgs.add("회원정보 삭제에 실패 하셨습니다.");
      msgs.add("다시 한번 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시 시도</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./list.do'\">목록</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  
  // 로그인  
  @RequestMapping(value = "/a_member/login.do", method = RequestMethod.GET)
  public ModelAndView login() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/login_ck_form"); // /webapp/member/login_ck_form.jsp
    
    return mav;
  }
  
  
  @RequestMapping(value = "/a_member/login.do", method = RequestMethod.POST)
  public ModelAndView login(MemberVO memberVO, 
                                       HttpSession session, 
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
    ModelAndView mav = new ModelAndView();

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    if (memberDAO.login(memberVO) == 1) {
      session.setAttribute("id", memberVO.getId());
      session.setAttribute("passwd", memberVO.getPasswd());
 
      // ------------------------------------------------------------------
      // id 저장 관련 쿠키 저장
      // ------------------------------------------------------------------
      String id_save = Tool.checkNull(memberVO.getId_save());
      if (id_save.equals("Y")){ // id 저장 할 경우
        Cookie ck_id = new Cookie("ck_id", memberVO.getId()); // id 저장
        ck_id.setMaxAge(60); // 초
        response.addCookie(ck_id);
      }else{ // id를 저장하지 않을 경우
        Cookie ck_id = new Cookie("ck_id", ""); 
        ck_id.setMaxAge(0); // 초
        response.addCookie(ck_id);
      }
      // id 저장 여부를 결정하는 쿠기 기록, Y or "" 저장
      Cookie ck_id_save = new Cookie("ck_id_save", memberVO.getId_save());
      ck_id_save.setMaxAge(60); // 초
      response.addCookie(ck_id_save);
      // ------------------------------------------------------------------
   
      // ------------------------------------------------------------------
      // passwd 저장 관련 쿠키 저장
      // ------------------------------------------------------------------
      String passwd_save = Tool.checkNull(memberVO.getId_save());
      if (passwd_save.equals("Y")){ 
        Cookie ck_passwd = new Cookie("ck_passwd", memberVO.getPasswd()); 
        ck_passwd.setMaxAge(60); // 초
        response.addCookie(ck_passwd);
        
      }else{ // passwd를 저장하지 않을 경우
        Cookie ck_passwd = new Cookie("ck_passwd", "");
        ck_passwd.setMaxAge(0); // 초
        response.addCookie(ck_passwd);
        
      }
      // passwd 저장 여부를 결정하는 쿠기 기록, Y or "" 저장
      Cookie ck_passwd_save = new Cookie("ck_passwd_save", memberVO.getPasswd_save());
      ck_passwd_save.setMaxAge(60); // 초
      response.addCookie(ck_passwd_save);
      // ------------------------------------------------------------------
      String url_address = Tool.checkNull(memberVO.getUrl_address());
      if (url_address.length() > 0){
        mav.setViewName("redirect:" + memberVO.getUrl_address());
      }else{
        System.out.println("--> index.jsp 페이지로 이동합니다.");
        mav.setViewName("redirect:/index.jsp"); // 확장자 명시
      }
      
    } else {
      mav.setViewName("/a_member/message");
      msgs.add("로그인에 실패했습니다.");
      msgs.add("죄송하지만 다시한번 시도해주세요.");
      links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">홈페이지</button>");
    }

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);

    return mav;
  }
  
 
  //로그아웃
  @RequestMapping(value = "/a_member/logout.do", method = RequestMethod.GET)
  public ModelAndView logout(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); // /webapp/member/message.jsp
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    msgs.add("이용해주셔서 감사합니다.");
    msgs.add("from 왕눈이...");
    links.add("<button type='button' onclick=\"location.href='../index.do'\">홈페이지</button>");
    
    session.invalidate(); // session 변수 삭제
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

}

