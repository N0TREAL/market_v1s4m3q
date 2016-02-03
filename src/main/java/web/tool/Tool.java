package web.tool;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Tool {
  /**
   * ���ڿ��� ���̰� length ���� ũ�� "..." �� ǥ���ϴ� �޼ҵ�
   * @param length ������ ���ڿ� ����
   * @param str ���ڿ�
   * @return
   */
  public static synchronized String textLength(int length, String str) {

    if (str != null){
      if (str.length() > length) {
        str = str.substring(0, length) + "...";
      }
    }else{
      str ="";
    }
    
    return str;
  }
  
  /**
   * ������ �Է¹޾� ���� ��θ� �����մϴ�. 
   * ��) getRealPath(request, "/media/storage")
   * 
   * @param request
   * @param dir ���� ��θ� ���� ������
   * @return ���� ��� ����
   * @throws IOException
   */
  public static synchronized String getRealPath(HttpServletRequest request, String dir) {
    String path = "";
    
    try{
      path = request.getRealPath(dir) + "/";  
      // System.out.println("Upload path: " + path);
    }catch(Exception e){
      System.out.println(e.toString());
    }

    return path;
  }

  /**
   * ���� ����
   * @param fname
   * @return
   */
  public static synchronized boolean deleteFile(String fname) {
    File file = new File(fname);
    boolean ret = false;
    
      if (file.exists()){
        ret = file.delete();
      }
    
    return ret;
  }

  /**
   * �̹��� ����� �����Ͽ� ���ο� �̹����� �����մϴ�.
   <pre>
   ��뿹)
      File src = new File("F:/hybrid2/Gallery/imgResize/festval02.jpg");
      File dest = new File("F:/hybrid2/Gallery/imgResize/festval02_mini.jpg");
    
      Tool.imgResize(src, dest, 120, 80);
   </pre>
   * @param src ���� �̹���
   * @param dest �����Ǵ� �̹���
   * @param width ������ �̹��� �ʺ�
   * @param height ������ �̹��� ����, ImageUtil.RATIO�� �ڵ� ��� ����
   * @throws IOException
   */
  public static synchronized String imgResize(File src, File dest, int width, int height) {
    int RATIO = 0;
    int SAME = -1;
    
    Image srcImg = null;
    // ������ Ȯ���� ����
    String name = src.getName().toLowerCase(); // ���ϸ� ����
    // �̹��� �������� �˻�
    if (name.endsWith("jpg") || name.endsWith("bmp") || name.endsWith("png") || name.endsWith("gif")) {
      try {
        srcImg = ImageIO.read(src); // �޸𸮿� ���� �̹��� ����
        int srcWidth = srcImg.getWidth(null);   // ���� �̹��� �ʺ� ����
        int srcHeight = srcImg.getHeight(null); // ���� �̹��� ���� ����
        int destWidth = -1, destHeight = -1;    // ��� �̹��� ũ�� �ʱ�ȭ
        
        if (width == SAME) {    // width�� ���� ���
          destWidth = srcWidth;
        } else if (width > 0) {
          destWidth = width;    // ���ο� width�� �Ҵ�
        }
        
        if (height == SAME) {    // ���̰� ���� ���
          destHeight = srcHeight;
        } else if (height > 0) {
          destHeight = height;  // ���ο� ���̷� �Ҵ�
        }
        
        // ������ ���� ũ�� ���
        if (width == RATIO && height == RATIO) {
          destWidth = srcWidth;
          destHeight = srcHeight;
        } else if (width == RATIO) {
          double ratio = ((double) destHeight) / ((double) srcHeight);
          destWidth = (int) ((double) srcWidth * ratio);
        } else if (height == RATIO) {
          double ratio = ((double) destWidth) / ((double) srcWidth);
          destHeight = (int) ((double) srcHeight * ratio);
        }

        // �޸𸮿� ��� �̹��� ����
        Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH);
        int pixels[] = new int[destWidth * destHeight];
        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth,
            destHeight, pixels, 0, destWidth);

        pg.grabPixels();

        BufferedImage destImg = new BufferedImage(destWidth, destHeight,
            BufferedImage.TYPE_INT_RGB);
        destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);
     
        // ���Ͽ� ���
        ImageIO.write(destImg, "jpg", dest);
        
        System.out.println(dest.getName() +  " �̹����� �����߽��ϴ�.");
      } catch (Exception e) {
        e.printStackTrace();
      }
      
      name = dest.getName(); // ���� ������ ���ϸ�
    } 
    
    return name;
  }
  
  /**
   * �̹��� ����� �����Ͽ� ���ο� Preview �̹����� �����մϴ�.
   * @param upDir ���� �̹��� ����
   * @param src ���� ���ϸ�
   * @param width ������ �̹��� �ʺ�
   * @param height ������ �̹��� ����, ImageUtil.RATIO�� �ڵ� ��� ����
   * @throws IOException
   */
  public static synchronized String preview(String upDir, String src, int width, int height) {
    int RATIO = 0;
    int SAME = -1;
    
    File _src = new File(upDir + "/" + src); // ���� ���� ��ü ����
    String srcname = _src.getName();         // ���� ���ϸ� ����
    
    // ���� ���ϸ� ����, mt.jpg -> mt �� ����
    String _dest = srcname.substring(0, srcname.indexOf("."));
    
    // ��� �̹��� ���� /upDir/mt_t.jpg
    File dest = new File(upDir + "/" + _dest + "_mini.jpg"); 
    
    Image srcImg = null;
    // ������ Ȯ���� ����
    String name = _src.getName().toLowerCase(); // ���ϸ� ����
    // �̹��� �������� �˻�
    if (name.endsWith("jpg") || name.endsWith("bmp") || name.endsWith("png") || name.endsWith("gif")) {
      try {
        srcImg = ImageIO.read(_src); // �޸𸮿� ���� �̹��� ����
        int srcWidth = srcImg.getWidth(null);   // ���� �̹��� �ʺ� ����
        int srcHeight = srcImg.getHeight(null); // ���� �̹��� ���� ����
        int destWidth = -1, destHeight = -1;    // ��� �̹��� ũ�� �ʱ�ȭ
        
        if (width == SAME) {    // width�� ���� ���
          destWidth = srcWidth;
        } else if (width > 0) {
          destWidth = width;    // ���ο� width�� �Ҵ�
        }
        
        if (height == SAME) {    // ���̰� ���� ���
          destHeight = srcHeight;
        } else if (height > 0) {
          destHeight = height;  // ���ο� ���̷� �Ҵ�
        }
        
        // ������ ���� ũ�� ���
        if (width == RATIO && height == RATIO) {
          destWidth = srcWidth;
          destHeight = srcHeight;
        } else if (width == RATIO) {
          double ratio = ((double) destHeight) / ((double) srcHeight);
          destWidth = (int) ((double) srcWidth * ratio);
        } else if (height == RATIO) {
          double ratio = ((double) destWidth) / ((double) srcWidth);
          destHeight = (int) ((double) srcHeight * ratio);
        }

        // �޸𸮿� ��� �̹��� ����
        Image imgTarget = srcImg.getScaledInstance(destWidth, destHeight, Image.SCALE_SMOOTH);
        int pixels[] = new int[destWidth * destHeight];
        PixelGrabber pg = new PixelGrabber(imgTarget, 0, 0, destWidth,
            destHeight, pixels, 0, destWidth);

        pg.grabPixels();

        BufferedImage destImg = new BufferedImage(destWidth, destHeight,
            BufferedImage.TYPE_INT_RGB);
        destImg.setRGB(0, 0, destWidth, destHeight, pixels, 0, destWidth);
     
        // ���Ͽ� ���
        ImageIO.write(destImg, "jpg", dest);
        
        System.out.println(dest.getName() +  " �̹����� �����߽��ϴ�.");
      } catch (Exception e) {
        e.printStackTrace();
      }
    } 
    
    return dest.getName();
  }

  /**
   * ���ڿ��� null���� üũ�Ͽ� null���� ""���� ��ȯ�մϴ�.
   * @param obj
   * @return
   */
  public static synchronized String checkNull(Object obj){
    if (obj == null){
      return "";
    }else{
      String str = (String)obj;  // null�̶� ���ڿ��� ������ �ִ� ���
      if (str.equals("null")){
        return "";
      }
      return (String)obj;
    }
  }
  
  /**
   * ������ �������� �˻��մϴ�.
   * @param request
   * @return true: ������ ����
   */
  public static synchronized boolean isMaster(HttpServletRequest request){
    boolean sw = false;
    
    HttpSession session = request.getSession();
    String act = (String)session.getAttribute("act");
    // System.out.println("--> Tool.java act: " + act);
    
    if (act != null){
      if (act.equals("M")){
        sw = true;
      }
    }
    return sw;
  }

  /**
   * �Ϲ� ������ �������� �˻��մϴ�.
   * @param request
   * @return true: �Ϲ� ������
   */
  public static synchronized boolean isAdmin(HttpServletRequest request){
    boolean sw = false;
    
    HttpSession session = request.getSession();
    String act = (String)session.getAttribute("act");
    
    if (act != null){
      if (act.equals("Y")){
        sw = true;
      }
    }
    return sw;
  }

  /**
   * Ű�� �����մϴ�. ��) ABC + ����ð�: ABC1234567890123
   * @return
   */
  public static synchronized String key(){
    String code = "";
    
    //  ASCII: 65 ~ 90, (A ~ Z: 26��)
    Random rnd = new Random();
    int su = rnd.nextInt(26) + 65; // 0 ~ 25 --> 65 ~ 90
    // System.out.println((char)su);
    code = code + (char)su;
    
    su = rnd.nextInt(26) + 65; // 0 ~ 25 --> 65 ~ 90
    // System.out.println((char)su);
    code = code + (char)su;
    
    su = rnd.nextInt(26) + 65; // 0 ~ 25 --> 65 ~ 90
    // System.out.println((char)su);
    code = code + (char)su;

    code = code + new Date().getTime();
    // System.out.println("CODE: " + code); // CODE: XGL1449819012230 
    
    return code;
  }
  /**
   * ���� ������ <br>�±׷� ��ȯ�մϴ�.
   * @param str
   * @return
   */
  public static synchronized String convertChar(String str){
    str = str.replaceAll("\r\n", "<BR>");
    
    return str;
  }
  
  /**
   * ������ Ȯ���ڸ� �����մϴ�.
   * @param name ���ϸ�
   * @return ���� Ȯ���� ��) jpg
   */
  public static synchronized String fileExtend(String file){
    if (file != null){
      file = file.toLowerCase();  // �ҹ��ڷ� ����
     
      int point = file.lastIndexOf("."); // ���������� ��Ÿ�� '.'�� ��ġ
      file = file.substring(point+1);  // .jpg --> jpg
    }else{
      file = ""; // null ���� ������ �ʱⰪ 
    }
    return file;
  }
  
  public static synchronized String unit(long length){
    String str = "";

    if (length < 1024){  // Byte: 0 ~ 1023
      str = length + " Byte";   
    }else if (length < (1024 * 1024)){ // Byte: 1024 ~ 1048575
      str = length / 1024 + " KB";
    }else if(length < (1024 * 1024 * 1024)){ // Byte: 1048576 ~ 1073741823
      str = length / 1024 / 1024 + " MB";
    }else if(length < (1024L * 1024 * 1024 * 1024)){ // Byte: 1073741824 ~
      str = length / 1024 / 1024 / 1024+ " GB";
    }
    
    return str;
  }
}

