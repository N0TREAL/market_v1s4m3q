package dev.mvc.storage;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class StorageCont {
  @Autowired
  @Qualifier("dev.mvc.storage.StorageDAO")
  private StorageDAO storageDAO;
  
  public StorageCont(){
    System.out.println("--> StorageCont created.");
  }
  
  @RequestMapping(value = "/storage/create.do", method = RequestMethod.POST)
  public ModelAndView create(StorageVO storageVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/storage/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    if (storageDAO.create(storageVO) == 1) {
      mav.setViewName("redirect:/storage/list.do"); // Ȯ���� ���!!!
      // msgs.add("�ڵ带 ����߽��ϴ�.");
      // links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    } else {
      msgs.add("�ڵ� ��Ͽ� �����߽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");

      mav.addObject("msgs", msgs);
      mav.addObject("links", links);
    }

    return mav;
  }
  
  /**
   * ��ü ����� ����մϴ�.
   * @return
   */
  @RequestMapping(value = "/storage/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/storage/list");
    mav.addObject("list", storageDAO.list());

    return mav;
  }
  
  @RequestMapping(value = "/storage/update.do", method = RequestMethod.POST)
  public ModelAndView update(StorageVO storageVO) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/storage/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    if (storageDAO.update(storageVO) == 1) {
      mav.setViewName("redirect:/storage/list.do"); // Ȯ���� ���!!!
      // msgs.add("�ڵ带 ����߽��ϴ�.");
      // links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    } else {
      msgs.add("�ڵ� ���濡 �����߽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");

      mav.addObject("msgs", msgs);
      mav.addObject("links", links);
    }

    return mav;
  }

  @RequestMapping(value = "/storage/delete.do", method = RequestMethod.POST)
  public ModelAndView delete(int storageno) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/storage/message");

    ArrayList<String> msgs = new ArrayList<String>();
    ArrayList<String> links = new ArrayList<String>();

    if (storageDAO.delete(storageno) == 1) {
      mav.setViewName("redirect:/storage/list.do"); // Ȯ���� ���!!!
      // msgs.add("�ڵ带 ����߽��ϴ�.");
      // links.add("<button type='button' onclick=\"location.href='./create.do'\">��� ���</button>");
    } else {
      msgs.add("�ڵ� ������ �����߽��ϴ�.");
      links.add("<button type='button' onclick=\"history.back()\">�ٽýõ�</button>");
      links.add("<button type='button' onclick=\"location.href='./list.do'\">���</button>");

      mav.addObject("msgs", msgs);
      mav.addObject("links", links);
    }

    return mav;
  }
  
  
}