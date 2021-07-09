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
}
