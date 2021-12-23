package com.jdyun.practice2;

import java.util.ArrayList;

public class Singer {
	String name;
	int memberCount;
	ArrayList<String> sings;
	
	
	public Singer(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}
	public ArrayList<String> getSings() {
		return sings;
	}
	public void setSings(ArrayList<String> sings) {
		this.sings = sings;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(memberCount);
		System.out.println(sings);
		System.out.println("================================");
	}
}
