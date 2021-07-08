package data.dao;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import data.dto.AISM_Sheet_User_Info_DTO;


@Repository
public class AISM_Sheet_User_DAO extends SqlSessionDaoSupport implements AISM_Sheet_User_DAOInter {

	// 회원가입
	@Override
	public void createUser(AISM_Sheet_User_Info_DTO dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertUser", dto);
	}
	
	// 로그인
	@Override
	public boolean loginIsValid(String id, String pwd) {
		HashMap<String, String> map = new HashMap <String, String>();
		
		map.put("id", id);
		map.put("pwd", pwd);
		
		Integer is_valid = getSqlSession().selectOne("getPwd", map);
		
		if (is_valid >= 1) return true;
		else return false;
	}
	
	// 아이디 중복 확인
	@Override
	public boolean validID(String id) {
		HashMap<String, String> map = new HashMap <String, String>();
		
		map.put("id", id);
		
		// DB에 사용자가 입력한 아이디 있는지 확인 
		Integer is_valid = getSqlSession().selectOne("getID", map);
		
		// DB에 이미 아이디 존재하면 1개 이상 반환하므로 중복 -> 아이디 사용 불가 
		if (is_valid >= 1) return false;
		else return true;
	}
	
	//사용자 이름 가져오기
	@Override	
	public String getUserName(String id) {
		return getSqlSession().selectOne("getUserName", id);
	}

}
