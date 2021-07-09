/**
 * 
 */

$(".apply_button").click(function(){
	alert("적용 완료");
});

var codeCount = 1; //코드 정보 입력창 추가
$(".up_button_code").click(function(){
	codeCount++;
	let text="";
	text += "<div class = 'add_code'>";
	text += "<div class = 'colomn_item'>";
	text += "마디 " + codeCount;
	text += "</div>";
	text += "<input class = 'sheet_button' placeholder='코드 정보' />"
	text += "</div>";
	$(".code_section").append(text);
});
var trackCount = 1; //트랙 형태 입력창 추가
$(".up_button_track").click(function(){
	trackCount++;
	let text="";
	text += "<div class = 'add_code'>";
	text += "<div class = 'colomn_item'>";
	text += "악기 " + trackCount;
	text += "</div>";
	text += "<input class = 'sheet_button' placeholder='트랙 형태' />"
	text += "</div>";
	$(".track_section").append(text);
});



/*
var count = 1;
$(".up_button_code").click(function(){
	count++;
	let text="";
	$("<div class = 'add_code'>").append("<div class = 'colomn_item'>마디 " + count+"</div><input class = 'sheet_button' placeholder='코드 정보' /></div>");
	
	
});
*/

/*
var count = 1;
$(".up_button_code").click(function(){
	count++;
	let text="";
	$("<div class = 'add_code'>").append("<div class = 'colomn_item'>마디 " + count+"</div><input class = 'sheet_button' placeholder='코드 정보' /></div>");
	
	
});
*/