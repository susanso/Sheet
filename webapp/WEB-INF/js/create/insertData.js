$('.trackNumButton').click(function() {
	let trackNum = $('.trackNum').val();

	for (var i = 0; i < trackNum; i++) {
		let inst_info = '';
		inst_info += '<div class = "Input">' +
			'<div class = "InputBar">악기 이름</div>' +
			'<label for = "inst" style = "margin-left: 30px">' +
			'<input type = "text" class = "input_label inst inst' + i + '">' +
			'</label>' +
			'<div>';

		$('.inst_container').append(inst_info);
	}

	$('.trackNumButton').css('display', 'none');
	$('.InstInfoButton').css('display', 'flex');

});

$('.measureNumButton').click(function() {
	let measureNum = $('.measureNum').val();

	for (var i = 0; i < measureNum; i++) {
		let chord_info = '';
		chord_info += '<div class = "Input">' +
			'<div class = "InputBar">코드 정보</div>' +
			'<label for = "chord" style = "margin-left: 30px">' +
			'<input type = "text" class = "input_label chord chord' + i + '">' +
			'</label>' +
			'<div>';

		$('.chord_container').append(chord_info);
	}

	$('.measureNumButton').css('display', 'none');
	$('.ChordInfoButton').css('display', 'flex');
});

$('.SongInfoButton').click(function() {
	let song_name = $(".song_name").val();
	let artist = $(".artist").val();
	let producer_name = $(".producer_name").val();
	let genre = $(".genre").val();
	let key = $(".key").val();
	let bpm = $(".bpm").val();
	let song_form = $(".song_form").val();
	let beat = $(".beat").val();
	let songId = uuidv4();

	let data = { 'songId': songId, 'songName': song_name, 'artist': artist, 'producerName': producer_name, 'genre': genre, 'keyName': key, 'bpm': bpm, 'songForm': song_form, 'beat': beat };
	console.log(data);
	/*
	$.ajax({
		url: '/insert/insertSongInfo',
		type: 'GET',
		data:{'songName':song_name, 'artist':artist, 'producerName':producer_name, 'genre':genre, 'keyName':key, 'bpm':bpm, 'songForm':song_form, 'beat':beat},
		success: function(data) {
			console.log(data);
			console.log("입력 완료");
		}
	});
	*/
});

$('.InstInfoButton').click(function() {
	let trackNum = $('.trackNum').val();

	let inst_li = [];
	for (var i = 0; i < trackNum; i++) {
		inst_li.push($('.inst' + i).val());
	}

	console.log(inst_li);
});

$('.ChordInfoButton').click(function() {
	let measureNum = $('.measureNum').val();

	let chord_li = [];
	for (var i = 0; i < measureNum; i++) {
		chord_li.push($('.chord' + i).val());
	}

	console.log(chord_li);
});

$('.SongSubmitButton').click(function() {
	let song_name = $(".song_name").val();
	let artist = $(".artist").val();
	let producer_name = $(".producer_name").val();
	let genre = $(".genre").val();
	let key = $(".key").val();
	let bpm = $(".bpm").val();
	let song_form = $(".song_form").val();
	let beat = $(".beat").val();
	let songId = uuidv4();

	let songData = {'songId': songId, 'songName': song_name, 'artist': artist, 'producerName': producer_name, 'genre': genre, 'keyName': key, 'bpm': bpm, 'songForm': song_form, 'beat': beat };
	songData = JSON.stringify(songData);
	
	let inst_li = getInstList(songId);
	inst_li = JSON.stringify(inst_li);

	let chord_li = getChordList(songId);
	chord_li = JSON.stringify(chord_li);
	
	$.ajax({
		url: '/insertSong.do',
		type: 'POST',
		data: {'songData':songData, 'inst_li':inst_li, 'chord_li':chord_li},
		//contentType: "text/plain",
		success: function(data) {
			console.log(data);
			console.log("입력 완료");
		}
	});
	
});

function uuidv4() {
	return Math.floor(Math.random() * 10000);
	/*
	return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
		return v.toString(16);
	});
	*/
}

function getInstList(songId) {
	let trackNum = $('.trackNum').val();

	let inst_li = [];
	for (var i = 0; i < trackNum; i++) {
		tmp = { 'songId': songId, 'trackNum': i + 1, 'instName': $('.inst' + i).val() };
		inst_li.push(tmp);
	}
	return inst_li;
}

function getChordList(songId) {
	let measureNum = $('.measureNum').val();

	let chord_li = [];
	for (var i = 0; i < measureNum; i++) {
		tmp = { 'songId': songId, 'measureNum': i + 1, 'chord': $('.chord' + i).val() };
		chord_li.push(tmp);
	}

	return chord_li;
}