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

import data.dto.AISM_Sheet_User_Info_DTO;
import data.dto.AISM_Sheet_Chord_Info_DTO;
import data.dto.AISM_Sheet_Inst_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;
import data.service.AISM_Sheet_Info_ServiceInter;


@Controller
public class ViewController {
	
	@Autowired
	private AISM_Sheet_Info_ServiceInter sheet;
	
	
	@GetMapping(value = "/show/allSong")
	public @ResponseBody Map<String, Object> showAllSongList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AISM_Sheet_Song_List_DTO> list = new Vector<AISM_Sheet_Song_List_DTO>();
		
		list = sheet.allSongList();
		map.put("songList", list);
		
		return map;
	}
	
	@PostMapping(value = "/show/pdSong")
	public @ResponseBody Map<String, Object> showPdSongList(
			@RequestParam("producerName") String producerName) {
		Map<String, Object> map = new HashMap<String, Object>();

		
		/*
		list = sheet.pdSongList(producerName);
		*/
		
		return map;
	}
	
	// 트랙 형태와 코드 정보 가져오는 메서드 
	@PostMapping(value = "/show/trackANDchord")
	public @ResponseBody Map<String, Object> showTrackAndChordInfo(@RequestParam("songId") String songID) {
		
		// 결과 저장 변수 
		Map<String, Object> map = new HashMap<String, Object> ();
		
		// 트랙 정보, 코드 정보 받아올 변수 
		List<AISM_Sheet_Inst_Info_DTO> instInfo = new Vector<AISM_Sheet_Inst_Info_DTO>();
		List<AISM_Sheet_Chord_Info_DTO> chordInfo = new Vector<AISM_Sheet_Chord_Info_DTO>();
		
		instInfo = sheet.getInstInfo(songID);
		chordInfo = sheet.getChordInfo(songID);
		
		// 결과 보냄 
		map.put("trackInfo", instInfo);
		map.put("chordInfo", chordInfo);
		
		return map;
	}
	
}