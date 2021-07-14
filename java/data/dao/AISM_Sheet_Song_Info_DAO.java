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
	public List<AISM_Sheet_Song_List_DTO> allSongList() {
		return getSqlSession().selectList("selectAllSong");
	}
	
	// 모든 악기 가져오기
	@Override
	public List<String> getInstList(){
		return getSqlSession().selectList("selectAllInst");
	}

	// 곡명 중복확인
	@Override
	public boolean validSongName(String songName) {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("songName", songName);

		// DB에 사용자가 입력한 아이디 있는지 확인
		Integer is_valid = getSqlSession().selectOne("getSongName", map);

		// DB에 이미 아이디 존재하면 1개 이상 반환하므로 중복 -> 아이디 사용 불가
		if (is_valid >= 1) return false;
		else return true;
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
	
	// SongID로 곡 정보 가져오기 
	@Override
	public AISM_Sheet_Song_Info_DTO getSongInfo(String songID) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("songID", songID);
		
		return getSqlSession().selectOne("selectSongInfo", map);
	}

	// song info 수정
	@Override
	public void updateSongInfo(AISM_Sheet_Song_Info_DTO sdto) {
		System.out.println("여기는 다오");
		System.out.println(sdto);
		getSqlSession().update("updateSongInfo", sdto);
	}
	
	// inst info 수정
	@Override
	public void updateInstInfo(AISM_Sheet_Inst_Info_DTO idto) {
		System.out.println(idto);
		getSqlSession().update("updateInstInfo", idto);
	}

	// chord info 수정
	@Override
	public void updateChordInfo(AISM_Sheet_Chord_Info_DTO cdto) {
		getSqlSession().update("updateChordInfo", cdto);
	}
	
	@Override
	public void deleteSong(String songId) {
		getSqlSession().delete("deleteSong", songId);
	}
}
