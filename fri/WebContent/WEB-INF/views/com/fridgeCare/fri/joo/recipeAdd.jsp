<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project</title>
<link rel="stylesheet" href="/fri/css/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="/fri/css/cls.css">
<link rel="stylesheet" type="text/css" href="/fri/css/my.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/fri/js/recipeAdd.js"></script>

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
input.dimension2{
	width:140px;
}
div.dimension3{
	width:25px;
}
div.dimension7{
	height:40px;
	margin-bottom:5px;
}
div.dimension8{
	width:90%;
	height:35px;
	margin-bottom:5px;
}


.clickable:hover{
	background-color:beige;
	cursor:pointer;
}
.inline{
	display:inline-block;
}
</style>
</head>
<body class="">


<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:20px">    
	<div class="w3-col w3-card w3-margin-bottom w3-round">
		<h1><a href="/fridgeCare/">냉장고를 부탁해!</a></h1>
	</div>
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile --> <!-- 로그인 한 경우 hide 클라스를 지워준다 -->
		<div class="w3-card w3-round w3-white w3-hide">
			<div class="w3-container">
				<h4 class="w3-center">My Profile</h4>
				<p class="w3-center"><img src="/cls/img/avatar/m3.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
				<hr>
				<p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> ID</p>
				<p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> Loc</p>
				<p class="w3-btn w3-border w3-hover-blue change05bgc"><i class="fa fa-edit fa-fw w3-margin-right w3-text-theme"></i> edit</p>
			</div>
		</div>
      <br>
      <!-- 로그인 안했을때 -->
		<div class="w3-card w3-round w3-white">
			<form class="w3-container w3-padding">
			 <div class="w3-padding">
			 	<div class="inline dimension3">ID</div>
			 	<input name="inputid" class="dimension2">
			 </div>
			 <div class="w3-padding">
			 	<div class="inline dimension3">PW</div>
			 	<input name="inputid" class="dimension2">
			 </div>
			  <div class="w3-btn w3-border w3-hover-blue change05bgc dimension2" id="loginbtn">
			  	<i class="fa fa-sign-in fa-fw w3-margin-right w3-text-theme"></i> 로그인
			  </div>
			  <div class="w3-btn w3-border w3-hover-blue change05bgc dimension2">
			  	<i class="fa fa-user-plus fa-fw w3-margin-right w3-text-theme"></i> 회원가입
			  </div>
			</form>
		</div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-round">
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">My refri</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">c1</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">c2</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">c3</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">c4</div>
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">Our refri</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">submit</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">view</div>
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">HQ refri</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">regist</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">view</div>
		<div class="w3-teal w3-round-large w3-center dimension7 w3-padding w3-margin-top w3-button w3-hover-cyan change05bgc">Feedback / Q &amp; A</div>
      </div>
      <br>
      <br>
      
    <!-- End Left Column -->
    </div>
    
<!-- Middle Column --> <!-- 작업할 곳 -->

    <div class="w3-col m9">
      <div class="w3-container w3-card w3-round w3-margin-bottom w3-margin-left w3-margin-right">
      <!-- 이곳에 꿈과 희망을 펼치세요 -->
     	 <div class="w3-content w3-center w3-indigo w3-card-4">
    	     <h1 class="w3-padding w3-margin-top w3-center">냉장고를 부탁해</h1>
    	  </div>
      <form method="POST" action="/fri/recipeAddProc.fri" id="frm" name="frm">
	      <div class="m6 w3-col w3-padding w3-margin-bottom">
	            <label class="w3-col w3-left-align w3-padding txt16 clsbold">요 리 이 름 : </label>
	                  <input type="text" class="w3-input w3-border w3-padding" id=name" name="name" placeholder="내용을 입력하세요!">
	            <label class="w3-col w3-left-align w3-padding txt16 clsbold">요 리 종 류 : </label>
	               <select name="cate" id="cate" >
	                  <option value="#">선택
	                  <option value="한">한식
	                  <option value="중">중식
	                  <option value="일">일식
	                  <option value="양">양식
	                  <option value="퓨">퓨전
	               </select> <br>
	            <label class="w3-col w3-left-align w3-padding txt16 clsbold">소 요 시 간 : </label>
	               <select name="time" id="time" >
	                  <option value="10">5~15분
	                  <option value="20">15~25분
	                  <option value="35">25~45분
	                  <option value="50">45~60분
	                  <option value="80">한시간 이상
	               </select> <br>
	            <label class="w3-col w3-left-align w3-padding txt16 clsbold">조 리 상 황 : </label>
	             	<select name="situat" id="situat" >
		                <option value="자취">자취요리
		                <option value="연인">연인코스
		                <option value="안주">술안주
		                <option value="반찬">집반찬
		                <option value="든든">든든하게
		             </select>
	         </div>
	         <div class="m6 w3-col w3-padding w3-margin-bottom">
	         	<div class="m3 w3-margin w3-padding">
		     		<img src="#" class="w3-border" style="height: 218px; width: 350px;" >
		     	</div>
	         </div>
		     <div class="w3-col w3-padding w3-margin-top">
		     	<div class="w3-col w3-margin-top"> 
		     		<div class="w3-col">
			    		<label for="name" class="w3-col l4 m12 s12 w3-left-align w3-padding txt16 clsbold">필 수 재 료 : </label>
		     		</div>
		     		<div class="w3-col">
			        	<div class="w3-col m5 w3-padding">
			            	<input type="text" class="w3-col w3-border w3-margin w3-padding" id="ingre" name="ingre" placeholder="예) 소고기, 돼지고기...">
			            	<input type="button" class="w3-center m2" id="inbtn" value=" + 항목추가">
			            </div>
		    	     	<div class="w3-col m7 w3-padding">
			    	 		<div class="">
			    	 			<input class="w3-col w3-margin-top w3-border" name="video" placeholder="video">
			    	 		</div>
			    	 	</div>
		     		</div>
	         	</div>
	       	</div>
	       	<div class="w3-col w3-padding w3-margin-top">
		     	<div class="w3-col w3-margin-top"> 
		     		<div class="w3-col">
			    		<label id="make" class="w3-col l4 m12 s12 w3-left-align w3-padding txt16 clsbold">조 리 과 정: </label>
		     		</div>
		     		<div class="w3-col m4">
		     			<img src="#" class="w3-border w3-margin-bottom" style="height: 200px; width: 200px;" >
		     		</div>
		     		<div class="w3-col m8">
						<textarea id="cook" class="w3-col w3-border w3-input w3-margin-bottom" rows="8" placeholder="조리과정 설명" style="overflow: auto; resize: none;"></textarea>
		     		</div>
		     	</div>
		     </div>
	     </form>
	     
	     <div class="w3-col w3-center">
	       	<input type="button" class="w3-center m4 w3-blue txt16 clsbold" style="height: 50px; width: 300px;" id="sabtn" value="저장">
	     </div>
    </div>
    <!-- End Middle Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
<!-- </div> -->
</div>

<!-- Footer -->
<footer class="w3-container w3-center w3-theme-d3">
  <h5>Footer</h5>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
</body>
</html>