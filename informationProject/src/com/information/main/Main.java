package com.information.main;

import com.information.controller.HospitalInfoController;

public class Main {
	public static void main(String[] args) {
		HospitalInfoController controller = new HospitalInfoController();
		controller.inputData();
		controller.printHospitalData();
	}
}
