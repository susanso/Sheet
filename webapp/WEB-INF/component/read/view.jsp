<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upvote | 편집</title>
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/upvote_logo.png" type="image/png"/>
<link rel="shortcut icon" href="../image/upvote_logo.png" type="image/png">

<link rel="stylesheet" type="text/css" href="../../css/read/view.css">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body style="background-color: rgb(38, 40, 43); color: rgb(242, 242, 243);">
<%@ include file="../../component/top.jsp" %>

<div class = "tableContainer">
	<div class = "selectViewType">
		<div class="viewMine_viewAll">
		    <div class="viewMine">내 데이터</div>
		    <div class="viewAll">전체 보기</div>
        </div>
		<div class = "function">
		<div class = "search">
			<div class = "searchBox">
				<input type = "text" class = "searchInfo" value ='  담당자를 입력해주세요.'>
			</div>
			<div class = "searchBtn">검색</div>
		</div>
	</div>
	</div>
	<div class = "tableTitleBox">
		<div class = "column pdname">작업 담당자</div>
		<div class = "column song">곡명</div>
		<div class = "column artist">아티스트명</div>
		<div class = "column genre">장르</div>
		<div class = "column key">키</div>
		<div class = "column BPM">BPM</div>
		<div class = "column beat">박자</div>
		<div class = "column songform">송폼</div>
		<div class = "column track">트랙 형태</div>
		<div class = "column inst">악기 정보</div>
		<div class = "column chordInfo">코드 정보</div>
	</div>
	<div class = "tableColumnBox">
		<div class = "dataColumnContainer">
		</div>
	</div>
	
</div>
<%@ include file="../../component/footer.jsp" %>
<script src="../../js/read/view.js"></script>
</body>
</html>