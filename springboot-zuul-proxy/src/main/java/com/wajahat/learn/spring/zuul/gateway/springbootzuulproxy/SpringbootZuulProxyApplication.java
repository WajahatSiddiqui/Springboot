package com.wajahat.learn.spring.zuul.gateway.springbootzuulproxy;

import com.wajahat.learn.spring.zuul.gateway.springbootzuulproxy.filter.StaticFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringbootZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootZuulProxyApplication.class, args);
	}

	@Bean
	StaticFilter staticFilter() {
		return new StaticFilter();
	}
}
