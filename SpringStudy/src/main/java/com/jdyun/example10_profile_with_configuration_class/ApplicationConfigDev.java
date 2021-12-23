package com.jdyun.example10_profile_with_configuration_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfigDev {
	
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo serverInfo = new ServerInfo();
		
		serverInfo.setIpNum("localhost");
		serverInfo.setPortNum("8181");
		
		return serverInfo;
	}
}
