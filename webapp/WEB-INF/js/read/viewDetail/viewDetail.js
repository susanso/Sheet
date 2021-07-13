// 수정-저장 버튼
$(".edit_button").click(function() {
	if ($(this).hasClass("edit_button")) {
		$(".update_input").prop('disabled', false);
		$(this).text("저장");
		$(this).addClass("save_button");
		$(this).removeClass("edit_button");
	} else {
		$(".update_input").prop('disabled', true);
		$(this).addClass("edit_button");
		$(this).removeClass("save_button");
		$(this).text("수정");
	}
});

// 저장 버튼 누르면 update
$(".save_button").click(function() {
	
});

// 삭제 버튼
$(".delete_button").click(function() {
	alert("삭제되었습니다.");
});

// top 이동 버튼
$(function() {
	// 보이기 | 숨기기
	$(window).scroll(function() {
		if ($(this).scrollTop() > 250) { //250 넘으면 버튼이 보여짐니다.
			$('#topBtn').fadeIn();
		} else {
			$('#topBtn').fadeOut();
		}
	});
	// 버튼 클릭시
	$("#topBtn").click(function() {
		$('html, body').animate({
			scrollTop: 0    // 0 까지 animation 이동합니다.
		}, 400);          // 속도 400
		return false;
	});
});
