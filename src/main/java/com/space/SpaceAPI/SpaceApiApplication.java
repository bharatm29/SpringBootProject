package com.space.SpaceAPI;

import com.space.SpaceAPI.resource.AstroAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpaceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceApiApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Bean
	public AstroAPI getAstro(){
		return new AstroAPI();
	}
}
