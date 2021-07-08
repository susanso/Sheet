<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="../css/create/insertData.css">
<title>Upvote | 입력</title>
</head>

<body style="background-color: #000; color: #f2f2f3">
	<%@ include file="../../component/top.jsp"%>
	<div class="InputContainer">
		<div class="SongInfoInputContainer">
			<div class="song_info">곡 정보 테이블</div>
			<div class="Input">
				<div class="InputBar">곡 제목</div>
				<label for="song_name"> <input type="text"
					class="input_label song_name">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">가수명</div>
				<label for="artist"> <input type="text"
					class="input_label artist">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">작성자</div>
				<label for="producer_name"> <input type="text"
					class="input_label producer_name">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">장르</div>
				<label for="genre"> <input type="text"
					class="input_label genre">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">키</div>
				<label for="key"> <input type="text" class="input_label key">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">BPM</div>
				<label for="bpm"> <input type="text" class="input_label bpm">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">송폼</div>
				<label for="song_form"> <input type="text"
					class="input_label song_form">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">박자</div>
				<label for="beat"> <input type="text"
					class="input_label beat">
				</label>
			</div>
			<div class="Input">
				<input type="button" class="SongInfoButton" value="입력">
			</div>
		</div>

		<div class="InstInfoInputContainer">
			<div class="inst_info">트랙 정보 테이블</div>
			<div class="Input">
				<div class="InputBar">곡 제목</div>
				<label for="song_name"> <input type="text"
					class="input_label song_name">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">트랙 개수</div>
				<label for="trackNum"> <input type="text"
					class="input_label trackNum">
				</label>
			</div>
			<div class="Input">
				<input type="button" class="trackNumButton" value="입력">
			</div>
			<div class="scroll_container inst_container"></div>
			<div class="Input">
				<input type="button" class="InstInfoButton" value="입력">
			</div>
		</div>

		<div class="ChordInfoInputContainer">
			<div class="chord_info">코드 정보 테이블</div>
			<div class="Input">
				<div class="InputBar">곡 제목</div>
				<label for="song_name"> <input type="text"
					class="input_label song_name">
				</label>
			</div>
			<div class="Input">
				<div class="InputBar">마디 개수</div>
				<label for="measureNum"> <input type="text"
					class="input_label measureNum">
				</label>
			</div>
			<div class="Input">
				<input type="button" class="measureNumButton" value="입력">
			</div>
			<div class="scroll_container chord_container"></div>
			<div class="Input">
				<input type="button" class="ChordInfoButton" value="입력">
			</div>
		</div>

		<div class="Input">
			<input type="button" class="SongSubmitButton" value="입력">
		</div>
	</div>
	<script src="../js/create/insertData.js"></script>
</body>
</html>
