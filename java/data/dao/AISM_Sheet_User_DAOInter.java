package data.dao;

import data.dto.AISM_Sheet_User_Info_DTO;

public interface AISM_Sheet_User_DAOInter {
	
	//회원가입 
	public void createUser(AISM_Sheet_User_Info_DTO dto);
}
