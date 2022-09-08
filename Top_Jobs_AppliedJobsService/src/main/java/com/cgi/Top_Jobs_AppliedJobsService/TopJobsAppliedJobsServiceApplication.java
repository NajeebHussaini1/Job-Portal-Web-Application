package com.cgi.Top_Jobs_AppliedJobsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com")
@EnableDiscoveryClient
@EnableMongoRepositories("com.repo")
public class TopJobsAppliedJobsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopJobsAppliedJobsServiceApplication.class, args);
	}

}
