package com.kyn.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
// to configure website using spring boot mvc
// /** any string 
// allowed origin any string allowed
// allowed headers to use the spring security, to generate the access token
// user need to put the token in auth headers
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
		.allowedOriginPatterns("*")
		.allowedMethods("GET", "POST")
		.allowedHeaders("*")
		.allowCredentials(true);
		
	}
}
