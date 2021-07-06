// 회원가입 페이지로 이동
$('.signUp').click(function() {
	location.href = '/signup.do';
});

// 아이디/비밀번호 찾기 기능 준비중 모달 띄우기 
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

// 아이디/비밀번호 찾기 기능 준비중 모달 띄우기 
$('.findUserinfo').click(function() {
	modal('findModal');
	
	$('.modalCloseBtn').click(function() {
		$('.findModal').css('display', 'none');
	})
});

// Main Logo 클릭했을 때 새로고
$('.LoginImg').click(function() {
	location.href = '/';
});

// Login 입력 데이터 Controller에 전달 로그인 Button Click Event 
$('.loginDo').click(function() {
	let id = $('.insertId').val();
	let pwd = $('.insertPwd').val();
	
	$.ajax ({
			url: "login.do",
			data: {"id": id, "pwd": pwd},
			type: "GET",
			success : function(data) {
				console.log(data);
				
				if (data.login == "success") {
					location.href = '/main';
				}
				
				else {
					console.log("Login False");
				}
			}
		});
});

// Login 입력 데이터 Controller에 전달 로그인 Enter Event 
$('.insertPwd').keyup(function(e) {
	if(e.keyCode == 13) {
		let id = $('.insertId').val();
		let pwd = $('.insertPwd').val();
	
		$.ajax ({
				url: "login.do",
				data: {"id": id, "pwd": pwd},
				type: "GET",
				success : function(data) {
					console.log(data);
				
					if (data.login == "success") {
						location.href = '/main';
					}
					
					else {
						console.log("Login False");
					}
				}
		});
	}
});