package com.jdyun.practice1;

import java.util.ArrayList;

public class Employee {
	String name;
	int pay;
	ArrayList<String> cards;
	
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public ArrayList<String> getCards() {
		return cards;
	}
	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}
	
	
}
