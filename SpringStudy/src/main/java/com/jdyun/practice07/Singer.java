package com.jdyun.practice07;

public class Singer {
	String name;
	String song;
	int member;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	
	public void getSingerInfo() {
		System.out.println("name : " + name);
		System.out.println("song : " + song);
		System.out.println("member : " + member);
	}
}
