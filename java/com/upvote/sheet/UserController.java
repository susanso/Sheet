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

import data.dto.AISM_Sheet_Song_List_DTO;
import data.dto.AISM_Sheet_User_Info_DTO;
import data.service.AISM_Sheet_User_ServiceInter;


@Controller
public class UserController {
	
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
	@GetMapping("login.do")
	public @ResponseBody Map<String, String> loginUser(@RequestParam String id, @RequestParam String pwd){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("userId", id);
		map.put("userPwd", pwd);
		
		if (membership.validLogin(id, pwd)) {
			System.out.println("login good");
			map.put("login", "success");
		}
		
		else {
			System.out.println("login false");
			map.put("login", "false");
		}
		
		return map;
		
	}
	
}