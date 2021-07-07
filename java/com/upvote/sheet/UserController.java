package com.upvote.sheet;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import data.session.AbxtractHttpSession;
import data.dto.AISM_Sheet_Song_List_DTO;
import data.dto.AISM_Sheet_User_Info_DTO;
import data.service.AISM_Sheet_User_ServiceInter;


@Controller
public class UserController extends AbxtractHttpSession {
	
	@Autowired
	private AISM_Sheet_User_ServiceInter membership;
	
	// 회원가입 Url
	@GetMapping("signUp.go")
	public @ResponseBody Map<String, String> joinUser(@ModelAttribute AISM_Sheet_User_Info_DTO dto){
		Map<String, String> map = new HashMap<String, String>();
		membership.insertUser(dto);
		map.put("userId", dto.getUserId());
		map.put("success", "success");
		return map;
	}
	
	// 로그인 url 
	@PostMapping("login.do")
	public @ResponseBody Map<String, String> loginUser(HttpServletRequest request, @RequestParam String id, @RequestParam String pwd){
		Map<String, String> map = new HashMap<String, String>();
		
		// DB에 사용자가 입력한 ID, PWD 넣어서 유효한지 확인하기 위한 객체
		map.put("userId", id);
		map.put("userPwd", pwd);
		
		// DB에 ID, PWD 보내서 유효성 확인 
		boolean login_is_valid = membership.validLogin(id, pwd);
		
		// 로그인 성공 -> Client에 로그인 결과 성공으로 전송 & Session 설정 
		if (login_is_valid) {
			HttpSession session = request.getSession();
			
			session.setAttribute("userId", id);
			session.setAttribute("userPwd", pwd);
			
			session.setMaxInactiveInterval(1800);
			
			map.put("login", "success");
		}
		
		// 로그인 실패 -> Client에 로그인 결과 실패로 전송 
		else map.put("login", "fail");
		
		return map;
		
	}
	
}