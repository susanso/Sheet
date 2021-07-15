//로그아웃
$(document).on("mouseover",".profile",function(){
	$(".logout").css("display", 'flex');
});

$(document).on("mouseout",".profile",function(){
	$(".logout").css("display", 'none');
});
 
$('.upvoteLogo').click(function() {
	location.href = '/main';
});

$('.insertPage').click(function() {
	location.href = '/insert';
});

$('.viewPage').click(function() {
	location.href = '/view';
});
