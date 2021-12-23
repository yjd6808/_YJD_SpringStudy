package com.jdyun.practice5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class DBInfo {
	String driver;
	String url;
	String user;
	String password;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void print() {
		System.out.println("driver : " + driver);
		System.out.println("url : " + url);
		System.out.println("user : " + user);
		System.out.println("password : " + password);
		System.out.println("==========================");
	}
	
}
