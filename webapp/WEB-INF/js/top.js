//로그아웃
$(document).on("mouseover",".userName",function(){
	$(".logout").css("display", 'flex');
});

$(document).on("mouseout",".userName",function(){
	$(".logout").css("display", 'none');
});

$('.upvoteLogo').click(function() {
	location.href = '/main';
})