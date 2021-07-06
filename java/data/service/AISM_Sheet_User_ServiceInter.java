package data.service;

import data.dto.AISM_Sheet_User_Info_DTO;

public interface AISM_Sheet_User_ServiceInter {
	
	//회원가입 
	public void insertUser(AISM_Sheet_User_Info_DTO dto);
	
	//로그인
	public boolean validLogin(String id, String pwd);
	
}
