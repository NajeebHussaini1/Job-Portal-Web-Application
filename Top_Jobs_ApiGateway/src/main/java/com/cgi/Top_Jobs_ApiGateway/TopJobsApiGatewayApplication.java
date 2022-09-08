package com.cgi.Top_Jobs_ApiGateway;

import com.cgi.Top_Jobs_ApiGateway.filters.ErrorFilter;
import com.cgi.Top_Jobs_ApiGateway.filters.PostFilter;
import com.cgi.Top_Jobs_ApiGateway.filters.PreFilter;
import com.cgi.Top_Jobs_ApiGateway.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class TopJobsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopJobsApiGatewayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}


}
