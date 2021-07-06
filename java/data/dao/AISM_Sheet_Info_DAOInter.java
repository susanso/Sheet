package data.dao;


import java.util.List;

import data.dto.AISM_Sheet_Song_List_DTO;

public interface AISM_Sheet_Info_DAOInter {
	
	// insert
	public void insert_song_info(AISM_Sheet_Song_List_DTO dto);
	// 모든 song 가져오기
	public List<AISM_Sheet_Song_List_DTO> allSongList();
}