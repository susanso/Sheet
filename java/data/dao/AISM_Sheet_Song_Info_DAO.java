package data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	// 트랙 정보 가져오기
	@Override
	public List<AISM_Sheet_Inst_Info_DTO> getInstInfo(String songID) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("songID", songID);
		
		return getSqlSession().selectList("selectInstInfo", map);
	}
		
	// 코드 정보 가져오기
	@Override
	public List<AISM_Sheet_Chord_Info_DTO> getChordInfo(String songID) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("songID", songID);
		
		return getSqlSession().selectList("selectChordInfo", map);
	}
	
	//producer의 모든 song 가져오기
	@Override
	public List<AISM_Sheet_Song_List_DTO> getEachSongList(String producerName) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("producerName", producerName);
		
		return getSqlSession().selectList("selectEachSong", map);
	}
}
