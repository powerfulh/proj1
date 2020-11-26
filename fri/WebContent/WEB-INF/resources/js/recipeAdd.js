$(document).ready(function(){
	$('#sabtn1').click(function(){
		
		$('#frm').submit();
	});
	$('#sabtn2').click(function(){
		
		$('#frm1').submit();
	});
	
	$('#image').change(function(e){
		var ipath = URL.createObjectURL(e.target.files[0]);
		$('#iImg').attr('src', ipath);
	});
});