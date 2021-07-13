/**
 * 
 */

$(".songInfo_quantity_apply_button").click(function(){
	alert("설정 완료");
});

$(".save_button").click(function(){
	alert("저장 완료");
});
/*
//트랙 형태 입력창 추가
var trackCount = 1; 
$(".up_button_track").click(function(){
	trackCount++;
	let text="";
	text += "<div class = 'songInfo_add_box'>";
	text += "<div class = 'songInfo_add_item'>";
	text += "악기 " + trackCount;
	text += "</div>";
	text += "<input class = 'songInfo_add_input_button' placeholder='트랙 형태' />"
	text += "</div>";
	$(".songInfo_track_plus_box").append(text);
});
*/
var trackCount = 1; 
//class = "songInfo_quantity_input_button" 값 가져오기
var trackNumInput = $("#trackNumInput").val();
var codeNumInput = $("#codeNumInput").val();
//console.log(codeNumInput);
//console.log(trackCount);
//#trackNumInput placeholder 값 교체 작업
//$(".songInfo_quantity_apply_button").click(function(){
//	$("#trackNumInput").val(trackCount);
//	console.log(trackCount);
//	value 값을 trackNumInput 으로 변경
//});



//트랙 정보 입력창 숫자 입력 추가
$("#track_quantity_apply_button").click(function(){
	console.log(trackCount);
	console.log(trackNumInput);
	let inputNum = trackCount;
	let i = inputNum+trackNumInput;
	for(; i-1>inputNum; inputNum++ ){
		let text="";
		text += "<div id = track" + inputNum+1;
		text += " class = 'songInfo_add_box'> <div class = 'songInfo_add_item'>악기 ";
		text += inputNum+1 + "</div><input ";
		text += " class = 'songInfo_add_input_button' placeholder='트랙 형태' /></div>";
		$(".songInfo_track_plus_box").append(text);
		//$("#trackNumInput").val(trackCount);
	}
	
	
});


//트랙 정보 입력창 버튼 입력 추가

$(".up_button_track").click(function(){
	trackCount++;
	let text="";
	text += "<div id = track" + trackCount;
	text += " class = 'songInfo_add_box'> <div class = 'songInfo_add_item'>악기 ";
	text += trackCount + "</div><input ";
	text += " class = 'songInfo_add_input_button' placeholder='트랙 형태' /></div>";
	$(".songInfo_track_plus_box").append(text);
	$("#trackNumInput").val(trackCount);
});


//코드 정보 입력창 버튼 입력 추가
var codeCount = 1; 
$(".up_button_code").click(function(){
	codeCount++;
	let text="";
	text += "<div id = code" + codeCount;
	text += " class = 'songInfo_add_box'> <div class = 'songInfo_add_item'>마디 ";
	text += codeCount + "</div><input ";
	text += " class = 'songInfo_add_input_button' placeholder='코드 정보' /></div>";
	$(".songInfo_code_plus_box").append(text);
	$("#codeNumInput").val(codeCount);
});

//코드 정보 입력창 버튼 입력 삭제
$(".down_button_code").click(function(){
	if(codeCount>1){
		$("#code"+codeCount).remove();
		codeCount--;
		$("#codeNumInput").val(codeCount);
	}
	else{
		alert("코드 정보를 1개 이상 추가하세요");
	}
});

//트랙 형태 입력창 버튼 입력 삭제
$(".down_button_track").click(function(){
	if(trackCount>1){
		$("#track"+trackCount).remove();
		trackCount--;
		$("#trackNumInput").val(trackCount);
	}
	else{
		alert("트랙 형태를 1개 이상 추가하세요");
	}
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