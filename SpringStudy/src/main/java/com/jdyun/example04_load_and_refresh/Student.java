package com.jdyun.example04_load_and_refresh;

import org.springframework.stereotype.Component;

@Component
public class Student {
	String name;
	int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
	public void printInfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
}
