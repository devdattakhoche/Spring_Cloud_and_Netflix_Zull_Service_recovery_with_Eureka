package com.example.microservice.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import com.example.microservice.zuul.filter.pre.PreFilter;
import com.example.microservice.zuul.filter.pre.RouteFilter;
import com.example.microservice.zuul.filter.pre.ErrorFilter;
import com.example.microservice.zuul.filter.pre.PostFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApiGatewayApplication {

	@Bean
	 public PreFilter simpleFilter() {
	   return new PreFilter();
	 }
	
	@Bean
	 public RouteFilter routeFilter() {
	   return new RouteFilter();
	 }
	
	@Bean
	 public PostFilter PostFilter() {
	   return new PostFilter();
	 }
	
	@Bean
	 public ErrorFilter errorFilter() {
	   return new ErrorFilter();
	 }
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
	
}
