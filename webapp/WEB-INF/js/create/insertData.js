$('.trackNumButton').click(function() {
	let trackNum = $('.trackNum').val();
	
	for (var i = 0; i < trackNum; i++) {
		let inst_info = '';
		inst_info += '<div class = "Input">' +
						'<div class = "InputBar">악기 이름</div>'+
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
						'<div class = "InputBar">코드 정보</div>'+
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
	
	console.log('================ song info table ==============');
	console.log(song_name);
	console.log(artist);
	console.log(producer_name);
	console.log(genre);
	console.log(key);
	console.log(bpm);
	console.log(song_form);
	console.log(beat);
	console.log('===============================================');
	
	$.ajax({
		url: '/insert/insertSongInfo',
		type: 'GET',
		data:{'songName':song_name, 'artist':artist, 'producerName':producer_name, 'genre':genre, 'keyName':key, 'bpm':bpm, 'songForm':song_form, 'beat':beat},
		success: function(data) {
			console.log(data);
			console.log("입력 완료");
		}
	});
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