package data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dao.AISM_Sheet_User_DAOInter;
import data.dto.AISM_Sheet_User_Info_DTO;



@Service
public class AISM_Sheet_User_Service implements AISM_Sheet_User_ServiceInter{
	
	@Autowired
	private AISM_Sheet_User_DAOInter dao;

	// 회원가입
	@Override
	public void insertUser(AISM_Sheet_User_Info_DTO dto) {
		// TODO Auto-generated method stub
		dao.createUser(dto);
	}
	
	//로그인
	@Override
	public boolean validLogin(String id, String pwd) {
		return dao.loginIsValid(id, pwd);
	}

}
