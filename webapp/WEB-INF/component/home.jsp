<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upvote</title>
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/upvote_logo.png" type="image/png"/>
<link rel="shortcut icon" href="../image/upvote_logo.png" type="image/png">

<link rel="stylesheet" type="text/css" href="../../css/home.css">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body style="background-color: rgb(38, 40, 43); color: rgb(242, 242, 243);">
	
	<div class="col-xs-12 col-md-12 col-lg-12" style="padding: 0;">
		<!--로그인-->
		<div class="login_box defaultPage">
			<div class="loginSectionTitle">
				Sign In To
			</div>
			<div class="login_purple_background">
				<div class="col-xs-12 col-md-12 col-lg-12 loginSection">
					<div class="LoginImg">
					</div>
				</div>
				<form action="login.go" method="POST" class="loginStart">
					<div class="col-xs-12 col-md-12 col-lg-12 idBox">
						<p class="inputList idList">
							<span class="idListSection" ></span> <span> <input type="text" autocomplete="off" name="id" class="loginInputForm insertId" placeholder="ID"> </span>
						</p>
					</div>
					<div class="col-xs-12 col-md-12 col-lg-12 pwdBox">
						<p class="inputList pwdList">
							<span class="pwdListSection" ></span> <span> <input type="password" autocomplete="off" name="pwd" class="loginInputForm insertPwd" placeholder="Password"> </span>
						</p>
					</div>
					<div class="col-xs-12 col-md-12 col-lg-12 loginBtnBox">
						<div class="loginBtn loginDo">
							로그인
						</div>
					</div>	
					<div class="col-xs-12 col-md-12 col-lg-12 signUpBox">
						<div class="signUp">
							회원가입
						</div>
					</div>
				</form>
			</div>	
		</div>
	</div>
	
	<div class = "findModal">
		기능 준비중입니다.
		<a class = "modalCloseBtn">닫기</a>
	</div>
	
	<div class = "loginErrorModal">
		아이디, 비밀번호를 다시 확인해주세요.
		<a class = "modalCloseBtn">닫기</a>
	</div>
	
	<script src="../../js/home.js"></script>
</body>
</html>