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
import data.dto.AISM_Sheet_Song_List_DTO;
import data.service.AISM_Sheet_Info_ServiceInter;


@Controller
public class CreateController {
	
	@Autowired
	private AISM_Sheet_Info_ServiceInter sheet;

	// admin test 페이지 -> db 입력 기능
	@GetMapping(value = "/insert/insertSongInfo")
	public @ResponseBody Map<String, Object> insertSongInfo(@ModelAttribute AISM_Sheet_Song_List_DTO dto) {

		Map<String, Object> map = new HashMap<String, Object>();

		sheet.insert_song_info(dto);
		
		map.put("song_name", dto.getSongInfo().getSongName());
		map.put("result", "success");

		return map;
	}
//	
//	@GetMapping(value = "/insert/insertSongInfo")
//	public @ResponseBody Map<String, Object> insertInstInfo(@ModelAttribute AISM_Sheet_Song_List_DTO dto) {
//
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		sheet.insert_song_info(dto);
//		
//		map.put("song_name", dto.getSongInfo().getSongName());
//		map.put("result", "success");
//
//		return map;
//	}
//	
//	@GetMapping(value = "/insert/insertSongInfo")
//	public @ResponseBody Map<String, Object> insertChordInfo(@ModelAttribute AISM_Sheet_Song_List_DTO dto) {
//
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		sheet.insert_song_info(dto);
//		
//		map.put("song_name", dto.getSongInfo().getSongName());
//		map.put("result", "success");
//
//		return map;
//	}
}