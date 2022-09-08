package com.cgi.Top_Jobs_JobSeekerService;

import com.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.model")
@EnableJpaRepositories("com.repo")
@EnableDiscoveryClient
public class TopJobsJobSeekerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopJobsJobSeekerServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {

		FilterRegistrationBean registrationbean = new FilterRegistrationBean();
		registrationbean.setFilter(new JwtFilter());
		registrationbean.addUrlPatterns("/api/v1/jobseekers");
		registrationbean.addUrlPatterns("/api/v1/delete");


		return registrationbean;

	}


}
