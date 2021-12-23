package com.jdyun.practice08;

public class Graphic {
	String company;
	int capRank;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getCapRank() {
		return capRank;
	}
	public void setCapRank(int capRank) {
		this.capRank = capRank;
	}
	
	public void getGraphicInfo() {
		System.out.println("company : " + company );
		System.out.println("capRank : " + capRank );
	}
}
