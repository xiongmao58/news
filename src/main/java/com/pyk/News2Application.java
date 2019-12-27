package com.pyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class News2Application  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(News2Application.class, args);
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){

		return builder.sources(News2Application.class);
	}
}
