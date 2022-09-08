package com.cgi.Top_Jobs_Registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TopJobsRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopJobsRegistryApplication.class, args);
	}

}
