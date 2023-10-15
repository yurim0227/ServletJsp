package com.kh.TourWeather.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APITourWeather {
	private static final String serviceKey = "iYzMl6Rz%2BoMjtt0f5WbxOv7y71FPDVXugg6ti%2BmqF6kGRCXgnMv5x%2FjkOcUFttleqqUZpnO1QYzlTO5H8WDAkg%3D%3D";
    
    @ResponseBody
    @RequestMapping(value = "weather.do", produces= "application/json; charset=utf-8")
    public String TourWeather(String location) throws IOException {
        String url = "https://apis.data.go.kr/1360000/TourStnInfoService1/getTourStnVilageFcst1";
        url += "?serviceKey=" + serviceKey;
        url += "&numOfRows=10";
        url += "&pageNo=1";
        url += "&dataType=json";
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
        url += "&CURRENT_DATE=" + datetime.format(formatter);
        url += "&HOUR=24";
        url += "&COURSE_ID=" + location;
        
        URL requestUrl = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String responseText = "";
        String line;
        while((line = br.readLine()) != null) {
           responseText += line;
        }
        br.close();
        urlConnection.disconnect();
      return responseText;
    }
}
