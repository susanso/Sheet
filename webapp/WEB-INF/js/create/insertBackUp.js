var inst_li_DB;
var trackIdx;
var chord_4_reg = RegExp(/^([A-Za-z0-9\+\-]+[,]){3}[A-Za-z0-9\+\-]+$/)
var chord_8_reg = RegExp(/^([A-Za-z0-9\+\-]+[,]){7}[A-Za-z0-9\+\-]+$/)

//////////////// 트랙 정보 (악기 정보 입력) ////////////////
//트랙 개수 입력 
$('.trackNumButton').click(function() {
	$('.inst_container').children().remove();
	let trackNum = $('.trackNum').val();

	for (var i = 0; i < trackNum; i++) {
		let inst_info = '';
		//TODO toggle 버튼 누를때 v ^ 모양 변
		inst_info += '<div class = "Input">' +
			'<div class = "InputBar">' + (i + 1) + '트랙 악기</div>' +
			'<label for = "inst" style = "margin-left: 30px">' +
			'<input type = "text" class = "input_label inst inst' + i + '" id = "' + i + '">' +
			'<div class = "instListContainer contain' + i + '"></div>' +
			'</label>' +
			'<div class = "instToggle"' + 'value = "' + i + '">#</div>' +
			'<div>';

		$('.inst_container').append(inst_info);
	}

	// 악기 정보 가져와서 저장해줌 
	$.ajax({
		url: 'getInstList',
		type: 'GET',
		async: false,
		success: function(data) {
			inst_li_DB = data.instList;
		}
	});
});

//enter키로 트랙 개수 입력 
$('.trackNum').keyup(function(e) {
	if (e.keyCode == 13) {
		$('.inst_container').children().remove();
		let trackNum = $('.trackNum').val();

		for (var i = 0; i < trackNum; i++) {
			let inst_info = '';
			//TODO toggle 버튼 누를때 v ^ 모양 변
			inst_info += '<div class = "Input">' +
				'<div class = "InputBar">' + (i + 1) + '트랙 악기</div>' +
				'<label for = "inst" style = "margin-left: 30px">' +
				'<input type = "text" class = "input_label inst inst' + i + '" id = "' + i + '">' +
				'<div class = "instListContainer contain' + i + '"></div>' +
				'</label>' +
				'<div class = "instToggle"' + 'value = "' + i + '">#</div>' +
				'<div>';

			$('.inst_container').append(inst_info);
		}

		// 악기 정보 가져와서 저장해줌 
		$.ajax({
			url: 'getInstList',
			type: 'GET',
			async: false,
			success: function(data) {
				inst_li_DB = data.instList;
			}
		});

	}
});

// DB에서 가져온 악기 정보 toggle 
$(document).on(" click ", ".instToggle", function() {

	$('.instListContainer').children().remove();

	for (let i = 0; i < inst_li_DB.length; i++) {
		let inst_li = '<div class = "instOption"' + 'value = "' + i + '">' +
			inst_li_DB[i].instName +
			'</div>';

		trackIdx = $(this).attr('value');
		$('.contain' + trackIdx).append(inst_li);
	}
});

// 악기 toggle 옵션 선택시 input에 저장 
$(document).on(" click ", ".instOption", function() {
	let value = $(this).text();
	console.log(value, trackIdx);
	$('.inst' + trackIdx).val(value);
});

// 악기 검색 기능 
$(document).on("propertychange change keyup paste input", ".inst", function() {
	//이전의 토글 내용 삭제 
	$('.instListContainer').children().remove();

	//현재 인풋 확인해서 매칭되는 악기 리스트 생성
	newValue = $(this).val();

	//매칭되는 악기 이름 토글로 보여줌 
	for (let i = 0; i < inst_li_DB.length; i++) {
		if (newValue != '' && inst_li_DB[i].instName.includes(newValue)) {
			console.log(newValue);
			let inst_li = '<div class = "instOption"' + 'value = "' + i + '">' +
				inst_li_DB[i].instName +
				'</div>';

			trackIdx = $(this).attr('id');
			$('.contain' + trackIdx).append(inst_li);
		}
	}
});

//////////////////// 코드 정보 입력 ////////////////////
//마디 개수 입력
$('.measureNumButton').click(function() {
	$('.chord_container').children().remove();
	let measureNum = $('.measureNum').val();

	for (var i = 0; i < measureNum; i++) {
		let chord_info = '';
		chord_info += '<div class = "Input">' +
			'<div class = "InputBar">' + (i + 1) + '마디 코드</div>' +
			'<label for = "chord" style = "margin-left: 30px">' +
			'<input type = "text" class = "input_label chord chord' + i + '">' +
			'</label>' +
			'<div>';
		$('.chord_container').append(chord_info);
	}
});

//enter키로 마디 개수 입력
$('.measureNum').keyup(function(e) {
	if (e.keyCode == 13) {
		$('.chord_container').children().remove();
		let measureNum = $('.measureNum').val();

		for (var i = 0; i < measureNum; i++) {
			let chord_info = '';
			chord_info += '<div class = "Input">' +
				'<div class = "InputBar">' + (i + 1) + '마디 코드</div>' +
				'<label for = "chord" style = "margin-left: 30px">' +
				'<input type = "text" class = "input_label chord chord' + i + '">' +
				'</label>' +
				'<div>';
			$('.chord_container').append(chord_info);
		}
	}
});

// 최종 제출 버튼 클릭
$('.SongSubmitButton').click(function() {
	let songData;
	let inst_li;
	let chord_li;

	// 곡명 중복 확인
	if (songDupCheck() === false) {
		let txt = '이미 저장 된 곡입니다.'
		modal('alertBox', txt);
		$('.modalCloseBtn').click(function() {
			$('.alertBox').css('display', 'none');
		})
		return;
	}

	// song info 입력 체크 후 데이터 반환
	songData = songInputCheck();
	songStrData = JSON.stringify(songData);

	// 곡 정보 잘 입력 되었으면 트랙정보, 코드정보 확인 
	if (songData !== null) {
		// 트랙 정보 입력 확인
		inst_li = getInstList(songData.songId);
		if (emptyInputCheck("트랙 정보", inst_li) == false) {
			let txt = '입력되지 않은 트랙 정보가 있습니다.';
			modal('emptyInputAlertBox', txt);
			$('.modalCloseBtn').click(function() {
				$('.emptyInputAlertBox').css('display', 'none');
			})
			return;
		}
		inst_li = JSON.stringify(inst_li);

		// 코드 정보 입력 확인
		chord_li = getChordList(songData.songId);
		if (emptyInputCheck("코드 정보", chord_li) == false) {
			let txt = '입력되지 않은 코드 정보가 있습니다.';
			modal('emptyInputAlertBox', txt);
			$('.modalCloseBtn').click(function() {
				$('.emptyInputAlertBox').css('display', 'none');
			})
			return;
		}
		
		// 코드 정보 입력 형식 체크
		if (checkChordForm(chord_li) == false) {
			let txt = '코드 입력 형식이 올바르지 않습니다.';
			modal('alertBox', txt);
			$('.modalCloseBtn').click(function() {
				$('.alertBox').css('display', 'none');
			})
			return;
		}
		chord_li = JSON.stringify(chord_li);
	}

	// 곡 정보 빈칸 있으면 오류 알림
	else {
		let txt = '입력되지 않은 곡 정보가 있습니다.'
		
		modal('emptyInputAlertBox', txt);
		$('.modalCloseBtn').click(function() {
			$('.emptyInputAlertBox').css('display', 'none');
		})
		
		return;
	}

	$.ajax({
		url: '/insertSong.do',
		type: 'POST',
		data: { 'songData': songStrData, 'inst_li': inst_li, 'chord_li': chord_li },
		success: function(data) {
			console.log(data);
			console.log("입력 완료");
		}
	});
	alert("입력 완료!!");
	console.log(songData.songId);
	let url = "/edit?songId=" + songData.songId;
	popUp(url);
});

//코드 입력 형식 체크 ㅁ,ㅁ,ㅁ,ㅁ 
function checkChordForm(chord_li) {
	console.log("여기");
	for (let i=0; i < chord_li.length; i++) {
		console.log(chord_li[i].measureNum, chord_li[i].chord);
		if(!chord_4_reg.test(chord_li[i].chord) && !chord_8_reg.test(chord_li[i].chord)){
			console.log("코드 입력 형식 에러");
			return false;
		}
		else {
			console.log("코드 입력 형식 올바름!");
		}
	}
	return true;
}

//곡명 중복 확인 
function songDupCheck() {
	let songName = $(".song_name").val();
	let result;

	$.ajax({
		url: 'checkSongName',
		type: 'POST',
		async: false,
		data: { songName: songName },
		success: function(data) {
			result = data.result;
		}
	});
	return result;
}

//곡 정보 입력 확인(빈칸)
function songInputCheck() {
	let song_name = $(".song_name").val();
	let artist = $(".artist").val();
	let producer_name = $(".producer_name").val();
	let genre = $(".genre").val();
	let key = $(".key").val();
	let bpm = $(".bpm").val();
	let song_form = $(".song_form").val();
	let beat = $(".beat").val();

	let songData = { 'songName': song_name, 'artist': artist, 'producerName': producer_name, 'genre': genre, 'keyName': key, 'bpm': bpm, 'songForm': song_form, 'beat': beat };
	if (emptyInputCheck("곡 정보", [songData]) === false) {
		return null;
	}
	songData.songId = createSongId();
	return songData;
}

//입력 정보 확인(빈칸)
function emptyInputCheck(where, data) {
	for (let i = 0; i < data.length; i++) {
		for (var key in data[i]) {
			if (data[i][key] === "") {
				console.log("!!empty input!! : " + where + " - " + key);
				return false;
			}
		}
	}
}

//songId 생
function createSongId() {
	return Math.floor(Math.random() * 10000);
}

//트랙 정보 읽어오기 
function getInstList(songId) {
	let trackNum = $('.trackNum').val();

	let inst_li = [];
	for (var i = 0; i < trackNum; i++) {
		tmp = { 'songId': songId, 'trackNum': (String)(i + 1), 'instName': $('.inst' + i).val() };
		inst_li.push(tmp);
	}
	return inst_li;
}

//코드 정보 읽어오
function getChordList(songId) {
	let measureNum = $('.measureNum').val();

	let chord_li = [];
	for (var i = 0; i < measureNum; i++) {
		tmp = { 'songId': songId, 'measureNum': (String)(i + 1), 'chord': $('.chord' + i).val() };
		chord_li.push(tmp);
	}

	return chord_li;
}

function modal(className, text) {
	var modal = $('.' + className);

	modal.children(".alertTxt").empty();
	modal.children(".alertTxt").text(text);

	modal
		.css({
			position: 'fixed',
			top: '5%',
			left: '50%',
			transform: 'translate(-50%, -50%)',
			msTransform: 'translate(-50%, -50%)',
			webkitTransform: 'translate(-50%, -50%)'
		})
		.show()
}

// 팝업 창 설정 메서드
function popUp(url) {
	
	// 팝업 창 크기 설정
	let popupWidth = 900;
	let popupHeight = 200;
	
	// 현재 브라우저 기준 가운데 출력
	let popupX = (document.body.offsetWidth / 2) - (popupWidth / 2);
	let popupY = (document.body.offsetHeight / 2) - (popupHeight / 2);

	window.open(url, "_blank", "width=" + popupWidth + "px," + "height=" + popupHeight + "px,left=" + popupX + ",top=" + popupY);
}