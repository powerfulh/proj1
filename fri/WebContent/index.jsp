<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>

<body class="">

<c:redirect url="/main.fri" />

 
<%-- 
<!-- 이곳은 인덱스 입니다 수정전 팀원과 상의하세요 무언가 변경-->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:20px">
	<div class="w3-col w3-card w3-margin-bottom w3-round">
		<h1><a href="/increpas4team/">냉장고를 부탁해!</a></h1>
	</div>
  <!-- The Grid -->
  <div class="w3-row" style="min-width:1000px">
    <!-- Left Column -->
    <div class="w3-col m3" style="max-width:1400px;margin-top:20px; min-width:240px">
      <!-- Profile -->
      <c:if test="${not empty SID}">
	      <div class="w3-card w3-round w3-white">
	        <div class="w3-container">
	         <h4 class="w3-center">My Profile</h4>
	         <p class="w3-center"><img src="/cls/img/avatar/m3.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
	         <hr>
	         <p><i class="fa fa-id-badge fa-fw w3-margin-right w3-text-theme"></i>${SID}</p>
	         
	         <p class="w3-btn w3-border w3-hover-blue change05bgc" id="logoutbtn"><i class="fa fa-sign-out fa-fw w3-margin-right w3-text-theme"></i> 로그아웃</p>
	        </div>
	      </div>
      </c:if>
      <br>
      <!-- 로그인 안했을때 -->
      <c:if test="${empty SID}">
	      <div class="w3-card w3-round w3-white">
	        <form class="w3-container w3-padding" method="get" action="/increpas4team/logincheck.fri" id="loginform">
	        <div class="w3-padding">
	        	<div class="inline dimension3">ID</div>
	        	<input name="inputid" class="dimension2">
	        </div>
	        <div class="w3-padding">
	        	<div class="inline dimension3">PW</div>
	        	<input name="inputpw" class="dimension2" type="password">
	        </div>
	         <div class="w3-btn w3-border w3-hover-blue change05bgc dimension2" id="loginbtn">
	         	<i class="fa fa-sign-in fa-fw w3-margin-right w3-text-theme"></i> 로그인
	         </div>
	         <div class="w3-btn w3-border w3-hover-blue change05bgc dimension2" id="joinbtn">
	         	<i class="fa fa-user-plus fa-fw w3-margin-right w3-text-theme"></i> 회원가입
	         </div>
	        </form>
	      </div>
      </c:if>
      <br>
      
      <!-- Accordion -->
      <div class="w3-round">
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">My refri</div>
		<form action="/increpas4team/selectIngredient.fri" method="get">
			<input type="hidden" name="catagory" value="한">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="한식">
		</form>
		<form action="/increpas4team/selectIngredient.fri" method="get">
			<input type="hidden" name="catagory" value="중">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="중식">
		</form>
		<form action="/increpas4team/selectIngredient.fri" method="get">
			<input type="hidden" name="catagory" value="일">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="일식">
		</form>
		<form action="/increpas4team/selectIngredient.fri" method="get">
			<input type="hidden" name="catagory" value="양">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="양식">
		</form>
		<form action="/increpas4team/selectIngredient.fri" method="get">
			<input type="hidden" name="catagory" value="퓨">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="퓨전">
		</form>
		<c:if test="${not empty SID}">
			<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">Our refri</div>
			<form action="/increpas4team/미정" method="get">
				<input type="hidden" name="loginid" value="${SID}">
				<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="내 레시피 작성">
			</form>
		</c:if>
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">HQ refri</div>
		<form action="/increpas4team/미정" method="get">
			<input type="hidden" name="loginid" value="${SID}">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="파트너 회원 신청">
		</form>
		<form action="/increpas4team/미정" method="get">
			<input type="hidden" name="loginid" value="${SID}">
			<input class="w3-gray w3-round-large w3-center dimension3 w3-padding-small inline w3-button w3-hover-cyan change05bgc" type="submit" value="파트너 레시피 보기">
		</form>
		<div class="w3-teal w3-round-large w3-center dimension7 w3-padding w3-margin-top w3-button w3-hover-cyan change05bgc">Feedback / Q &amp; A</div>
      </div>
      <br>
      
      <br>
      
      <br>
      
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7">
      
      <form class="w3-container w3-card w3-round w3-margin-bottom w3-margin-left w3-margin-right clickable latelyuploadbtn" method="get" action="/increpas4team/resipiPage.fri"><br>
        <img src="/cls/img/avatar/m3.png" alt="Avatar" class="w3-left w3-circle w3-margin-right" style="width:60px">
        <span class="w3-right w3-opacity">1 min</span>
        <h4>레시피 이름</h4><br>
        <hr class="w3-clear">
        <p>유저 아이디</p>
          <div class="w3-row-padding" style="margin:0 -16px">
            <div class="w3-col">
              <img src="/cls/img/avatar/m3.png" style="width:100%" alt="thumbsnail" class="w3-margin-bottom">
            </div>
        </div>
      </form>
      
      
      
    <!-- End Middle Column -->
    </div>
    
    <!-- Right Column -->
    <div class="w3-col m2">
      <div class="w3-card w3-round w3-white w3-center">
        <div class="w3-container">
          <p>주간</p>
          <img src="/cls/img/avatar/m3.png" alt="Forest" style="width:100%;">
          <p><strong>제목</strong></p>
          <p>유저아이디</p>
          <p><button class="w3-button w3-block w3-theme-l4">보러가기</button></p>
        </div>
      </div>
      <br>
      
      <div class="w3-card w3-round w3-white w3-center">
        <div class="w3-container">
          <p>월간</p>
          <img src="/cls/img/avatar/m3.png" alt="Forest" style="width:100%;">
          <p><strong>제목</strong></p>
          <p>유저아이디</p>
          <p><button class="w3-button w3-block w3-theme-l4">보러가기</button></p>
        </div>
      </div>
      <br>
      
      <div class="w3-card w3-round w3-white dimension1">
        <div class="w3-container">
        	<div class="w3-red h240 w3-margin-bottom">
	        	<p>채팅내용 w3-red 는 기능 구현후 지울거임
        	</div>
        	<input class="dimension1">
        </div>
      </div>
      <br>
      
      
      
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

--%>
</body>
</html>
