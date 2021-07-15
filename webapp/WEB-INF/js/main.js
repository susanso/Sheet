// 입력 페이지로 이동 
$('.insert').click(function() {
	location.href = '/insert';
});

//로그아웃
$(document).on("mouseover",".userName_logout",function(){
	$(".logout").css("display", 'flex');
});

$(document).on("mouseout",".userName_logout",function(){
	$(".logout").css("display", 'none');
});

// 수정 확인 페이지로 이동 
$('.update').click(function() {
	location.href = '/view';
});

$('.hookTest').click(function() {
	$.ajax({
		url:'/main/flasktest',
		type:'POST',
		success: function(data){
			console.log(data);
		}
	});
})