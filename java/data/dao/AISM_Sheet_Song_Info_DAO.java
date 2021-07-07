package data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import data.dto.AISM_Sheet_Chord_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Song_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;

@Repository
public class AISM_Sheet_Song_Info_DAO
	extends SqlSessionDaoSupport
		implements AISM_Sheet_Song_Info_DAOInter {
	
	@Override
	public void insertSongList(AISM_Sheet_Song_List_DTO dto) {
		//TODO
		getSqlSession().insert("insertSongList", dto);
	}
	
	@Override
	public void insertSongInfo(AISM_Sheet_Song_Info_DTO sdto) {
		getSqlSession().insert("insertSongInfo", sdto);
	}
	
	@Override
	public void insertInstInfo(AISM_Sheet_Inst_Info_DTO idto) {
		getSqlSession().insert("insertInstInfo", idto);
	}
	
	@Override
	public void insertChordInfo(AISM_Sheet_Chord_Info_DTO cdto) {
		getSqlSession().insert("insertChordInfo", cdto);
	}
	
	@Override
	public List<AISM_Sheet_Song_List_DTO> allSongList(){
		return getSqlSession().selectList("selectAllSong");
	}
}
