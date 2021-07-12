package data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.dao.AISM_Sheet_Song_Info_DAOInter;
import data.dto.AISM_Sheet_Song_List_DTO;
import data.dto.AISM_Sheet_Song_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Chord_Info_DTO;

@Service
public class AISM_Sheet_Info_Service 
	implements AISM_Sheet_Info_ServiceInter {
	
	@Autowired
	public AISM_Sheet_Song_Info_DAOInter dao; 
	
	/* 
	@Override
	public void insertSongList(String jsonData) throws ParseException{
        dao.insertSongList(songList_DTO);
	}
	*/
	
	
	//song info 입력 
	@Override
	public void insertSongInfo(AISM_Sheet_Song_Info_DTO sdto) {
		dao.insertSongInfo(sdto);
	}
	
	//song info 입력 
	@Override
	public void insertInstInfo(AISM_Sheet_Inst_Info_DTO idto) {
		dao.insertInstInfo(idto);
	}
	
	//chord info 입력 
	@Override
	public void insertChordInfo(AISM_Sheet_Chord_Info_DTO cdto) {
		dao.insertChordInfo(cdto);
	}
	
	//모든 곡 가져오
	@Override
	public List<AISM_Sheet_Song_List_DTO> allSongList() {
		return dao.allSongList();
	}
	
	//모든 악기 가져오기 
	@Override
	public List<String> getInstList(){
		return dao.getInstList();
	}
	
	//곡명 중복 확인	
	@Override
	public boolean validSongName(String songName) {
		return dao.validSongName(songName);
	}

	// 코드 정보 가져오기
	@Override
	public List<AISM_Sheet_Inst_Info_DTO> getInstInfo(String songID) {
		return dao.getInstInfo(songID);
	}
		
	// 트랙 정보 가져오기
	public List<AISM_Sheet_Chord_Info_DTO> getChordInfo(String songID) {
		return dao.getChordInfo(songID);
	}
	
	/*
	//producer의 모든 song 가져오기
	@Override
	public List<AISM_Sheet_Info_DTO> pdSongList(String producerName) {
		
	}
	
	//1개 song 가져오기
	@Override
	public List<AISM_Sheet_Info_DTO> oneSongInfo() {
		
	}
	*/
}
	
