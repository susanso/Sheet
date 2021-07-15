<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<!-- favicon -->
<link rel="apple-touch-icon" href="../image/favicon/favicon_ipad.png"
	type="image/png" />
<link rel="shortcut icon" href="../image/favicon/favicon_pc.png"
	type="image/png">
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
	href="/css/read/viewDetail/viewDetail.css">
<title>${songInfo.songName} -  ${songInfo.artist}</title>
</head>
<body onload = "windowResize();" style="color: rgb(242, 242, 243);">
	<!-- 카드 부분 시작 -->
	<!-- 모든 카드를 감싸는 부분 -->
	<form action="/updateSong.do" method="post" style = "margin: 0; padding: 0;">
		<div class="all_cards_container">
			<!-- 카드 한 개당 컨테이너 하나로 감쌈 -->
			<div class="card_container" id = "${songInfo.songId}">
				<!-- 카드 헤드 부분 -->
				<div class="card_head">
					<div class = "card_head_front"></div>
					<div class="card_head_title">
						<input type="text" class="update_input song_title" value="${songInfo.songName}" disabled>
						<input type="text" class="update_input song_artist" value="${songInfo.artist}" disabled>
					</div>
					<div class="card_head_buttons">
						<c:if test = "${isQualified == true}">
							<div class="button edit_button">수정</div>
							<div class="button save_button" style = "display: none;">저장</div>
							<!-- <button type = "submit" class="button save_button" style = "display: none;">저장</button> -->
							<div class="button delete_button">삭제</div>
						</c:if>
					</div>
				</div>
				<!-- 카드 내용 부분 -->
				<div class="card_content_purple_background">
					<div class="card_content_gray_background">
						<!-- 작업 담당자, 작업자 이름 -->
						<div class="card_content_writer">
							<div class="writer">작업 담당자</div>
							<div class="writer_name">${songInfo.producerName}</div>
						</div>
						<!-- 곡 정보 : 장르, 키, BPM, 송폼 넘버링 -->
						<div class="card_content_song_info">
							<!-- 장르 -->
							<div class="songInfo">
								<div class="item_head">장르</div>
								<input type="text" class="update_input item_content genre" value = "${songInfo.genre}" disabled>
							</div>
							<!-- 키 -->
							<div class="songInfo">
								<div class="item_head">키</div>
								<input type="text" class="update_input item_content keyName" value = "${songInfo.keyName}" disabled>
							</div>
							<!-- BPM / 박자 -->
							<div class="songInfo BPM_beat">
								<div class="item_head">BPM / 박자</div>
								<div class="update_input bpm_beat">
									<input type="text" class="update_input item_content" value = "${songInfo.bpm}" disabled>
									<input type="text" class="update_input item_content" value = "${songInfo.beat}" disabled> <!-- 박자 이름 여쭤보기 -->
								</div>

							</div>
							<!-- 송폼 넘버링 -->
							<div class="songInfo">
								<div class="item_head">송폼 넘버링</div>
								<input type="text" class="update_input item_content songForm" value = "${songInfo.songForm}" disabled>
							</div>
							<!-- 박자  -->
							<div class="songInfo">
								<div class="item_head">beat</div>
								<input type="text" class="update_input item_content beat" value = "${songInfo.beat}" disabled>
							</div>
						</div>
						<!-- 곡 정보 : 트랙 형태, 코드 정보 -->
						<div class="card_content_song_info">
							<!-- 트랙 형태 -->
							<div class="songInfo track">
								<div class="item_head track_title" id = "${fn:length(instInfo)}">트랙 형태</div>
								<c:forEach var="inst" items="${instInfo}" varStatus="trackIndex">
									<div class="item_content track_content">
										<div class="track_content track_number">Track ${inst.trackNum}</div>
										<div class="track_content track_input">
											<input type="text" class="update_input input_track_info" id = "inst${inst.trackNum}"
											value = "${inst.instName}" disabled>
										</div>
									</div>
								</c:forEach>
							</div>
							<!-- 코드 정보 -->
							<div class="songInfo code_info">
								<div class="item_head code_inform_title" id = "${fn:length(chordInfo)}">코드 정보</div>
								<!-- 코드 정보 상세: 마디 입력  -->
								<div class="item_content code_inform_content">
									<c:forEach var="chord" items="${chordInfo}" varStatus="chordIndex">
										<div class="code_inform_content bar">
											<div class="code_inform_content bar_head">${chord.measureNum} 마디</div>
											<div class="code_inform_content bar_input">
												<input type="text" class="update_input input_code_info" id = "chord${chord.measureNum}"
												value = "${chord.chord}" disabled>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script src="/js/read/viewDetail/viewDetail.js"></script>
</body>
</html>


