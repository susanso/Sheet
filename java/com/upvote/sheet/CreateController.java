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
	@GetMapping(value = "/insert/insertSongInfo")
	public @ResponseBody Map<String, Object> insertSongList(
			@RequestParam String jsonData,
			@RequestParam String userId) throws ParseException{
		
		jsonData = "{\"song\": {\"userId\":\"userId\",\"songId\":\"songId\",\"songName\":\"songName\",\"artist\":\"artist\",\"producerName\":\"producerName\",\"genre\":\"genre\",\"keyName\":\"keyName\",\"bpm\":\"bpm\",\"songForm\":\"songForm\",\"beat\":\"beat\"},"
				+ "\"inst\":[{\"songId\":\"songId\",\"instNum\":\"0\",\"instName\":\"melody\"},{\"instNum\":\"1\",\"instName\":\"bass\"}],"
				+ "\"chord\":[{\"songId\":\"songId\",\"measureNum\":\"1\",\"chord\":\"I,I,I,I\"},{\"measureNum\":\"2\",\"chord\":\"IV,IV,IV,IV\"}]}";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONParser jsonParser = new JSONParser();
		
		JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);
		AISM_Sheet_Song_Info_DTO jsonSongObj= (AISM_Sheet_Song_Info_DTO) jsonObject.get("song");
        JSONArray jsonInstArr = (JSONArray) jsonObject.get("inst");
        JSONArray jsonChordArr = (JSONArray) jsonObject.get("chord");
        
        
        if (insertSongInfo(jsonSongObj).get("result") == "success") {
        	
        	for(int i=0; i<jsonInstArr.size(); i++){
        		AISM_Sheet_Inst_Info_DTO jsonInstObj = (AISM_Sheet_Inst_Info_DTO) jsonInstArr.get(i);
                insertInstInfo(jsonInstObj);
            }
        	for(int i=0; i<jsonChordArr.size(); i++){
        		AISM_Sheet_Chord_Info_DTO jsonChordObj = (AISM_Sheet_Chord_Info_DTO) jsonChordArr.get(i);
                insertChordInfo(jsonChordObj);
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