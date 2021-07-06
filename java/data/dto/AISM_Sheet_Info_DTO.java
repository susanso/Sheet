package data.dto;

import java.sql.Timestamp;

public class AISM_Sheet_Info_DTO {
	
	private Timestamp currtime;
	private String songName;
	private String artist;
	private String producerName;
	private String genre;
	private String keyName;
	private String bpm;
	private String songForm;
	private String beat;
	
	private String songNameInst;
	private int trackNum;
	private String instName;
	
	private String songNameChord;
	private int measureNum;
	private String chord;
	
	
	public AISM_Sheet_Info_DTO() {
		// TODO Auto-generated constructor stub
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String key) {
		this.keyName = key;
	}

	public String getBpm() {
		return bpm;
	}

	public void setBpm(String bpm) {
		this.bpm = bpm;
	}

	public String getSongForm() {
		return songForm;
	}

	public void setSongForm(String songForm) {
		this.songForm = songForm;
	}

	public String getBeat() {
		return beat;
	}

	public void setBeat(String beat) {
		this.beat = beat;
	}

	public Timestamp getCurrtime() {
		return currtime;
	}

	public String getSongNameInst() {
		return songNameInst;
	}

	public void setSongNameInst(String songNameInst) {
		this.songNameInst = songNameInst;
	}

	public int getTrackNum() {
		return trackNum;
	}

	public void setTrackNum(int trackNum) {
		this.trackNum = trackNum;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getSongNameChord() {
		return songNameChord;
	}

	public void setSongMameChord(String songNameChord) {
		this.songNameChord = songNameChord;
	}

	public int getMeasureNum() {
		return measureNum;
	}

	public void setMeasureNum(int measureNum) {
		this.measureNum = measureNum;
	}

	public String getChord() {
		return chord;
	}

	public void setChord(String chord) {
		this.chord = chord;
	}
	
	
}