
// 수정 버튼 누름 
$(".edit_button").click(function() {
	$(".update_input").prop('disabled', false);
	$(this).css('display', 'none');
	$(".save_button").css('display', 'flex');
});

// 저장 버튼 누르면 update
$(".save_button").click(function() {
	$(".update_input").prop('disabled', true);
	$(this).css('display', 'none');
	$(".edit_button").css('display', 'flex');

	let songId = $(".card_container").attr('id');
	let songName = $(".song_title").val();
	let artist = $(".song_artist").val();
	let producerName = $(".writer_name").text();
	let genre = $(".genre").val();
	let keyName = $(".keyName").val();
	let bpm = $(".bpm").val();
	let songForm = $(".songForm").val();
	let beat = "4/4"//$(".beat").val();

	let songData = {
		'songId': songId, 'songName': songName, 'artist': artist, 'producerName': producerName, 'genre': genre,
		'keyName': keyName, 'bpm': bpm, 'songForm': songForm, 'beat': beat
	}

	let inst_li = getInstList(songId);
	let chord_li = getChordList(songId);

	songData = JSON.stringify(songData);
	inst_li = JSON.stringify(inst_li);
	chord_li = JSON.stringify(chord_li);

	$.ajax({
		url: '/updateSong.do',
		type: 'POST',
		data: { 'songData': songData, 'inst_li': inst_li, 'chord_li': chord_li },
		success: function(data) {
			console.log(data);
			console.log("입력 완료");
		}
	});
	alert("수정 완료!");
	window.close();
	location.href = "/view";
});

// 삭제 버튼 
$(".delete_button").click(function() {
	var delConfirm = confirm($(".song_title").val() + '을 정말 삭제 하시겠습니까??');
	console.log(delConfirm);

	if (delConfirm) {
		let songId = $(".card_container").attr('id');
		$.ajax({
			url: '/deleteSong.do',
			type: 'GET',
			data: { 'songId': songId },
			success: function(data) {
			}
		});
		alert("삭제 완료!");
		window.close();
	}
});

// top 이동 버튼
$(function() {
	// 보이기 | 숨기기
	$(window).scroll(function() {
		if ($(this).scrollTop() > 250) { //250 넘으면 버튼이 보여짐니다.
			$('#topBtn').fadeIn();
		} else {
			$('#topBtn').fadeOut();
		}
	});
	// 버튼 클릭시
	$("#topBtn").click(function() {
		$('html, body').animate({
			scrollTop: 0    // 0 까지 animation 이동합니다.
		}, 400);          // 속도 400
		return false;
	});
});

// Window 크기 다시 지정
function windowResize() {
	// width는 동일 height만 다시 지정 
	let height = $('.all_cards_container').height();
  window.resizeTo(900, height + 57); // 48 = url + title bar
}

//트랙 정보 읽어오기 
function getInstList(songId) {
	//트랙 개수 
	let trackNum = $(".track_title").attr('id')

	let inst_li = [];
	for (var i = 0; i < trackNum; i++) {
		tmp = { 'songId': songId, 'trackNum': (String)(i + 1), 'instName': $('#inst' + (i + 1)).val() };
		inst_li.push(tmp);
	}
	return inst_li;
}

//코드 정보 읽어오
function getChordList(songId) {
	// 마디 개수 
	let measureNum = $(".code_inform_title").attr('id')

	let chord_li = [];
	for (var i = 0; i < measureNum; i++) {
		tmp = { 'songId': songId, 'measureNum': (String)(i + 1), 'chord': $('#chord' + (i + 1)).val() };
		chord_li.push(tmp);
	}

	return chord_li;
}