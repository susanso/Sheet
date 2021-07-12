<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/favicon/favicon_ipad.png" type="image/png"/>
<link rel="shortcut icon" href="../image/favicon/favicon_pc.png" type="image/png">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/read/viewDetail/viewDetail.css">
<title>Upvote Sheet</title>
</head>
<body style="background-color: rgb(0, 0, 0); color: rgb(242, 242, 243);">
	<div class="Title">Upvote Sheet Page</div>
	<!-- 서치바 부분 시작 -->
	<!-- 
	<div class="search_bar_main_container">
		<div class="search_bar_title_container">
			<div class="search_bar_title">
				<div class="title_search">SEARCH</div>
				<div class="title_filter">FILTER</div>
			</div>
		</div>
		<div class="search_bar_content_container">
			<div class="search_bar">
				<div class="search_bar_input_box">
					<div class="search_img"></div>
					<input type="text" placeholder="Search..." class="search">
				</div>
				<select>
					<option>All</option>
					<option>곡명</option>
					<option>작업자 이름</option>
				</select>
			</div>
		</div>
	</div>
	-->
	<!-- 카드 부분 시작 -->
	<!-- 모든 카드를 감싸는 부분 -->
	<div class="all_cards_container">
		<!-- 카드 한 개당 컨테이너 하나로 감쌈 -->
		<div class="card_container">
			<!-- 카드 헤드 부분 -->
			<div class="card_head">
				<div class="card_head_title">
					<div class="song_title">곡명</div>
					<div class="song_artist">아티스트명</div>
				</div>
				<div class="card_head_buttons">
					<div class="button edit_button">수정</div>
					<div class="button delete_button">삭제</div>
				</div>
			</div>
			<!-- 카드 내용 부분 -->
			<div class="card_content_white_background">
				<div class="card_content_gray_background">
					<!-- 작업 담당자, 작업자 이름 -->
					<div class="card_content_writer">
						<div class="writer">작업 담당자</div>
						<div class="writer_name">작업자 이름</div>
					</div>
					<!-- 곡 정보 : 장르, 키, BPM, 송폼 넘버링 -->
					<div class="card_content_song_info">
						<!-- 장르 -->
						<div class="songInfo genre">
							<div class="item_head">장르</div>
							<div class="item_content">OST</div>
						</div>
						<!-- 키 -->
						<div class="songInfo key">
							<div class="item_head">키</div>
							<div class="item_content">GM</div>
						</div>
						<!-- BPM -->
						<div class="songInfo BPM">
							<div class="item_head">BPM</div>
							<div class="item_content">120</div>
						</div>
						<!-- 송폼 넘버링 -->
						<div class="songInfo songForm">
							<div class="item_head">송폼 넘버링</div>
							<div class="item_content">1, 5, 9</div>
						</div>
					</div>
					<!-- 곡 정보 : 트랙 형태, 코드 정보 -->
					<div class="card_content_song_info">
						<!-- 트랙 형태 -->
						<div class="songInfo track">
							<div class="item_head track_title">트랙 형태</div>
							<div class="item_content track_content">
								<div class="track_content track_number">1</div>
								<div class="track_content track_input">
									<input type="text" placeholder="트랙 형태를 입력하세요." class="input_code_info">
								</div>
							</div>
							<div class="item_content track_content">
								<div class="track_content track_number">2</div>
								<div class="track_content track_input">
									<input type="text" placeholder="트랙 형태를 입력하세요." class="input_code_info">
								</div>
							</div>
							<div class="item_content track_content">
								<div class="track_content track_number">3</div>
								<div class="track_content track_input">
									<input type="text" placeholder="트랙 형태를 입력하세요." class="input_code_info">
								</div>
							</div>
							<div class="item_content track_content">
								<div class="track_content track_number">4</div>
								<div class="track_content track_input">
									<input type="text" placeholder="트랙 형태를 입력하세요." class="input_code_info">
								</div>
							</div>
						</div> 
						<!-- 코드 정보 -->
						<div class="songInfo code_info">
							<div class="item_head code_inform_title">코드 정보</div>
							<!-- 코드 정보 상세: 마디 입력  -->
							<div class="item_content code_inform_content">
								<div class="code_inform_content bar">
									<div class="code_inform_content bar_head">1 마디</div>
									<div class="code_inform_content bar_input">
										<input type="text" placeholder="코드 정보를 입력하세요." class="input_code_info">
									</div>
								</div>
								<div class="code_inform_content bar">
									<div class="code_inform_content bar_head">2 마디</div>
									<div class="code_inform_content bar_input">
										<input type="text" placeholder="코드 정보를 입력하세요." class="input_code_info">
									</div>
								</div>
								<div class="code_inform_content bar">
									<div class="code_inform_content bar_head">3 마디</div>
									<div class="code_inform_content bar_input">
										<input type="text" placeholder="코드 정보를 입력하세요." class="input_code_info">
									</div>
								</div>
								<div class="code_inform_content bar">
									<div class="code_inform_content bar_head">4 마디</div>
									<div class="code_inform_content bar_input">
										<input type="text" placeholder="코드 정보를 입력하세요." class="input_code_info">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>		
			</div>
		</div>
	</div>
	<script src="/js/read/viewDetail/viewDetail.js"></script>
	<a id="topBtn" href="#">TOP</a>
</body>
</html>


