<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="/fri/css/my.css">
<script type="text/javascript" src="/fri/js/jquery.min.js"></script>
<!--
<script type="text/javascript" src="/fri/js/"></script>
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

.search-ingre{
	width:100%;
}

#ckbox{
	width:900px;
    height:auto;
    margin:5px;
    border: 2px solid red;
}

#ckbox label{
	font-size:23px;
}
#ckbox p{
    font-size:30px;
    text-align:center;
}

#big_sort{
	text-align:center;
    width: 100px;
    border: 1px solid;
}

#big_sort button{
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
	border: 1px solid blue;
    margin: 2px;
    width:98%;
    height:30px;
}

#big_sort button:hover{
	background-color:orange;
}

.small_sort{
	text-align:center;
    width:400px;
    border:1px dotted red;
}

ul li{
   list-style:none;
   margin-left:20px;
}

</style>
<script type="text/javascript">
	var num = $("#big_sort").find('button');
	var cartAr;
	$(function() {
		$("Iname1").on("click", function() {
			for(int x =0; x<num.length(); x++){
				$('asd1').show();
				$('asd2').hide();
				$('asd3').hide();
				$('asd4').hide();
				$('asd5').hide();
				$('asd6').hide();
			}
		});
		$("Iname2").on("click", function() {
			$('asd1').hide();
			$('asd2').show();
			$('asd3').hide();
			$('asd4').hide();
			$('asd5').hide();
			$('asd6').hide();
		});
		
		$("#cart").html().append("<li>강냉이<img src='')></li>")
		cartAr[] = '강냉이'
	});
</script>
</head>
<body class="">


<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:20px">    
	<div class="w3-col w3-card w3-margin-bottom w3-round">
		<h1>대충 이곳엔 로고가 들어갈거임</h1>
	</div>
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    <div class="w3-col m3">
      <!-- Profile -->
      <div class="w3-card w3-round w3-white">
        <div class="w3-container">
         <h4 class="w3-center">My Profile</h4>
         <p class="w3-center"><img src="/fri/img/avatar/m3.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> ID</p>
         <p><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> Loc</p>
         <p class="w3-btn w3-border w3-hover-blue change05bgc"><i class="fa fa-edit fa-fw w3-margin-right w3-text-theme"></i> edit</p>
        </div>
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
    <!-- Middle Column -->
    <!-- 작업할 곳 -->
    <div class="w3-col m9">
      <div class="w3-container w3-card w3-round w3-margin-bottom w3-margin-left w3-margin-right" style="background-color: #E8EAEE;">
			<div style="height:2000px">
			<h2 style="text-align: center;">냉장고를 부탁해!</h2>
        	<h1 style="text-align: center;">냉장고에 잠자는 재료들로 레시피를 찾아보세요!</h1>
        	<form action="/recipes" accept-charset="UTF-8" method="get">
        		<input name="utf8" type="hidden" value="">
				<input type="hidden" name="sort" value="">
        		<div id="ckbox" style="border: 0px solid;">
					<div class="field1" style="margin: 10px; vertical-align: middle; border: 1px solid; text-align: justify; text-align: center;">
						<input type="text" class="search-ingre" placeholder="음식명으로 검색해보세요!" style="border: 0px solid; display: inline-block; width: calc(100% - 80px); font-size: 30px; vertical-align: middle;">
						<button style=""><img src="/fri/img/cook/search.png"></button>
	        		</div>
	        		<div style="background-color: #fff; margin: 10px; padding: 10px;">
	        			<h3 style="text-align: center;">상황에 맞는 음식</h3>
	        			<div style="text-align: center; margin-top: 10px;">
			        		<input type="checkbox" style="zoom:2.0; margin-left: 5px;" id="categori1" value="solo">
			  				<label for="categori2">자취요리</label>
			        		<input type="checkbox" style="zoom:2.0; margin-left: 5px;" id="categori2" value="drink">
			  				<label for="categori3">술안주</label>
			        		<input type="checkbox" style="zoom:2.0; margin-left: 5px;" id="categori3" value="home">
			  				<label for="categori4">집반찬</label>
			        		<input type="checkbox" style="zoom:2.0; margin-left: 5px;" id="categori4" value="hearty">
			  				<label for="categori5">든든하게</label>
		  				</div>
	  				</div>
	  			</div>
	  			<!-- 버튼 선택 -->
	  			<div style="text-align: center; display: inline-block;">
		  			<div id="big_sort" style="width: 20%;margin: 20px;display: inline-block;height: 600px;float: left;">
						<button>육류 </button>
						<button>콩/두부 </button>
						<button>채소류 </button>
						<button>과일류 </button>
						<button>해산물 </button>
						<button>유제품 </button>
						<button>면류 </button>
					</div>
					
					<!-- 선택가능한 재료 띄워주는 곳 -->
					<div class="small_sort" style="width: 42%; margin: 20px; display: inline-block; height: 600px; float:left;">
						<h2>선택 가능한 재료</h2>
						<hr>
						<ul style="padding-inline-start: 0px;">
							<li style="margin-left: 0px;">
								<a ino="71" href="javascript:;">
								 	<em></em>
								 	<img src="/fri/img/cook/bread.png" alt="bread" />
								 	<strong>빵</strong>
								</a>
							</li>
							<li style="margin-left: 0px;">
								<a ino="72" href="javascript:;">
								 	<em></em>
								 	<img src="/fri/img/cook/apple.png" alt="apple" />
								 	<strong>사과</strong>
								</a>
								</li>
							<li style="margin-left: 0px;">
								<a ino="73" href="javascript:;">
								 	<em></em>
								 	<img src="/fri/img/cook/chicken.png" alt="chicken" />
								 	<strong>닭</strong>
								</a>
							</li>
							<li style="margin-left: 0px;">
								<a ino="74" href="javascript:;">
								 	<em></em>
								 	<img src="/fri/img/cook/meat.png" alt="meat" />
								 	<strong>고기</strong>
								</a>
							</li>
							<li style="margin-left: 0px;">
								<a ino="75" href="javascript:;">
								 	<em></em>
								 	<img src="/fri/img/cook/noodle.png" alt="noodle" />
								 	<strong>라면</strong>
								</a>
							</li>
						</ul>
					</div>
					<!-- 선택한 재료 띄워주는 곳 -->
					<div style="margin: 20px;border: 1px solid;display: inline-block;height: 600px;float: left;width: 25%; ">
						<dl>
							<dt>
								<h3>내가 선택한 재료</h3>
							</dt>
							<dd>
								<ul class="selected-ingre">
									<li class="no-content">재료를 선택해주세요.</li>
								</ul>
								<div class="btn">
									<button type="submit">추천받기</button>
								</div>
							</dd>
						</dl>
					</div>
				</div>
			</form>
				<!-- 레시피 검색 결과 -->
				<div class="" style="style="width:940px; height:1030px; border:1px solid;" >
					<div class="tit_area">
					<h2>조건에 맞는 레시피가 <strong>0개</strong>개 있습니다.</h2>
						<div class="sort_area">
							<select class="sort-selector" name="sort">
								<option value="recent">최신순 정렬</option>
								<option value="like">좋아요순 정렬</option>
							</select>
						</div>
					</div>
					<div>
						
					</div>
				</div>			
			</div>
     	 </div>
		</div>
    <!-- End Middle Column -->
    </div>
  <!-- End Grid -->
  </div>
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <h5>Footer</h5>
</footer>

<footer class="w3-container w3-theme-d5">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>

</body>
</html>