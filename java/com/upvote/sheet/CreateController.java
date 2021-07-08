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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
public class CreateController {
	
	@Autowired
	private AISM_Sheet_Info_ServiceInter sheet;

	//song, inst, chord 정보 저장 
	@PostMapping("insertSong.do")
	public @ResponseBody Map<String, Object> insertSongList(
			HttpServletRequest request,HttpSession session,
			@RequestParam("songData") String songData,
			@RequestParam("inst_li") String inst_li,
			@RequestParam("chord_li") String chord_li) throws ParseException, JsonParseException, JsonMappingException, IOException{	

		Map<String, Object> map = new HashMap<String, Object>();
		JSONParser jsonParser = new JSONParser();
		ObjectMapper objectMapper = new ObjectMapper();
			
		JSONObject jsonSongObj = (JSONObject) jsonParser.parse(songData);
		jsonSongObj.put("userId", (String) session.getAttribute("userId"));
		AISM_Sheet_Song_Info_DTO jsonSongDTO = objectMapper.readValue(jsonSongObj.toString(), AISM_Sheet_Song_Info_DTO.class);
        JSONArray jsonInstArr = (JSONArray) jsonParser.parse(inst_li);
        JSONArray jsonChordArr = (JSONArray) jsonParser.parse(chord_li);
 
        if (insertSongInfo(jsonSongDTO).get("result") == "success") {
        	for(int i=0; i<jsonInstArr.size(); i++){
        		AISM_Sheet_Inst_Info_DTO instDTO = objectMapper.readValue(jsonInstArr.get(i).toString(), AISM_Sheet_Inst_Info_DTO.class);
        		insertInstInfo(instDTO);
        		instDTO.print();
            }
        	
        	for(int i=0; i<jsonChordArr.size(); i++){
        		AISM_Sheet_Chord_Info_DTO chordDTO = objectMapper.readValue(jsonChordArr.get(i).toString(), AISM_Sheet_Chord_Info_DTO.class);
        		insertChordInfo(chordDTO);
        		chordDTO.print();
            }
        }
		map.put("result", "success");

		return map;
	}
	
	public Map<String, Object> insertSongInfo(@ModelAttribute AISM_Sheet_Song_Info_DTO sdto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		sheet.insertSongInfo(sdto);
		
		map.put("result", "success");
		
		return map;
	}
	
	public Map<String, Object> insertInstInfo(@ModelAttribute AISM_Sheet_Inst_Info_DTO idto) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		sheet.insertInstInfo(idto);
		
		map.put("result", "success");
		
		return map;
	}
	
	public Map<String, Object> insertChordInfo(@ModelAttribute AISM_Sheet_Chord_Info_DTO cdto) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		sheet.insertChordInfo(cdto);
		
		map.put("result", "success");
		
		return map;
	}
	

	
	
	
	
	
	
	
	
	

}