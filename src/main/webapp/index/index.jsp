<%@ page contentType="text/html; charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8"); %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title></title>  
   
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/style.css" rel="Stylesheet" type="text/css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script> 
</head> 
<!-- -------------------------------------------- -->
<body leftmargin="0" topmargin="0" data-spy="scroll" data-target=".navbar" data-offset="50">
<jsp:include page="../menu/top.jsp" flush='false' />
<!-- -------------------------------------------- -->
<nav class="navbar navbar-inverse navbar-fixed-top" style='width: 82.2%; margin: 0 auto; background-color: #FFFFFF; border:none;'>
  <div class="container-fluid">  <!-- #66ccff 연파랑 -->
    <div>  
      <div class="Navbar_up">
          <div class='Naver_up_op0'>
            <a href="#section0"><IMG src='../menu/images/rainbow_market.png' style='height:40px;'>
              RainbowMarket</a>
          </div>
          <div class='Naver_up_op1'>
            <a href="#">로그인 | </a> 
            <a href="#">회원가입</a>      
          </div>
          <div class='Naver_up_op2'>
            <a href="#">커뮤니티 | </a>    
            <a href="#">마이페이지</a>  
          </div>  
      </div>
      <div class="collapse navbar-collapse" id="Navbar_down">
        <ul class="nav navbar-nav">
          <li><a class='menuLink' href="#section1">카테고리</a></li> 
          <li><a class='menuLink' href="#section2">Section 2</a></li>
          <li><a class='menuLink' href="#section3">Section 3</a></li>
          <li><a class='menuLink' href="#section4">Section 4</a></li>
        </ul>  
      </div>
    </div>
  </div>
</nav>    
  
<div id="section0" class="container-fluid">
  <h1>Section 0</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section1" class="container-fluid">
  <h1>Section 1</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section2" class="container-fluid">
  <h1>Section 2</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section3" class="container-fluid">
  <h1>Section 3</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section4" class="container-fluid">
  <h1>Section 4</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>
<div id="section42" class="container-fluid">
  <h1>Section 4 Submenu 2</h1>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
  <p>Try to scroll this section and look at the navigation bar while scrolling! Try to scroll this section and look at the navigation bar while scrolling!</p>
</div>

<!-- -------------------------------------------- -->
<jsp:include page="../menu/bottom.jsp" flush='false' />
</body>
<!-- -------------------------------------------- -->
</html> 

 