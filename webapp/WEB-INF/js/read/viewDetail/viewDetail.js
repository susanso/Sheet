
// 수정 버튼 누름 
$(".edit_button").click(function() {
	$(".update_input").prop('disabled', false);
	$(this).css('display', 'none');
	$(".save_button").css('display', 'flex');
});

// 저장 버튼 누르면 update
$(".save_button").click(function() {
	$(".update_input").prop('disabled', true);
	$(this).css('display', 'none');
	$(".edit_button").css('display', 'flex');
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


function modal(className) {
    var modal = $('.' + className);

    modal
        .css({
            position: 'fixed',
            top: '30%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            msTransform: 'translate(-50%, -50%)',
            webkitTransform: 'translate(-50%, -50%)'
        })
        .show()
}

// Window 크기 다시 지정
function windowResize() {
	// width는 동일 height만 다시 지정 
	let height = $('.all_cards_container').height();
	
	window.resizeTo(900, height + 57); // 48 = url + title bar
}