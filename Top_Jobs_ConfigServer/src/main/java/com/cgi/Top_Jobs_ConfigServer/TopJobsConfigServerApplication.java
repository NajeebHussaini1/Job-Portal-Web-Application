package com.cgi.Top_Jobs_ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class TopJobsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopJobsConfigServerApplication.class, args);
	}

}
