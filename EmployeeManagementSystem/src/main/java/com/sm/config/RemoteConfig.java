package com.sm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Configuration
public class RemoteConfig {
	
	@Bean
	public RestTemplate remoteRestTemplate(@Value("${address.api.baseurl}") String apiHost) {
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(apiHost));
	    return restTemplate;
	}


	
	
	
}
