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

// 회원가입 할 때 사용자가 입력한 정보가 유효한지 확인하는 메서드
function isValidSignUpInfo(userId, userName, firstPwd, secondPwd) {
	let signUpInfo = getSignUpInfo();
	
	let user_id = signUpInfo.userID;
	let user_name = signUpInfo.userName;
	let first_pwd = signUpInfo.firstPwd;
	let second_pwd = signUpInfo.secondPwd;
	
	let is_valid = false;
	
	if (user_id.length == 0) {
		$('.alertId').css('display', 'block');
	}
	
	else if (user_name.length == 0) {
		$('.alertName').css('display', 'block');
	}
	
	else if (first_pwd.length == 0) {
		$('.alertPwd1').css('display', 'block');
	}
	
	else if (second_pwd.length == 0) {
		$('.alertPwd2').css('display', 'block');
	}
	
	// 첫번째 비밀번호 != 두번째 비밀번호 -> 회원가입 실패 
	if (first_pwd != second_pwd) {
		$('.pwdAlertError').css('display', 'block');
		$('.pwdAlertError').addClass("alertError");
	}
	
	// 첫번째 비밀번호 == 두번재 비밀번호 -> 회원가입 성공 
	else if ((first_pwd == second_pwd) && (user_id.length != 0) && (user_name.length != 0) && (first_pwd.length != 0) && (second_pwd.length != 0)) {
		$('.alertError').css('display', 'none');
		$('.pwdAlertError').removeClass("alertError");
		
		is_valid = true;
	}
	
	return is_valid;

}

// 회원가입 눌렀을 때 사용자 정보 가져와서 비밀번호 유효성 검사 후 DB 입력 
$('.createSignUp').click(function() {
	let signUpInfo = getSignUpInfo();
	
	let user_id = signUpInfo.userID;
	let user_name = signUpInfo.userName;
	let first_pwd = signUpInfo.firstPwd;
	let second_pwd = signUpInfo.secondPwd;
		
	let signUp_is_valid = isValidSignUpInfo(user_id, user_name, first_pwd, second_pwd);
	
	if (signUp_is_valid == true) {
		console.log("회원가입 Success");
	}
	
	else{
		console.log("회원가입 Fail");
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
			
		let signUp_is_valid = isValidSignUpInfo(user_id, user_name, first_pwd, second_pwd);
		
		if (signUp_is_valid == true) {
			console.log("회원가입 Success");
		}
		
		else{
			console.log("회원가입 Fail");
		}
	}
	
});

