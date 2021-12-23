package com.jdyun.practice07;

public class Professor {
	String name;
	String subject;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void getProfessorInfo() {
		System.out.println("name : " + name);
		System.out.println("subject : " + subject);
		System.out.println("age : " + age);
	}
}
