package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	private static final String serviceKey = "iYzMl6Rz%2BoMjtt0f5WbxOv7y71FPDVXugg6ti%2BmqF6kGRCXgnMv5x%2FjkOcUFttleqqUZpnO1QYzlTO5H8WDAkg%3D%3D";
	
	@ResponseBody
	@RequestMapping(value = "air.do", produces = "application/json;charset=utf-8")
	public String airPollution(String location) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + serviceKey;
        url += "&sidoName=" + URLEncoder.encode(location, "UTF-8");
        url += "&returnType=json";
        //System.out.println(url);
        
        URL requestUrl = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
        urlConnection.setRequestMethod("GET");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        
        String responseText = "";
        String line;
        while((line = br.readLine()) != null) {
        	responseText += line;
        }
        br.close();
        urlConnection.disconnect();
        //System.out.println(responseText);
        return responseText;
	}
}
