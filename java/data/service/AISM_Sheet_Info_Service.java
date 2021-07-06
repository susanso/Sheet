package data.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dao.AISM_Sheet_Info_DAOInter;
import data.dto.AISM_Sheet_Song_List_DTO;

@Service
public class AISM_Sheet_Info_Service 
	implements AISM_Sheet_Info_ServiceInter {
	
	@Autowired
	public AISM_Sheet_Info_DAOInter dao; 
	
	@Override
	public void insert_song_info(AISM_Sheet_Song_List_DTO dto) {
		dao.insert_song_info(dto);
	}
	
	@Override
	public List<AISM_Sheet_Song_List_DTO> allSongList() {
		return dao.allSongList();
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
	
