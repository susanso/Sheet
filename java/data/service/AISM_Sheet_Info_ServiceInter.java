package data.service;

import java.util.HashMap;
import java.util.List;

import data.dto.AISM_Sheet_Info_DTO;

public interface AISM_Sheet_Info_ServiceInter {
	//song 입력
	public void insert_song_info(AISM_Sheet_Info_DTO dto);
	//모든 song 가져오기
	public List<AISM_Sheet_Info_DTO> allSongList();
	/*
	//producer의 모든 song 가져오기
	public List<AISM_Sheet_Info_DTO> pdSongList();
	//1개 song 가져오기
	public List<AISM_Sheet_Info_DTO> oneSongInfo();
	*/
}