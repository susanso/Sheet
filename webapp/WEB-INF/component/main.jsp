<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upvote | Main</title>
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/upvote_logo.png" type="image/png"/>
<link rel="shortcut icon" href="../image/upvote_logo.png" type="image/png">

<link rel="stylesheet" type="text/css" href="../../css/main.css">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body style="background-color: rgb(38, 40, 43); color: rgb(242, 242, 243);">
<%@ include file="../component/top.jsp" %>
<div class = "title">Main Page</div>

<div class = "main">	
	<div class = "selectContainer">
		<div class = "select_box">
			<div class = "selectType">
				<div class = "insert">입력</div>
				<div class = "update">수정 & 확인</div>
			</div>
			<div class = "speechBubble">
				<div class = "leftSpeechBubble"></div>
				<div class = "rightSpeechBubble"></div>
			</div>
		</div>
	</div>
	<div class = "profile_box">
			<div class = "profile_img"></div>
			<div class = "user_name">업보트</div>	
	</div>
</div>
<script src="../../js/main.js"></script>
</body>
</html>
<%@ include file="../component/footer.jsp" %>