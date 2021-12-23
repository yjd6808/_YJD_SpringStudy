package com.jdyun.practice3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EmpConnection implements EnvironmentAware, InitializingBean, DisposableBean {

	Environment env;
	String empId;
	String empPw;
	
	

	@Override
	public void setEnvironment(Environment environment) {
		setEnv(environment);
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setEmpId(getEnv().getProperty("emp.id"));
		setEmpPw(getEnv().getProperty("emp.pw"));
	}

	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpPw() {
		return empPw;
	}

	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
}
