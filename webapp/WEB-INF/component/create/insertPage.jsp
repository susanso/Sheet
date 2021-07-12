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
			<div class = "section_box">
				<div class = "name_item"> 작성자 </div>
				<div class = "input_box_one">
					<input class = "sheet_button button_1" placeholder="작업자 이름" />
				</div>
			</div>
			<div class = "line"></div>
			<div class = "section_box">
				<div class = "name_item"> 타이틀 </div>
				<div class = "input_box_three">
					<input class = "sheet_button" placeholder="제목" />
					<input class = "sheet_button" placeholder="가수명" />
					<input class = "sheet_button" placeholder="장르" />
				</div>
			</div>
			<div class = "line"></div>
			<div class = "section_box">
				<div class = "name_item"> 키/ 송폼 </div>
				<div class = "input_box_two">
					<input class = "sheet_button" placeholder="키" />
					<input class = "sheet_button" placeholder="송폼" />
				</div>
			</div>
			<div class = "section_box">
				<div class = "name_item"> 박자/ BPM </div>
				<div class = "input_box_two">
					<input class = "sheet_button" placeholder="박자" />
					<input class = "sheet_button" placeholder="BPM" />
				</div>
			</div>
			
			
			<div class = "section_box2">
				<div class = "colomn_box">
					<div class = "name_item second_item"> 트랙 형태 </div>
					<div class = "button_box">	
						<div class = "name_item second_item"> 악기 수 </div>
						<input class = "plus_button" placeholder = "1"/> <!-- 악기 숫자 입력하는 부분 -->
						<div class = "plus_button_box">
							<input class = "updown_button up_button_track" type="button" value="+" />
							<input class = "updown_button" type="button" value="-" />
						</div>
						<input class = "apply_button" type="button" value="적용" />
					</div>
					<div class = "section_box">
						<div class = "colomn_item"> 악기 1 </div>
						<input class = "sheet_button" placeholder="트랙 형태" />
					</div>
					<div class = "track_section"></div>
				</div>
				
				
				<div class = "colomn_box">
					<div class = "name_item second_item"> 코드 정보 </div>
					<div class = "button_box">	
						<div class = "colomn_item"> 마디 수 </div>
						<input class = "plus_button" placeholder = "1"/> <!-- 악기 숫자 입력하는 부분 -->
						<div class = "plus_button_box">
							<input class = "updown_button up_button_code" type="button" value="+" />
							<input class = "updown_button down_button" type="button" value="-" />
						</div>
						<input class = "apply_button" type="button" value="적용" />
					</div>
					<div class = "section_box">
						<div class = "colomn_item"> 마디 1 </div>
						<input class = "sheet_button" placeholder="코드 정보" />
					</div>
					<div class = "code_section"></div>
				</div>
			</div>
			<div class = "section_box apply_section">
				<input class = "apply_button" type="button" value="저장하기" />
			</div>
		</div>
	</div>
	
	
	
	<script src="/js/create/insertPage.js"></script>
	
	
	
	
	
	
	
	
	
	
</body>
</html>