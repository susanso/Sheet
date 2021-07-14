<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/upvote_logo.png" type="image/png"/>
<link rel="shortcut icon" href="../image/upvote_logo.png" type="image/png">

<link rel="stylesheet" type="text/css" href="../../css/top.css">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<div class = "topContainer">
	<div class = "upvoteLogo"># UPVOTE Entertainment</div>
	<div class = "functionPage">
		<div class = "page insertPage">입력</div>
		<div class = "page viewPage">수정</div>
	</div>
	<div class = "profile">
		<div class = "profileImg"></div>
		<div class = "userName">${userName}</div>
		<div class = "logout"><a href = "logout.do" class = "logoutPage">로그아웃</a></div>
	</div>
</div>

<script src="../../js/top.js"></script>
</html>