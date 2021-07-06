package data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import data.dto.AISM_Sheet_Song_List_DTO;

@Repository
public class AISM_Sheet_Song_Info_DAO
	extends SqlSessionDaoSupport
		implements AISM_Sheet_Info_DAOInter {
	
	@Override
	public void insert_song_info(AISM_Sheet_Song_List_DTO dto) {
		getSqlSession().insert("insertSongInfo", dto);
	}
	
	@Override
	public List<AISM_Sheet_Song_List_DTO> allSongList(){
		return getSqlSession().selectList("selectAllSong");
	}
}
