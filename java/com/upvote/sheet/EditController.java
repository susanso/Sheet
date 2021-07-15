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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	public ModelAndView renderEditPage(HttpSession session, @RequestParam("songId") String songID) {
			
		ModelAndView model = new ModelAndView();
		
		// 곡 정보, 트랙 정보, 코드 정보 받아올 변수 
		AISM_Sheet_Song_Info_DTO songInfo = new AISM_Sheet_Song_Info_DTO();
		List<AISM_Sheet_Inst_Info_DTO> instInfo = new Vector<AISM_Sheet_Inst_Info_DTO>();
		List<AISM_Sheet_Chord_Info_DTO> chordInfo = new Vector<AISM_Sheet_Chord_Info_DTO>();
		
		songInfo = sheet.getSongInfo(songID);
		instInfo = sheet.getInstInfo(songID);
		chordInfo = sheet.getChordInfo(songID);
		
		// 세션 확인해서 작업 담당자 본인이면 수정, 삭제 가능 여부 저장 
		String userName = (String)session.getAttribute("userName");
		if (userName.equals(songInfo.getProducerName())) {
			System.out.println("동일");
			model.addObject("isQualified", true);
		}
		else {
			model.addObject("isQualified", false);
		}
		
		// 보낼 정보 객체로 저장 
		model.addObject("songInfo", songInfo);
		model.addObject("instInfo", instInfo);
		model.addObject("chordInfo", chordInfo);
		
		// 보낼 View Page 저장
		model.setViewName("/component/read/viewDetail/viewDetail");
		
		return model;
	}
	
	// viewDetail에서 수정 정보 가져와서 update 해주는 메서드
	@PostMapping("updateSong.do")
	public ModelAndView insertSongList(
			HttpServletRequest request,
			HttpSession session,
			@RequestParam("songData") String songData,
			@RequestParam("inst_li") String inst_li,
			@RequestParam("chord_li") String chord_li) throws ParseException, JsonParseException, JsonMappingException, IOException{
		
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		JSONParser jsonParser = new JSONParser();
		ObjectMapper objectMapper = new ObjectMapper();

		// song_info userId 추가해서 Bean객체
		JSONObject jsonSongObj = (JSONObject) jsonParser.parse(songData);
		jsonSongObj.put("userId", (String) session.getAttribute("userId"));
		AISM_Sheet_Song_Info_DTO jsonSongDTO = objectMapper.readValue(jsonSongObj.toString(), AISM_Sheet_Song_Info_DTO.class);
		
		// inst_info, chord_info JSON 배열로 파싱
        JSONArray jsonInstArr = (JSONArray) jsonParser.parse(inst_li);
        JSONArray jsonChordArr = (JSONArray) jsonParser.parse(chord_li);
        
        System.out.println(jsonSongObj);
        System.out.println(jsonInstArr);
        System.out.println(jsonChordArr);
        
        if (updateSongInfo(jsonSongDTO).get("result") == "success") {
        	System.out.println("song 업데이트 완료");
        	for(int i=0; i<jsonInstArr.size(); i++){
        		AISM_Sheet_Inst_Info_DTO instDTO = objectMapper.readValue(jsonInstArr.get(i).toString(), AISM_Sheet_Inst_Info_DTO.class);
        		updateInstInfo(instDTO);
        		instDTO.print();
            }
        	
        	for(int i=0; i<jsonChordArr.size(); i++){
        		AISM_Sheet_Chord_Info_DTO chordDTO = objectMapper.readValue(jsonChordArr.get(i).toString(), AISM_Sheet_Chord_Info_DTO.class);
        		updateChordInfo(chordDTO);
        		chordDTO.print();
            }
        }
		System.out.println("!!!!success!!!!");

		return mv;
	}
	
	@GetMapping("deleteSong.do")
	public Map<String, String> deleteSong(@RequestParam() String songId) {
		Map<String, String> map = new HashMap<String, String>();
		
		sheet.deleteSong(songId);
		map.put("result", "success");
		
		return map;
	}
	
	public Map<String, Object> updateSongInfo(@ModelAttribute AISM_Sheet_Song_Info_DTO sdto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		sheet.updateSongInfo(sdto);
		
		map.put("result", "success");
		
		return map;
	}
	
	public Map<String, Object> updateInstInfo(@ModelAttribute AISM_Sheet_Inst_Info_DTO idto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		sheet.updateInstInfo(idto);
		
		map.put("result", "success");
		
		return map;
	}
	
	public Map<String, Object> updateChordInfo(@ModelAttribute AISM_Sheet_Chord_Info_DTO cdto) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		sheet.updateChordInfo(cdto);
		
		map.put("result", "success");
		
		return map;
	}

}