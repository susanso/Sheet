/**
 * 
 */

var trackCount = 1; 
var codeCount = 1; 




/*

---------------------------------------------------------------------------------
//document.getElementById("dn").value; 로 가져온다 (1)

//트랙 정보 입력창 숫자 입력 추가
$("#track_quantity_apply_button").click(function(){
	console.log(trackCount);
	console.log(trackNumInput );
	let trackNum = trackCount;
	let i = trackNum+trackNumInput;
	for(; i-1>trackNum; trackNum++ ){
		let text="";
		text += "<div id = track" + trackNum+1;
		text += " class = 'songInfo_add_box'> <div class = 'songInfo_add_item'>악기 ";
		text += trackNum+1 + "</div><input ";
		text += " class = 'songInfo_add_input_button' placeholder='트랙 형태' /></div>";
		$(".songInfo_track_plus_box").append(text);
		//$("#trackNumInput").val(trackCount);
	}
});

*/


//코드 정보 입력창 숫자 입력 추가 

$("#code_quantity_apply_button").click(function(){
	$(".songInfo_code_add_box").remove();
	codeCount = $("#codeNumInput").val();
	for(let i = 0; i < codeCount; i++ ){
		let text="";
		text += "<div id = code_add_box" + (i+1);
		text += " class = 'songInfo_code_add_box'> <div class = 'songInfo_add_item'>마디 ";
		text += (i+1) + "</div><input ";
		text += " class = songInfo_add_input_button id= code" + codeCount;
		text += " placeholder='코드 정보' /></div>";
		$(".songInfo_code_plus_box").append(text);
	}
});

//트랙 정보 입력창 숫자 입력 추가
$("#track_quantity_apply_button").click(function(){
	$(".songInfo_track_add_box").remove();
	trackCount = $("#trackNumInput").val();
	for(let i = 0; i < trackCount; i++ ){
		let text="";
		text += "<div id = track_add_box" + (i+1);
		text += " class = 'songInfo_track_add_box'> <div class = 'songInfo_add_item'>악기 ";
		text += (i+1) + "</div><input ";
		text += " class = songInfo_add_input_button id = track"+ trackCount;
		text += " placeholder='트랙 형태' /></div>";
		$(".songInfo_track_plus_box").append(text);
	}
});



//트랙 정보 입력창 버튼 입력 추가

$(".up_button_track").click(function(){
	trackCount++;
	let text="";
	text += "<div id = track_add_box" + trackCount;
	text += " class = 'songInfo_track_add_box'> <div class = 'songInfo_add_item'>악기 ";
	text += trackCount + "</div><input ";
	text += " class = songInfo_add_input_button id = track"+ trackCount;
	text += " placeholder='트랙 형태' /></div>";
	$(".songInfo_track_plus_box").append(text);
	$("#trackNumInput").val(trackCount);
});


//코드 정보 입력창 버튼 입력 추가

$(".up_button_code").click(function(){
	codeCount++;
	let text="";
	text += "<div id = code_add_box" + codeCount;
	text += " class = 'songInfo_code_add_box'> <div class = 'songInfo_add_item'>마디 ";
	text += codeCount + "</div><input ";
	text += " class = songInfo_add_input_button id= code" + codeCount;
	text += " placeholder = '코드 정보' /></div>";
	$(".songInfo_code_plus_box").append(text);
	$("#codeNumInput").val(codeCount);
});

//코드 정보 입력창 버튼 입력 삭제
$(".down_button_code").click(function(){
	if(codeCount>1){
		$("#code_add_box"+codeCount).remove();
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
		$("#track_add_box"+trackCount).remove();
		trackCount--;
		$("#trackNumInput").val(trackCount);
	}
	else{
		alert("트랙 형태를 1개 이상 추가하세요");
	}
});
//---------------------------------------------------------------------------------
$(document).ready(function(){
	$(".save_button").click(function(){
		if($(".button_name").val().length==0){alert("작업자 이름을 입력하세요.");$(".button_nmae").focus(); return false;}
		if($(".button_title").val().length==0){alert("제목을 입력하세요.");$(".button_title").focus(); return false;}
		if($(".button_artist").val().length==0){alert("가수명을 입력하세요.");$(".button_artist").focus(); return false;}
		if($(".button_genre").val().length==0){alert("장르를 입력하세요.");$(".button_genre").focus(); return false;}
		if($(".button_key").val().length==0){alert("키를 입력하세요.");$(".button_key").focus(); return false;}
		if($(".button_songform").val().length==0){alert("송폼을 입력하세요.");$(".button_songform").focus(); return false;}
		if($(".button_beat").val().length==0){alert("박자를 입력하세요.");$(".button_beat").focus(); return false;}
		if($(".button_bpm").val().length==0){alert("BPM을 입력하세요.");$(".button_bpm").focus(); return false;}
//		let trackCheck=1;
//		let codeCheck=1;
//		while(trackCheck<(trackCount+1)){
//			if($("#track"+trackCount).val().length==0){alert("트랙 형태를 입력하세요");$("#track"+trackCount).focus(); return false;}
//			trackCheck++;
//		}
//		while(codeCheck<(codeCount+1)){
//			if($("#code"+codeCount).val().length==0){alert("코드 정보를 입력하세요");$("#code"+codeCount).focus(); return false;}
//			codeCheck++;
//		}
		
		for(let i=1; i<(trackCount+1); i++){
			if($("#track"+trackCount).val().length==0){alert("트랙 형태를 입력하세요");$("#track"+trackCount).focus(); return false;}
		}
		for(let i=1; i<(trackCount+1); i++){
			if($("#code"+codeCount).val().length==0){alert("코드 정보를 입력하세요");$("#code"+codeCount).focus(); return false;}
		}

	});
});



