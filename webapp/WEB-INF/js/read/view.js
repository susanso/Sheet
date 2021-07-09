let songName = '';
let artist = '';
let songForm = '';
let producerName = '';
let genre = '';
let keyName = '';
let beat = '';
let userId = '';
let songId = '';
let bpm = '';
let track = '';
let chordInfo = '';

$.ajax ({
	url : "/show/allSong", 
	type: "GET",
	success : function(data) {
		let song_li = data.songList;
		
		for (var song of song_li) {		
			for (var key in song) {
				if (key == 'producerName') producerName = song[key];
				else if (key == 'songName') songName = song[key];
				else if (key == 'artist') artist = song[key];
				else if (key == 'genre') genre = song[key];
				else if (key == 'keyName') keyName = song[key];
				else if (key == 'track') track = '트랙 형태'; 
				else if (key == 'songForm') songForm = song[key];
				else if (key == 'chordInfo') chordInfo = '코드 정보';
			}
			
			let dataColumn = '';
			dataColumn += '<div class = "tableDataBox">' + 
								'<div class = "column checkBox">' +
									'<input type = "checkbox" name = "check">' + 
								'</div>' + 
							'<div class = "column pdname">' + producerName + '</div>' + 
							'<div class = "column song">' + songName + '</div>' + 
							'<div class = "column artist">' + artist + '</div>' + 
							'<div class = "column genre">' + genre + '</div>' + 
							'<div class = "column key">' + keyName + '</div>' + 
							'<div class = "column songform">' + songForm + '</div>' + 
							'<div class = "column track">' + track + '</div>' + 
							'<div class = "column chordInfo">' + chordInfo + '</div>' + 
					  	  '</div>';

			$('.dataColumnContainer').append(dataColumn);
		}
	}
});