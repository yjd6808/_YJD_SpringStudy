package com.jdyun.example05_bean_lifecycle_callback;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class OtherStudent {
	String name;
	int age;

	public OtherStudent(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@PostConstruct
	public void initMethod() {
		System.out.println("initMethod()");
	}
	
	@PreDestroy
	public void destroyMethod() {
		System.out.println("destroyMethod()");
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
