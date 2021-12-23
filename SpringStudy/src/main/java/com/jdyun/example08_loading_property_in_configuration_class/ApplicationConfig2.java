package com.jdyun.example08_loading_property_in_configuration_class;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class ApplicationConfig2 {
	
	
	// Spring 3.X에서 여러 프로퍼티들 가져오는 방법
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() 
	{
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("example08/admin.properties");
		locations[1] = new ClassPathResource("example08/sub_admin.properties");
		configurer.setLocations(locations);
				
		return configurer;
	}
	
	@Value("${admin.id}")
	private String adminId;
	
	@Value("${admin.pw}")
	private String adminPw;
	
	@Value("${sub_admin.id}")
	private String sub_adminId;
	
	@Value("${sub_admin.pw}")
	private String sub_adminPw;

	
	@Bean
	public AdminConnection adminConnection() {
		
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSub_adminId(sub_adminId);
		adminConnection.setSub_adminPw(sub_adminPw);
		
		return adminConnection;
	}
}
