package com.information.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.information.vo.Hospital;

public class HospitalInfoController {
	private List<Hospital> list = new ArrayList<>();
	
	public void inputData() {
		String path = HospitalInfoController.class.getResource("/").getPath();
		File data = new File(path + "/hospitaldata.csv");
		StringBuffer sb = new StringBuffer();
		
		try(BufferedReader breader = new BufferedReader(new FileReader(data));) {
			String ch = "";
			while((ch=breader.readLine()) != null) {
				sb.append(ch + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] datas = sb.toString().split("\n");
		
		for(String d : datas) {
		    String[] detail = d.split(",");
		    for (int i = 0; i < detail.length; i++) {
		        // 큰 따옴표로 시작하는 경우 큰 따옴표를 제거
		        if (detail[i].startsWith("\"")) {
		            detail[i] = detail[i].substring(1);
		        }
		        // 큰 따옴표로 끝나는 경우 큰 따옴표를 제거
		        if (detail[i].endsWith("\"")) {
		            detail[i] = detail[i].substring(0, detail[i].length() - 1);
		        }
		    }
		    
		    int count = 0;
		    
		    try {
		        count = Integer.parseInt(detail[16]);
		    } catch (NumberFormatException e) {
		    }
		    
		    list.add(new Hospital(detail[2], detail[1], detail[3], detail[4], detail[8], detail[9], detail[10], detail[11], count));
		}
		list.remove(0);
	}
	
	public void printHospitalData() {
		System.out.printf("%-10s %-20s %-10s %-10s %-30s %-10s %-30s %-10s %-4s\n", "종류", "병원명", "시도명", "시군구명", "주소", "전화번호", "홈페이지주소", "개설일", "총의사수");
		
		for(Hospital h : list) {
			System.out.printf("%-10s %-20s %-10s %-10s %-30s %-10s %-30s %-10s %-4d\n", h.getCategory(), h.getHospitalName(), h.getStateCode(), h.getCityCode(), h.getAddress(), h.getPhone(), h.getSite(), h.getOpenDate(), h.getDoctorCount());
		}
	}
}
