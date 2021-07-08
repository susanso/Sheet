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

import data.dto.AISM_Sheet_User_Info_DTO;
import data.dto.AISM_Sheet_Song_List_DTO;
import data.service.AISM_Sheet_Info_ServiceInter;


@Controller
public class EditController {
	
	@Autowired
	private AISM_Sheet_Info_ServiceInter sheet;
	
	@PostMapping("/main/flasktest")
	public @ResponseBody Map<String, String> flaskTest() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		
		// JSON 데이터 받을 URL 객체 생성
		URL url = new URL("http://141.164.62.192:8888/hyunjin");

		// HttpURLConnection 객체를 생성해 openConnection 메소드로 url 연결
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		// 전송 방식 (POST)
		con.setRequestMethod("POST");
		
		// application/json 형식으로 전송, Request body를 JSON으로 던져줌.
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		
		// Response data를 JSON으로 받도록 설정
		con.setRequestProperty("Accept", "application/json");
		
		// Output Stream을 POST 데이터로 전송
		con.setDoOutput(true);
		
		String jsonInputString = "from Sheet Server";
		
		// JSON 보내는 Output stream
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
				map.put("flask", responseLine.trim());
				
				System.out.println(response.toString() + "로 값을 받음");
			}
		}
				
		return map;
	}
}