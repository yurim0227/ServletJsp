package com.kh.opendata.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.opendata.model.vo.AirVO;

public class AirPollutionJavaApp {
	public static final String serviceKey = "iYzMl6Rz%2BoMjtt0f5WbxOv7y71FPDVXugg6ti%2BmqF6kGRCXgnMv5x%2FjkOcUFttleqqUZpnO1QYzlTO5H8WDAkg%3D%3D";
	public static void main(String[] args) throws IOException {
        String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
        
        url += "?serviceKey=" + serviceKey;
        url += "&sidoName=" + URLEncoder.encode("서울", "UTF-8");
        
        url += "&returnType=json";
        
        //System.out.println(url);
        URL requestUrl = new URL(url);
        
        HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
        
        urlConnection.setRequestMethod("GET");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        
        String responseText = "";
        String line;
        while((line = br.readLine()) != null) {
        	//System.out.println(line);
        	responseText += line;
        }
        //System.out.println(responseText);
        
        JsonObject totalObj = JsonParser.parseString(responseText).getAsJsonObject();
        
        JsonObject responseObj = totalObj.getAsJsonObject("response");
        //System.out.println(responseObj);
        
        JsonObject bodyObj = responseObj.getAsJsonObject("body");
        //System.out.println(bodyObj);
        
        int totalCount = bodyObj.get("totalCount").getAsInt();
        
        JsonArray itemArr = bodyObj.getAsJsonArray("items");
        //System.out.println(totalCount);
        //System.out.println(itemArr);
        
        ArrayList<AirVO> list = new ArrayList<>();
        for(int i=0; i<itemArr.size(); i++) {
        	JsonObject item = itemArr.get(i).getAsJsonObject();
        	//System.out.println(item);
        	
        	AirVO air = new AirVO();
        	air.setStationName(item.get("stationName").getAsString());
        	air.setDataTime(item.get("dataTime").getAsString());
        	air.setKhaiValue(item.get("khaiValue").getAsString());
        	air.setPm10Value(item.get("pm10Value").getAsString());
        	air.setSo2Value(item.get("so2Value").getAsString());
        	air.setCoValue(item.get("coValue").getAsString());
        	air.setNo2Value(item.get("no2Value").getAsString());
        	air.setO3Value(item.get("o3Value").getAsString());
        	
        	list.add(air);
        }
        //System.out.println(list);
        for(AirVO a : list) {
        	System.out.println(a);
        }
        
        br.close();
        urlConnection.disconnect();
    }
}
