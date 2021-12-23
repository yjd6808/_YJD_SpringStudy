package com.jdyun.example02_loading_configuration_class_in_xml;

import java.util.ArrayList;


import org.springframework.stereotype.Component;

@Component
public class Student {
	String name;
	int age;
	ArrayList<String> hobbys;
	int height;
	int weight;
	

	public Student(String name, int age, ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	public void printInfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("weight : " + weight);
		System.out.println("height : " + height);
		System.out.println("hobbies : " + hobbys.toString());
		
	}
	
}
