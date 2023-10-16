package com.kh.TourWeather.model.vo;

public class TourWeatherVO {
	private String spotAreaName;
	private String spotName;
	private String th3;
	private String rhm;
	private String pop;
	
	public TourWeatherVO() {
		super();
	}

	public TourWeatherVO(String spotAreaName, String spotName, String th3, String rhm, String pop) {
		super();
		this.spotAreaName = spotAreaName;
		this.spotName = spotName;
		this.th3 = th3;
		this.rhm = rhm;
		this.pop = pop;
	}

	public String getSpotAreaName() {
		return spotAreaName;
	}

	public void setSpotAreaName(String spotAreaName) {
		this.spotAreaName = spotAreaName;
	}

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public String getTh3() {
		return th3;
	}

	public void setTh3(String th3) {
		this.th3 = th3;
	}

	public String getRhm() {
		return rhm;
	}

	public void setRhm(String rhm) {
		this.rhm = rhm;
	}

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

	@Override
	public String toString() {
		return "TourWeatherVO [spotAreaName=" + spotAreaName + ", spotName=" + spotName + ", th3=" + th3 + ", rhm="
				+ rhm + ", pop=" + pop + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
