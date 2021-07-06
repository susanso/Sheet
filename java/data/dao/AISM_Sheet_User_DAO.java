package data.dao;

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
		String realPwd = getSqlSession().selectOne("getPwd", id);
		
		if (realPwd.equals(pwd)) return true;
		else return false;
	}

}