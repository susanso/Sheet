<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<body style="background: #262626; color: rgb(242, 242, 243);">
	<%@ include file="../../component/top.jsp"%>
	<div class = "InputWrapper">
		<div class="InputContainer">
			<div class="InputTop">
				<div class="InputTopTitle"><div class="InputTopText">곡 정보 입력</div></div>
				<div class="InputTopBtn"><input type="button" class="SongSubmitButton" value="저장" style="color: black;"></div>
			</div>
			
			<div class="InputContentWrapper">
				<div class="InputContent">
					<div class="InputContentTop">
						<div class="SongInfoInputContainer">
							<div class="SongInput songName">
								<div class="InputBar">곡 제목</div>
								<label for="song_name"><input type="text" class="input_label song_name">
								</label>
							</div>
							<div class="SongInput artist">
								<div class="InputBar">가수명</div>
								<label for="artist"> <input type="text" class="input_label artist">
								</label>
							</div>
							<div class="SongInput genre">
								<div class="InputBar">장르</div>
								<label for="genre"> <input type="text" class="input_label genre">
								</label>
							</div>
							<div class="SongInput keyName">
								<div class="InputBar">키</div>
								<label for="key"> <input type="text" class="input_label key">
								</label>
							</div>
							<div class="SongInput bpm">
								<div class="InputBar">BPM</div>
								<label for="bpm"> <input type="text" class="input_label bpm">
								</label>
							</div>
							<div class="SongInput songForm">
								<div class="InputBar">송폼</div>
								<label for="song_form"> <input type="text" class="input_label song_form">
								</label>
							</div>
							<div class="SongInput beat">
								<div class="InputBar">박자</div>
								<label for="beat"> <input type="text" class="input_label beat">
								</label>
							</div>
						</div>
					</div>
					<div class="InputContentBottom">
						<div class="InstInfoInputContainer">
							<div class="InstInputTop">
								<div class="trackChordInputTitle">트랙 형태</div>
								<div class="trackChordInputContent">
									<div class="trackChordInputTitle">트랙 수</div>
									<label for="trackNum">
										<input type="text" class="input_label trackNum" placeholder = "트랙 개수를 입력해 주세요.">
									</label>
									<div class="plusMinusBtn">
										<input type="button" class="plusBtn" value="+">
										<input type="button" class="minusBtn" value="-">
									</div>
									<div class="trackChordInput">
										<input type="button" class="trackNumButton" value="입력">
									</div>
								</div>
							</div>
							<div class="scroll_container_wrapper">
								<div class="scroll_container inst_container"></div>
								<div class="scroll_container serum_container"></div>
							</div>
						</div>
				
						<div class="ChordInfoInputContainer">
							<div class="ChordInputTop">
								<div class="trackChordInputTitle">코드 정보</div>
								<div class="trackChordInputContent">
									<div class="trackChordInputTitle">마디 수</div>
									<label for="measureNum">
										<input type="text" class="input_label measureNum" placeholder = "마디 개수를 입력해 주세요.">
									</label>
									<div class="plusMinusBtn">
										<input type="button" class="plusBtn" value="+">
										<input type="button" class="minusBtn" value="-">
									</div>
									<div class="trackChordInput">
										<input type="button" class="measureNumButton" value="입력">
									</div>
								</div>
							</div>
							<div class="scroll_container chord_container"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class = "emptyInputAlertBox">
		<div class = "alertTxt"></div>
		모든 정보를 입력해 주세요.
		<a class = "modalCloseBtn">닫기</a>
	</div>
	<div class = "alertBox">
		<div class = "alertTxt"></div>
		<a class = "modalCloseBtn">닫기</a>
	</div>
	<script src="../js/create/insertData.js"></script>
</body>
<%@ include file="../../component/footer.jsp" %>
</html>
