<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/create/insertPage.css">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class = "page">
	
	
		<div class = "header_container"> 
			<div class = "header_box">Upvote Sheet Test Page</div>
		</div>
		<div class = "main_container">
			<div class = "titleInfo_container">
				<div class = "titleInfo_box">
					<div class = "titleInfo_name_item"> 작성자 </div>
					<div class = "titleInfo_button_box">
						<input class = "titleInfo_button button_name" placeholder="작업자 이름" />
					</div>
				</div>
				<div class = "titleInfo_line"></div>
				<div class = "titleInfo_box">
					<div class = "titleInfo_name_item"> 타이틀 </div>
					<div class = "titleInfo_button_box">
						<input class = "titleInfo_button button_title" placeholder="제목" />
						<input class = "titleInfo_button button_artist" placeholder="가수명" />
						<input class = "titleInfo_button button_genre" placeholder="장르" />
					</div>
				</div>
				<div class = "titleInfo_line"></div>
				<div class = "titleInfo_box">
					<div class = "titleInfo_name_item"> 키/ 송폼 </div>
					<div class = "titleInfo_button_box_two">
						<input class = "titleInfo_button button_key" placeholder="키" />
						<input class = "titleInfo_button button_songform" placeholder="송폼" />
					</div>
				</div>
				<div class = "titleInfo_box">
					<div class = "titleInfo_name_item"> 박자/ BPM </div>
					<div class = "titleInfo_button_box">
						<input class = "titleInfo_button button_beat" placeholder="박자" />
						<input class = "titleInfo_button button_bpm" placeholder="BPM" />
					</div>
				</div>
			</div>
			
			<div class = "songInfo_container">
				<div class = "songInfo_box track_box">
					<div class = "songInfo_name_item"> 트랙 형태 </div>
					<div class = "songInfo_quantity_box">	
						<div class = "songInfo_quantity_name_item"> 악기 수 </div>
						<input class = "songInfo_quantity_input_button" id = "trackNumInput" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value = "1"/> <!-- 악기 숫자 입력하는 부분 -->
						<div class = "songInfo_quantity_updown_button_box">
							<div class = "songInfo_quantity_updown_button up_button_track"> +</div>
							<div class = "songInfo_quantity_updown_button down_button_track"> -</div>
						</div>
						<input class = "songInfo_quantity_apply_button" id = "track_quantity_apply_button" type="button" value="설정" />
					</div>
					<div class = "songInfo_track_add_box track_add_box1">
						<div class = "songInfo_add_item"> 악기 1 </div>
						<input class = "songInfo_add_input_button track_value" id = "track1"  placeholder="트랙 형태" />
					</div>
					<div class = "songInfo_track_plus_box"></div>
				</div>
				
				
				<div class = "songInfo_box code_box">
					<div class = "songInfo_name_item"> 코드 정보 </div>
					<div class = "songInfo_quantity_box">	
						<div class = "songInfo_quantity_name_item"> 마디 수 </div>
						<input class = "songInfo_quantity_input_button" id = "codeNumInput" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value = "1"/> <!-- 악기 숫자 입력하는 부분 -->
						<div class = "songInfo_quantity_updown_button_box">
							<div class = "songInfo_quantity_updown_button up_button_code"> +</div>
							<div class = "songInfo_quantity_updown_button down_button_code"> -</div>
						</div>
						<input class = "songInfo_quantity_apply_button" id = "code_quantity_apply_button" type="button" value="설정" />
					</div>
					<div class = "songInfo_code_add_box code_add_box1">
						<div class = "songInfo_add_item"> 마디 1 </div>
						<input class = "songInfo_add_input_button" id = "code1" placeholder="코드 정보" />
					</div>
					<div class = "songInfo_code_plus_box"></div>
				</div>
			</div>
			<div class = "save_button_container">
				<input class = "save_button" type="button" value="저장하기" />
			</div>
		</div>
	</div>
	
	
	
	<script src="/js/create/insertPage.js"></script>
	
	
	
	
	
	
	
	
	
	
</body>
</html>