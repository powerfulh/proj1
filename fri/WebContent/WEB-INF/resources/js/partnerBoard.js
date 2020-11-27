$(document).ready(function(){
	$('.btn').click(function(){
		var tno = $(this).next().html();
		
		$('#bno').val(tno);
		$('#frm').submit();
	});
});