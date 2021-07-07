// 회원가입 페이지로 이동
$('.signUp').click(function() {
	location.href = '/signup.do';
});

// 아이디/비밀번호 찾기 기능 준비중 모달 띄우기 
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

// 아이디/비밀번호 찾기 기능 준비중 모달 띄우기 
$('.findUserinfo').click(function() {
	modal('findModal');
	
	$('.modalCloseBtn').click(function() {
		$('.findModal').css('display', 'none');
	})
});

// Main Logo 클릭했을 때 새로고침
$('.LoginImg').click(function() {
	location.href = '/';
});

// 로그인 컨트롤러에 요청 보내는 메서드 
function login() {
	let id = $('.insertId').val();
	let pwd = $('.insertPwd').val();
	
	$.ajax ({
			url: "login.do",
			data: {"id": id, "pwd": pwd},
			type: "POST",
			success : function(data) {
				
				// 로그인 성공하면 메인 페이지로 이동 
				if (data.login == "success") {
					location.href = '/main';
				}
				
				// 로그인 실패하면 아이디, 비밀번호 확인하라는 모달창 띄움 
				else {
					console.log("Login Fail");
					
					modal('loginErrorModal');
					
					$('.modalCloseBtn').click(function() {
						$('.loginErrorModal').css('display', 'none');
					})
				}
			}
		});
}

// Login 입력 데이터 Controller에 전달 로그인 Button Click Event 
$('.loginDo').click(function() {
	login();
});

// Login 입력 데이터 Controller에 전달 로그인 Enter Event 
$('.insertPwd').add('.insertId').keyup(function(e) {
	if(e.keyCode == 13) {
		login();
	}
});