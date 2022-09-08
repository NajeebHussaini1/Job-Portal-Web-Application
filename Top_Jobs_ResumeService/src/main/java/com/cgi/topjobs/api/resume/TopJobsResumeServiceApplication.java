package com.cgi.topjobs.api.resume;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.cgi.topjobs.api.resume.repository")
@ComponentScan("com")
@EnableDiscoveryClient
public class TopJobsResumeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopJobsResumeServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
