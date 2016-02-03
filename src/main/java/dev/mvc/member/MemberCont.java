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
  private MemberDAOInter memberDAO; //** MemberDAOInter �������̽� ����: �ڵ����� ����Ŭ������ �Ҵ�
  
  public MemberCont(){
    System.out.println("--> MemberCont created.");
  }

  @RequestMapping(value="/a_member/create.do", method=RequestMethod.GET)
  public ModelAndView create(){
    System.out.println("-->create () GET���");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/create"); // /webapp/member/create.jsp
    
    return mav;
  }
  
  @RequestMapping(value="/a_member/create.do", method=RequestMethod.POST) 
  // ȸ������: create.jsp���� method='POST'�̱� ������ .POST����
  public ModelAndView create(MemberVO memberVO){ 
    System.out.println("-->create () POST���");
    ModelAndView mav = new ModelAndView();
    //System.out.println("visible-->:" + memberVO.getVisible());
    //System.out.println("ids-->:" + memberVO.getIds());
   
    mav.setViewName("/a_member/message");
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.create(memberVO) == 1){
      msgs.add("ȸ�������� ó���Ǿ����ϴ�.");
      msgs.add("BaiBolg�� ���Ű� ȯ���մϴ�.");  // \: "���� ���ڿ� �����°� �������� ���
      links.add("<button type='button' onclick=\"location.href='./login.do'\">�α���</button>");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">Ȩ������</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");
    }else{
      msgs.add("ȸ�����Կ� ���� �ϼ̽��ϴ�.");
      msgs.add("�ٽ� �ѹ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">Ȩ������</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");
    }
    
    mav.addObject("msgs", msgs); 
    mav.addObject("links", links);
    
    return mav;
  }
  
  /**
   * �ߺ� ���̵��� �˻��մϴ�.
   * @param id
   * @param locale
   * @param model
   * @return
   */
  @ResponseBody  
  @RequestMapping(value = "/a_member/chkid.do", method = RequestMethod.POST,
                            produces="text/plain;charset=UTF-8") // �������
  public String chkid(String id, Locale locale, Model model) {
  
    JSONObject obj = new JSONObject();
    
    int cnt = memberDAO.chkid(id);
    obj.put("cnt", cnt);
  
    System.out.println(id);
    System.out.println(cnt);
    return obj.toJSONString();
  }  
  
  /**
   * �ߺ� �̸��ϸ� �˻��մϴ�.
   * @param email
   * @param locale
   * @param model
   * @return
   */
  @ResponseBody  // Spring�� jsp�� ����ؾ��ϴµ�, jsp view�� �̿��Ͽ� ��������ʰ� �ܼ� ���ڿ��� ����Ҷ� ���
  @RequestMapping(value = "/a_member/chkemail.do", method = RequestMethod.POST,
                            produces="text/plain;charset=UTF-8") // �������
  public String chkemail(String email, Locale locale, Model model) {
  
    JSONObject obj = new JSONObject();
        
    int cnt = memberDAO.chkemail(email);
    obj.put("cnt", cnt);
  
    System.out.println(email);
    System.out.println(cnt);
    return obj.toJSONString();
  }

  /**
   * ��ü ���: 
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
   * �μ�� ���: �������� list2�� ������ list�޼��� ��Ȱ��
   * @return
   */
  @RequestMapping(value="/a_member/list2.do", method=RequestMethod.GET)
  public ModelAndView list2(){  
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/list2");
    mav.addObject("list", memberDAO.list());
    
    return mav;
  }
  
  /**#��ȸ 
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
   * ����
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/a_member/update.do", method=RequestMethod.POST) 
  // ȸ������: create.jsp���� method='POST'�̱� ������ .POST����
  public ModelAndView update(MemberVO memberVO){ 
    System.out.println("-->update () POST���");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); 
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.update(memberVO) == 1){
      msgs.add("ȸ�������� �����Ǿ����ϴ�."); // \: "���� ���ڿ� �����°� �������� ���
      links.add("<button type='button' onclick=\"location.href='./read.do?mno=" + memberVO.getMno() + "'\">����� ȸ������ Ȯ��</button>");
    }else{
      msgs.add("ȸ������ ���濡 ���� �ϼ̽��ϴ�.");
      msgs.add("�ٽ� �ѹ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

  
  /**
   * ���Ѹ��(visible)��ȯ
   * @param MemberVO 
   * @param blogcategoryVO
   * @return
   */
  /*@RequestMapping(value="/a_member/update_visible.do", method=RequestMethod.POST,
                        produces="text/plain;charset=UTF-8")
  public ModelAndView update_visible(MemberVO memberVO){
    ModelAndView mav = new ModelAndView(); 
    int mno = (Integer)memberVO;           
    System.out.println("/a_member/update_visible.do: POST���"); 
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
    
    mav.addObject("mno", mno); // mno���� �ش� mno�� ������ mav�� ����  
    mav.addObject("memberVO", memberDAO.read(mno)); 
    // read�� ���ؼ� ���������� �ҷ��� memberVO�� ���� �� �����ϴ� �ϱ� ������
    // get����̿��� ����ȵ�
    return mav;
  }
  
  
  @RequestMapping(value="/a_member/passwd.do", method=RequestMethod.POST) 
  // ȸ������: create.jsp���� method='POST'�̱� ������ .POST����
  public ModelAndView update_passwd(MemberVO memberVO){ 
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); 
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.passwdCheck(memberVO) == 1){     // �����н����� ��ġ
      if(memberDAO.update_passwd(memberVO) == 1){ // �н����� ���� ����
        msgs.add("�н����带 �����߽��ϴ�.");
        links.add("<button type='button' onclick=\"location.href='./index.do'\">Ȩ������</button>");
      }else{
        msgs.add("�н����庯�濡 �����߽��ϴ�.");
        msgs.add("�ٽ� �ѹ� �õ����ּ���.");
        links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");;
      }
  
    }else{
      msgs.add("�����н����尡 ��ġ���� �ʽ��ϴ�.");
      msgs.add("�˼������� �ٽ��ѹ� �Է����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  
  /**
   * ����: GET
   * @param mno
   * @return
   */
  @RequestMapping(value="/a_member/delete.do", method=RequestMethod.GET)
  public ModelAndView delete(int mno){
    System.out.println("-->delete () GET���");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/delete"); // /webapp/member/delete.jsp
    
    mav.addObject("mno", mno); // mno�� ������ delete.jsp�� ��  
    mav.addObject("memberVO", memberDAO.read(mno)); 
    return mav;       
  }
  
  /**
   * ����: POST
   * @param memberVO
   * @return
   */
  @RequestMapping(value="/a_member/delete.do", method=RequestMethod.POST) 
  public ModelAndView delete(MemberVO memberVO){ 
    System.out.println("-->delete () POST���");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); 
   
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    if(memberDAO.delete(memberVO) == 1){
      msgs.add("�ش� ȸ�������� �����Ǿ����ϴ�.");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">Ȩ������</button>");
    }else{
      msgs.add("ȸ������ ������ ���� �ϼ̽��ϴ�.");
      msgs.add("�ٽ� �ѹ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽ� �õ�</button>");
    }
    
    links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }
  
  
  // �α���  
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
      // id ���� ���� ��Ű ����
      // ------------------------------------------------------------------
      String id_save = Tool.checkNull(memberVO.getId_save());
      if (id_save.equals("Y")){ // id ���� �� ���
        Cookie ck_id = new Cookie("ck_id", memberVO.getId()); // id ����
        ck_id.setMaxAge(60); // ��
        response.addCookie(ck_id);
      }else{ // id�� �������� ���� ���
        Cookie ck_id = new Cookie("ck_id", ""); 
        ck_id.setMaxAge(0); // ��
        response.addCookie(ck_id);
      }
      // id ���� ���θ� �����ϴ� ��� ���, Y or "" ����
      Cookie ck_id_save = new Cookie("ck_id_save", memberVO.getId_save());
      ck_id_save.setMaxAge(60); // ��
      response.addCookie(ck_id_save);
      // ------------------------------------------------------------------
   
      // ------------------------------------------------------------------
      // passwd ���� ���� ��Ű ����
      // ------------------------------------------------------------------
      String passwd_save = Tool.checkNull(memberVO.getId_save());
      if (passwd_save.equals("Y")){ 
        Cookie ck_passwd = new Cookie("ck_passwd", memberVO.getPasswd()); 
        ck_passwd.setMaxAge(60); // ��
        response.addCookie(ck_passwd);
        
      }else{ // passwd�� �������� ���� ���
        Cookie ck_passwd = new Cookie("ck_passwd", "");
        ck_passwd.setMaxAge(0); // ��
        response.addCookie(ck_passwd);
        
      }
      // passwd ���� ���θ� �����ϴ� ��� ���, Y or "" ����
      Cookie ck_passwd_save = new Cookie("ck_passwd_save", memberVO.getPasswd_save());
      ck_passwd_save.setMaxAge(60); // ��
      response.addCookie(ck_passwd_save);
      // ------------------------------------------------------------------
      String url_address = Tool.checkNull(memberVO.getUrl_address());
      if (url_address.length() > 0){
        mav.setViewName("redirect:" + memberVO.getUrl_address());
      }else{
        System.out.println("--> index.jsp �������� �̵��մϴ�.");
        mav.setViewName("redirect:/index.jsp"); // Ȯ���� ���
      }
      
    } else {
      mav.setViewName("/a_member/message");
      msgs.add("�α��ο� �����߽��ϴ�.");
      msgs.add("�˼������� �ٽ��ѹ� �õ����ּ���.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='./index.do'\">Ȩ������</button>");
    }

    mav.addObject("msgs", msgs);
    mav.addObject("links", links);

    return mav;
  }
  
 
  //�α׾ƿ�
  @RequestMapping(value = "/a_member/logout.do", method = RequestMethod.GET)
  public ModelAndView logout(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/a_member/message"); // /webapp/member/message.jsp
    
    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();
    
    msgs.add("�̿����ּż� �����մϴ�.");
    msgs.add("from �մ���...");
    links.add("<button type='button' onclick=\"location.href='../index.do'\">Ȩ������</button>");
    
    session.invalidate(); // session ���� ����
    
    mav.addObject("msgs", msgs);
    mav.addObject("links", links);
    
    return mav;
  }

}

