package com.jdyun.example08_loading_property_in_configuration_class;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
//@PropertySource("classpath:example08/admin.properties")  // ������Ƽ ������ 1���� ���

//Spring 4.X���� ����
@PropertySources({
    @PropertySource("example08/admin.properties"),
    @PropertySource("example08/sub_admin.properties")
})
public class ApplicationConfig {
	
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
