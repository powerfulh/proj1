<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 설명 페이지</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="/cls/css/my.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/fri/js/resipiPage.js"></script>
<!--
<script type="text/javascript" src="/cls/js/"></script>
-->
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
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
</style>
</head>
<body class="">



<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:20px">    
	<div class="w3-col w3-card w3-margin-bottom w3-round">
		<h1><a href="/fri/main.fri">냉장고를 부탁해!</a></h1>
	</div>
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">내 정보</h4>
         <p class="w3-center"><img src="/cls/img/avatar/m3.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> ID</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> Loc</p>
         <p class="w3-btn w3-border w3-hover-blue change05bgc"><i class="fa fa-edit fa-fw w3-margin-right w3-text-theme"></i> edit</p>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-round">
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">나의 냉장고!</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">양식을 원해!</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">한식을 원해!</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">중식을 원해!</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">일식을 원해!</div>
		<div class="w3-gray w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">퓨젼을 원해!</div>
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">우리들의 냉장고!!</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">내 요리 등록하기</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">회원들의 요리 보기</div>
		<div class="w3-blue w3-round-large w3-center dimension7 w3-padding w3-margin-top">고급 냉장고(파트너 유저)</div>
		<div class="w3-light-blue w3-round-large w3-center dimension8 w3-padding-small inline w3-button w3-hover-cyan change05bgc">파트너 유저 신청</div>
		<div class="w3-teal w3-round-large w3-center dimension7 w3-padding w3-margin-top w3-button w3-hover-cyan change05bgc">고객센터 / Q &amp; A</div>
      </div>
      <br>
      
      <div class="w3-card w3-round w3-hide">
        <div class="w3-white">
          <button onclick="myFunction('Demo1')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> My Groups</button>
          <div id="Demo1" class="w3-hide w3-container">
            <p>Some text..</p>
          </div>
          <div id="Demo1" class="w3-hide w3-container">
            <p>Some text..</p>
          </div>
          <button onclick="myFunction('Demo2')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> My Events</button>
          <div id="Demo2" class="w3-hide w3-container">
            <p>Some other text..</p>
          </div>
          <button onclick="myFunction('Demo3')" class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-users fa-fw w3-margin-right"></i> My Photos</button>
          <div id="Demo3" class="w3-hide w3-container">
         <div class="w3-row-padding">
         <br>
           <div class="w3-half">
             <img src="/fri/img/avatar/m3.png" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/fri/img/avatar/m3.png" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/fri/img/avatar/m3.png" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/fri/img/avatar/m3.png" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/fri/img/avatar/m3.png" style="width:100%" class="w3-margin-bottom">
           </div>
           <div class="w3-half">
             <img src="/fri/img/avatar/m3.png" style="width:100%" class="w3-margin-bottom">
           </div>
         </div>
          </div>
        </div>      
      </div>
      <br>
      
      <!-- Interests --> 
      <div class="w3-card w3-round w3-white w3-hide-small w3-hide">
        <div class="w3-container">
          <p>Interests</p>
          <p>
            <span class="w3-tag w3-small w3-theme-d5">News</span>
            <span class="w3-tag w3-small w3-theme-d4">W3Schools</span>
            <span class="w3-tag w3-small w3-theme-d3">Labels</span>
            <span class="w3-tag w3-small w3-theme-d2">Games</span>
            <span class="w3-tag w3-small w3-theme-d1">Friends</span>
            <span class="w3-tag w3-small w3-theme">Games</span>
            <span class="w3-tag w3-small w3-theme-l1">Friends</span>
            <span class="w3-tag w3-small w3-theme-l2">Food</span>
            <span class="w3-tag w3-small w3-theme-l3">Design</span>
            <span class="w3-tag w3-small w3-theme-l4">Art</span>
            <span class="w3-tag w3-small w3-theme-l5">Photos</span>
          </p>
        </div>
      </div>
      <br>
      
    
    <!-- End Left Column -->
    </div>
    
    <!-- Middle Column -->
    <div class="w3-col m7 w3-margin-left">
		<div class="w3-col w3-center">
			<div class="w3-col w3-border">
				<h5 class="w3-col m7 w3-border-left">${RESIPI.rname}</h5>
				<h5 class="w3-col m2 w3-border-left">조회수 : ${RESIPI.cnt}</h5>
				<h5 class="w3-col m3 w3-border-left">${RESIPI.sdate}</h5>
			</div>
			<div class="w3-col m2">
			<h4 class="w3-left w3-padding">음식 설명</h4>
			</div>
			<div class="w3-col m8 w3-margin-top w3-margin-bottom" style="text-align: center;" >
				<img style="width:100%" src="${RESIPI.dir}">
			</div>
			<div class="w3-col m2"><p></p></div>
			
			<h3 class="w3-col">${RESIPI.time}분 소요</h3>
			<c:forEach var="body" items="${BODY}">
			<div class="w3-col w3-border-bottom w3-border-top">
				<div class="w3-col m8 w3-left w3-padding w3-margin-top">${body.body}</div>
				<div class="w3-col m4 w3-right">
						<img class="w3-col" src="${body.dir}">
				</div>
			</div>
			</c:forEach>
			
			<div class="w3-col w3-border-bottom">
				<div class="w3-col w3-border">필요한 재료 리스트</div>
			<c:forEach var="ingred" items="${INGRED}">
				<div class="w3-col m2">
					<h4>${ingred.name}</h4>
				</div>
			</c:forEach>
			</div>
			
			
			<iframe width="480" height="320" src="${RESIPI.video}"></iframe>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<div class="w3-col m2 w3-border w3-center w3-button" id="lbtn" style="margin-left: 315px;">추천</div>
				<h6 class="w3-col m2 w3-center">${RESIPI.lcount}</h6>
			</div>
			<form method="POST" action="/fri/resipiLikeCount.fri" id="lfrm">
				<input type="hidden" name="bno" value="${RESIPI.bno}">
			</form>
			<div class="w3-col w3-border">
				<h4 class="w3-col">한줄 리뷰를 해주세요</h4>
				
				<c:if test="${not empty CNT}">
				<form method="POST" action="/fri/resipiWrite.fri" class="w3-col w3-border-bottom w3-padding w3-margin-top" id="rfrm">
					<input class="w3-col m8" style="height: 40px;" id="reply" name="reply">
					<div class="w3-col m4 w3-button w3-border" id="rbtn">작성</div>
				</form>
				</c:if>
				
				<c:if test="${empty CNT}">
					<h4>리뷰 작성을 완료했습니다.</h4>
				</c:if>
				
				<div class="w3-col w3-border-bottom">
					<span class="w3-col m2 w3-border">아이디</span>
					<div class="w3-col m8 w3-border">댓글 내용</div>
					<span class="w3-col m2 w3-border">작성일</span>
				</div>
				
				<c:forEach var="reply" items="${REPLY}">
				<div class="w3-col w3-border-bottom">
					<span class="w3-col m2 w3-border-bottom">${reply.id}</span>
					<div class="w3-col m7 w3-border-bottom">${reply.body}</div>
					<span class="w3-col m3 w3-border-bottom">${reply.rdate}</span>
				</div>
				</c:forEach>
				
			</div>
			
			<div class="w3-col w3-margin-top">
				<form method="POST" action="/fri/resipiPage.fri" name="pfrm" id="pfrm" class="w3-bar w3-border w3-round">
					<input type="hidden" id="nowPage" name="nowPage">
					<!-- 이전 버튼 처리 -->
				  	<c:if test="${PAGE.startPage != 1}">
				  		<span class="w3-bar-item w3-button w3-hover-deep-orange pagebtn" id="${PAGE.startPage - 1}"><</span>
				  	</c:if>
				  
				  	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
				  		<span class="w3-bar-item w3-button w3-hover-lime pagebtn" id="${page}">${page}</span>
				  	</c:forEach>
				  
					<!-- 다음 버튼 처리 -->
				  	<c:if test="${PAGE.endPage != PAGE.totalPage}">
				  		<span class="w3-bar-item w3-button w3-hover-deep-orange pagebtn" id="${PAGE.endPage + 1}">></span>
				  	</c:if>
				</form>
			</div>
			
			<div class="w3-col w3-margin-top">
				<div class="w3-col w3-border-bottom">가지고 있는 재료로 가능한 요리</div>
				<c:forEach var="other" items="${OTHER}">
				<div class="w3-col m2 w3-padding-right w3-center w3-button w3-margin-right other" name="${other.bno}">
					<img class="w3-col" src="${other.dir}" id="" style="height: 100px;">
					<h6 class="w3-col" id="">${other.name}</h6>
				</div>
				<form method="POST" action="/fri/resipiPage.fri" id="${other.bno}">
					<input type="hidden" name="${other.bno}">
				</form>
				</c:forEach>
			</div>
		</div>
     </div>
     
    <!-- End Middle Column -->
    </div>
    
    <!-- Right Column -->
	<div class="w3-col m1">
    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <h5>Footer</h5>
</footer>

<footer class="w3-container w3-theme-d5">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
 
<script>
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-d1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
  }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html>