$(document).ready(function(){
	var ingred ='';
	
	$('.ingbtn1').click(function(){
		$('.iList').addClass('w3-hide');
		$('.육류').removeClass('w3-hide');
	});
	$('.ingbtn2').click(function(){
		$('.iList').addClass('w3-hide');
		$('.콩두부').removeClass('w3-hide');
	});
	$('.ingbtn3').click(function(){
		$('.iList').addClass('w3-hide');
		$('.채소류').removeClass('w3-hide');
	});
	$('.ingbtn4').click(function(){
		$('.iList').addClass('w3-hide');
		$('.과일류').removeClass('w3-hide');
	});
	$('.ingbtn5').click(function(){
		$('.iList').addClass('w3-hide');
		$('.해산물').removeClass('w3-hide');
	});
	$('.ingbtn6').click(function(){
		$('.iList').addClass('w3-hide');
		$('.조미료').removeClass('w3-hide');
	});
	$('.ingbtn7').click(function(){
		$('.iList').addClass('w3-hide');
		$('.유제품').removeClass('w3-hide');
	});
	$('.ingbtn8').click(function(){
		$('.iList').addClass('w3-hide');
		$('.면류').removeClass('w3-hide');
	});
	
	var abc = '';
	
	$('.iList').click(function(){
		abc += '<div class="selectedING w3-button"><img src="' + $(this).children().attr('src') + '"><strong>'
			 + $(this).children().next().html() + '</strong></div>';
		$('#selected').html(
			abc);
		$(this).addClass('w3-hide');
		
		ingred += $(this).children().attr('alt');
	});
	
	$('.seletedING').click(function(){
		$(this).removeClass('w3-hide');
		ingred -= $(this).children().attr('alt');
		
	});
});