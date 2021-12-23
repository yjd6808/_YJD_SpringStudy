package com.jdyun.example10_profile_with_configuration_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfigRun {
	
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo serverInfo = new ServerInfo();
		
		serverInfo.setIpNum("127.121.74.511");
		serverInfo.setPortNum("80");
		
		return serverInfo;
	}
}
