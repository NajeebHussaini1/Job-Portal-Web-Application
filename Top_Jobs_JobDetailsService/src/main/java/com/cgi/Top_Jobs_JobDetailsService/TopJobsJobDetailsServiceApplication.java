package com.cgi.Top_Jobs_JobDetailsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@ComponentScan("com")
@EnableMongoRepositories("com.repository")
@EnableDiscoveryClient
public class TopJobsJobDetailsServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TopJobsJobDetailsServiceApplication.class, args);
	}

}
