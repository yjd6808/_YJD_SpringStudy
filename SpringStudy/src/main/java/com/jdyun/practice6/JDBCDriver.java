package com.jdyun.practice6;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class JDBCDriver implements EnvironmentAware, InitializingBean {
	Environment env;
	String mysqlJdbcDriver;
	String oracleJdbcDriver;
	
	
	@Override
	public void setEnvironment(Environment environment) {
		setEnv(environment);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setOracleJdbcDriver(env.getProperty("oracle"));
		setMysqlJdbcDriver(env.getProperty("mysql"));
	}
	

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getMysqlJdbcDriver() {
		return mysqlJdbcDriver;
	}

	public void setMysqlJdbcDriver(String mysqlJdbcDriver) {
		this.mysqlJdbcDriver = mysqlJdbcDriver;
	}

	public String getOracleJdbcDriver() {
		return oracleJdbcDriver;
	}

	public void setOracleJdbcDriver(String oracleJdbcDriver) {
		this.oracleJdbcDriver = oracleJdbcDriver;
	}

	public void print() {
		System.out.println("mysqlJdbcDriver : " +mysqlJdbcDriver);
		System.out.println("oracleJdbcDriver : " + oracleJdbcDriver);
		System.out.println("==========================");
	}
	
	
}
