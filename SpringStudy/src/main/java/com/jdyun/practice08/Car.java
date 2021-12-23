package com.jdyun.practice08;

public class Car {
	String company;
	String product;
	int capRank;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getCapRank() {
		return capRank;
	}
	public void setCapRank(int capRank) {
		this.capRank = capRank;
	}
	
	public void getCarInfo() {
		System.out.println("company : " + company);
		System.out.println("product : " + product);
		System.out.println("capRank : " + capRank);
	}
}
