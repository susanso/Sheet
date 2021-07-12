package data.dao;


import java.util.List;

import data.dto.AISM_Sheet_Chord_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Song_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;

public interface AISM_Sheet_Song_Info_DAOInter {
	
	// insert
	public void insertSongList(AISM_Sheet_Song_List_DTO dto);
	public void insertSongInfo(AISM_Sheet_Song_Info_DTO sdto);
	public void insertInstInfo(AISM_Sheet_Inst_Info_DTO idto);
	public void insertChordInfo(AISM_Sheet_Chord_Info_DTO cdto);
	
	
	// 모든 song 가져오기
	public List<AISM_Sheet_Song_List_DTO> allSongList();
	
	// 모든 악기 가져오기 
	public List<String> getInstList();
	
	// 곡명 중복확
	public boolean validSongName(String songName);

	// 트랙 정보 가져오기
	public List<AISM_Sheet_Inst_Info_DTO> getInstInfo(String songID);
	
	// 코드 정보 가져오기
	public List<AISM_Sheet_Chord_Info_DTO> getChordInfo(String songID);
	
	//producer의 모든 song 가져오기
	public List<AISM_Sheet_Song_List_DTO> getEachSongList(String producerName);
}