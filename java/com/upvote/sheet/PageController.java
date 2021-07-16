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

import data.dto.AISM_Sheet_User_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;
import data.service.AISM_Sheet_Info_ServiceInter;


@Controller
public class PageController {
	
	@Autowired
	private AISM_Sheet_Info_ServiceInter sheet;
	
	// main 페이지
	@GetMapping(value = "/")
	public String renderHomePage() {
		return "component/home";
	}

	// Data 입력 페이지
	@GetMapping(value = "/insert")
	public String renderInsertPage() {
		return "component/create/insertData";
	}
	
	// 회원가입 페이지
	@GetMapping(value = "/signup.do")
	public String renderSignUpPage() {
		return "component/user/login/signUp";
	}
	
	// Top page에 사용자 정보 전달하기 위함 
	public ModelAndView renderTopPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		
		// main page view에 값 전달하기 위해 설정 
		model.setViewName("component/top");
		
		// Session 가져와서 메인 페이지에 뿌려줌 
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
		// 회원 정보 저장 객체에 저장 
		model.addObject("userName", userName);
		
		return model;
	}
	
	// 로그인 후 메인 페이지
	@GetMapping(value = "/main")
	public String renderMainPage() {
		return "component/main";
	}
	
	// Data View 페이지 
	@GetMapping(value = "/view")
	public String renderViewPage() {
		return "component/read/view";
	}
	
	//하현준 작업용
	@GetMapping("insertPage")
	public String test1() {
		return "component/create/insertPage";
	}
	
	// 수연 작업용
	@GetMapping("viewDetail")
	public String test2() {
		return "component/read/viewDetail/viewDetail";
	}
	
}