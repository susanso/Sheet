package data.service;

import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;

import data.dto.AISM_Sheet_Chord_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Song_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;

public interface AISM_Sheet_Info_ServiceInter {
	//song list 입력
	//public void insertSongList(String jsonData) throws ParseException;
	
	//song info 입력 
	public void insertSongInfo(AISM_Sheet_Song_Info_DTO sdto);
	//inst info 입력 
	public void insertInstInfo(AISM_Sheet_Inst_Info_DTO idto);
	//chord info 입력 
	public void insertChordInfo(AISM_Sheet_Chord_Info_DTO cdto);
	
	//모든 song 가져오기
	public List<AISM_Sheet_Song_List_DTO> allSongList();

	//모든 악기 가져오기
	public List<String> getInstList();
	
	//곡명 중복 확인	
	public boolean validSongName(String songName);

	
	// 코드 정보 가져오기
	public List<AISM_Sheet_Inst_Info_DTO> getInstInfo(String songID);
	
	// 트랙 정보 가져오기
	public List<AISM_Sheet_Chord_Info_DTO> getChordInfo(String songID);
  
	//producer의 모든 song 가져오기
	public List<AISM_Sheet_Song_List_DTO> pdSongList(String producerName);
	
	//1개 song 가져오기
	//public List<AISM_Sheet_Info_DTO> oneSongInfo();
}