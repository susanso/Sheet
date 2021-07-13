package com.upvote.sheet;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.springframework.web.servlet.view.RedirectView;

import data.dto.AISM_Sheet_User_Info_DTO;
import data.dto.AISM_Sheet_Chord_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Song_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;
import data.service.AISM_Sheet_Info_ServiceInter;


@Controller
public class EditController {
	
	@Autowired
	private AISM_Sheet_Info_ServiceInter sheet;
	
	// 트랙 형태와 코드 정보 가져오는 메서드 
	@GetMapping(value = "/edit")
	public ModelAndView renderEditPage(@RequestParam("songId") String songID) {
			
		ModelAndView model = new ModelAndView();
		
		// 곡 정보, 트랙 정보, 코드 정보 받아올 변수 
		AISM_Sheet_Song_Info_DTO songInfo = new AISM_Sheet_Song_Info_DTO();
		List<AISM_Sheet_Inst_Info_DTO> instInfo = new Vector<AISM_Sheet_Inst_Info_DTO>();
		List<AISM_Sheet_Chord_Info_DTO> chordInfo = new Vector<AISM_Sheet_Chord_Info_DTO>();
		
		songInfo = sheet.getSongInfo(songID);
		instInfo = sheet.getInstInfo(songID);
		chordInfo = sheet.getChordInfo(songID);
		
		// 보낼 정보 객체로 저장 
		model.addObject("songInfo", songInfo);
		model.addObject("instInfo", instInfo);
		model.addObject("chordInfo", chordInfo);
		
		// 보낼 View Page 저장
		model.setViewName("/component/read/viewDetail/viewDetail");
		
		return model;
	}	
	
}