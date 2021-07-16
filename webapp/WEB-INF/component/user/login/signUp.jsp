<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/upvote_logo.png" type="image/png"/>
<link rel="shortcut icon" href="../image/upvote_logo.png" type="image/png">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="../../css/user/login/signUp.css">
<title>Upvote | 회원가입</title>
</head>
<body style="background-color: rgb(0, 0, 0); color: rgb(242, 242, 243);">
	<div class="signUpContainer">
		<div class="signUpBox">
				<div class="signUpculumnRow">
					<div class="signUpTitle">아이디  </div>
					<div class="signUpInputmBox">
						<input type="text" name="id" autocomplete="off" 
							class=" signUpInputForm signUpId" maxlength="12"
							spellcheck="false" placeholder="영문 숫자 조합 아이디(6~12자)"
							oninput="this.value = this.value.replace(/[^a-z0-9]/gi,'');">
					</div>
				</div>
				<div class = "overlapContainer">
					<div class = "checkIdOverlap">중복 확인</div>
					<div class = "overlap Idoverlap">사용 불가능한 아이디입니다.</div>
					<div class = "overlap IdNotOverlap">사용 가능한 아이디입니다.</div>
				</div>
				<div class="overlapAlertBox">
					아이디 중복 확인을 진행하세요. 
					<a class = "modalCloseBtn">닫기</a>
				</div>
				<div class="signUpculumnRow">
					<div class="signUpTitle">이름  </div>
					<div class="signUpInputmBox">
						<input type="text" name="id" autocomplete="off"
							class=" signUpInputForm signUpUserName" maxlength="12"
							spellcheck="false" placeholder="이름">					
					</div>
				</div>
				<div class="alertError alertName">이름을 입력해주세요.</div>
				<div class="signUpculumnRow">
					<div class="signUpTitle">비밀번호  </div>
					<div class="signUpInputmBox">
						<input type="password" name="pwd_first"
							class="signUpInputForm signUpPwd1" placeholder="비밀번호">
					</div>
				</div>
				<div class="alertError alertPwd1">비밀번호를 확인해주세요.</div>
				<div class="signUpculumnRow">
					<div class="signUpTitle">비밀번호 확인</div>
					<div class="signUpInputmBox">
						<input type="password" name="pwd_second"
							class="signUpInputForm signUpPwd2" placeholder="비밀번호 재확인">
					</div>
				</div>
				<div class="pwdAlertError">비밀번호가 일치하지 않습니다.</div>
				<div class="createSignUp">회원가입</div>
				<div class="signUpAlertBox">
					회원가입이 완료되었습니다.
					<a class = "modalCloseBtn">닫기</a>
				</div>
		</div>
	</div>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/user/login/signUp.js"></script>
</html>