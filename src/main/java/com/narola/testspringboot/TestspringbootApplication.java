package com.narola.testspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.narola.testspringboot")
public class TestspringbootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TestspringbootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestspringbootApplication.class);
	}

}
