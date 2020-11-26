$(function(){
	$('#joinbtn').click(function(){
		location.href = '/fri/joinpage.fri';
	});
	$('#logoutbtn').click(function(){
		$(location).attr('href' , '/fri/logout.fri');
	});
	$('#loginbtn').click(function(){
		$('#loginform').submit();
	});
	
	var parameter = location.search;
	var parameter = parameter.substr(1);
	if(parameter == 'fail'){
		alert(parameter);
	}
	$('.latelyuploadbtn').click(function(){
		$(this).submit();
	});
	// 랭킹 누르면 가는 작업 해야됨
});