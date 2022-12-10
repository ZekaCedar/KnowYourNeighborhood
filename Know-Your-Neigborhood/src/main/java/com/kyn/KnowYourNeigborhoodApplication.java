package com.kyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.kyn.configuration.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class KnowYourNeigborhoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowYourNeigborhoodApplication.class, args);
	}

}
