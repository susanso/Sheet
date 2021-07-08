// 회원가입 할 때 사용자가 입력한 정보 얻어오는 메서드 
function getSignUpInfo() {
	let userID = $('.signUpId').val();
	let userName = $('.signUpUserName').val();
	let firstPwd = $('.signUpPwd1').val();
	let secondPwd = $('.signUpPwd2').val();
	
	return {
		userID: userID,
		userName: userName,
		firstPwd: firstPwd,
		secondPwd: secondPwd	
	};
}

// 아이디 입력할 때 마다 태그값에 value = 0 넣어줌 
$('.signUpId').on('propertychange change keyup paste input', function() {
	console.log($('.signUpId').val());
	
	// default로 태그 값에 value = 0 넣어줌 
	$('.overlapContainer').attr('value', 0);
});

// 회원가입 할 때 사용자가 입력한 정보가 유효한지 확인하는 메서드
function isValidSignUpInfo(userId, userName, firstPwd, secondPwd) {
	let signUpInfo = getSignUpInfo();
	
	let user_id = signUpInfo.userID;
	let user_name = signUpInfo.userName;
	let first_pwd = signUpInfo.firstPwd;
	let second_pwd = signUpInfo.secondPwd;
	
	let is_valid = false;
	
	if (user_name.length == 0) {
		$('.alertName').css('display', 'block');
	}
	
	else if (first_pwd.length == 0) {
		$('.alertPwd1').css('display', 'block');
	}
	
	// 첫번째 비밀번호 != 두번째 비밀번호 -> 회원가입 실패 
	if ((first_pwd != second_pwd)) {
		$('.pwdAlertError').css('display', 'block');
		$('.pwdAlertError').addClass("alertError");
	}
	
	// 아이디 중복확인 x -> 회원가입 실패 
	else if (!$('.overlapContainer').hasClass('check_overlap') || ($('.overlapContainer').attr('value') == '0')) {
		// 아이디 중복 확인 모달창 띄움 
		modal('overlapAlertBox');
		
		// 모달창에서 닫기 버튼 누르면 메인 페이지로 이동 
		$('.modalCloseBtn').click(function() {
			$('.overlapAlertBox').css('display', 'none');
		})
	}
	
	// 첫번째 비밀번호 == 두번재 비밀번호 and 아이디 중복확인 통과 -> 회원가입 성공 
	else if ((first_pwd == second_pwd) && (user_id.length != 0) && (user_name.length != 0) && (first_pwd.length != 0) && (second_pwd.length != 0) && ($('.overlapContainer').attr('value') == "1")) {
		$('.alertError').css('display', 'none');
		$('.pwdAlertError').removeClass("alertError");
		
		is_valid = true;
	}
	
	return is_valid;
}

// 회원가입 가능하면 컨트롤러에 요청 보내서 회원가입 진행 
function signUp(user_id, user_name, second_pwd) {
	let data_toController = {
		userId: user_id,
		userName: user_name,
		userPwd: second_pwd
	}
		
	$.ajax ({
		url: "signUp.go",
		data: data_toController,
		type: "GET",
		success : function(data) {
			
			// 회원가입 성공 모달창 띄움 
			modal('signUpAlertBox');
			
			// 모달창에서 닫기 버튼 누르면 메인 페이지로 이동 
			$('.modalCloseBtn').click(function() {
				$('.signUpAlertBox').css('display', 'none');
				location.href = '/';
			})
		}
	});
}

// 회원가입 완료 모달 띄우기 
function modal(className) {
    var modal = $('.' + className);

    modal
        .css({
            position: 'fixed',
            top: '5%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            msTransform: 'translate(-50%, -50%)',
            webkitTransform: 'translate(-50%, -50%)'
        })
        .show()
}

// 회원가입 눌렀을 때 사용자 정보 가져와서 비밀번호 유효성 검사 후 DB 입력 
$('.createSignUp').click(function() {
	let signUpInfo = getSignUpInfo();
	
	let user_id = signUpInfo.userID;
	let user_name = signUpInfo.userName;
	let first_pwd = signUpInfo.firstPwd;
	let second_pwd = signUpInfo.secondPwd;
		
	// 회원가입 유효한지 여부 확인 	
	let signUp_is_valid = isValidSignUpInfo(user_id, user_name, first_pwd, second_pwd);
	
	// 회원가입 유효하면 회원가입 진행 
	if (signUp_is_valid == true) {
		signUp(user_id, user_name, second_pwd);
	}
});

// 회원가입 하기 위해 엔터로 클릭했을 때 위와 동일한 동작
$('.signUpPwd2').keyup(function(e) {
	if (e.keyCode == 13) {
		let signUpInfo = getSignUpInfo();
	
		let user_id = signUpInfo.userID;
		let user_name = signUpInfo.userName;
		let first_pwd = signUpInfo.firstPwd;
		let second_pwd = signUpInfo.secondPwd;
		
		// 회원가입 유효한지 여부 확인 	
		let signUp_is_valid = isValidSignUpInfo(user_id, user_name, first_pwd, second_pwd);
		
		// 회원가입 유효하면 회원가입 진행 
		if (signUp_is_valid == true) {
			signUp(user_id, user_name, second_pwd);
		}
	}
});

// 아이디 중복확인 메서드 
$('.checkIdOverlap').click(function() {	
	let signUpInfo = getSignUpInfo();
	let user_id = signUpInfo.userID;
	
	// 아이디 중복 확인 여부 켜져있으면 끔 
	$('.IdNotOverlap').css("display", 'none');
	$('.Idoverlap').css('display', 'none');
	
	// 사용자가 id에 아무것도 입력 안하고 중복 확인 눌렀을 때 
	if (user_id.length == 0) {
		// 사용 불가능한 아이디 웹에 출력 
		$('.Idoverlap').css('display', 'block');
	}
	
	else {
		$.ajax ({
		url : "checkID",
		data: {"id": user_id},
		type: "POST",
		success: function(data) {
			if (data.id == "valid") {
				// 사용 가능한 아이디 웹에 출력 
				$('.IdNotOverlap').css('display', 'block');
				
				// 유효하다고 태그 요소에 삽입 
				$('.overlapContainer').attr('value', 1);
			}
			
			else {
				// 사용 불가능한 아이디 웹에 출력 
				$('.Idoverlap').css('display', 'block');
				
				// 유효하지 않다고 태그 요소에 삽입 
				$('.overlapContainer').attr('value', 0);
			}
		}});
	}
	
	// 중복확인 했음을 알리기 위함 
	$('.overlapContainer').addClass("check_overlap");
})

