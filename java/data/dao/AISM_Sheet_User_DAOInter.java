package data.dao;

import data.dto.AISM_Sheet_User_Info_DTO;

public interface AISM_Sheet_User_DAOInter {
	
	//회원가입 
	public void createUser(AISM_Sheet_User_Info_DTO dto);
	
	//로그인
	public boolean loginIsValid(String id, String pwd);
	
	//아이디 중복확인
	public boolean validID(String id);
}
