$('.signUp').click(function() {
	location.href = '/signup.do';
});

function modal(className) {
	var zIndex = 9999;
    var modal = $('.' + className);

    modal
        .css({
            position: 'fixed',
            boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

            // 시꺼먼 레이어 보다 한칸 위에 보이기
            zIndex: zIndex + 1,

            // div center 정렬
            top: '70%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            msTransform: 'translate(-50%, -50%)',
            webkitTransform: 'translate(-50%, -50%)'
        })
        .show()
}

$('.findUserinfo').click(function() {
	modal('findModal');
	
	$('.modalCloseBtn').click(function() {
		$('.findModal').css('display', 'none');
	})
});