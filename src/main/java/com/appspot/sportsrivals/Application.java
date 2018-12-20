package com.appspot.sportsrivals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	// Workaround for HTTPS href for rest controller when behind Traefik Proxy
	@Bean
	FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter()
	{
		FilterRegistrationBean<ForwardedHeaderFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new ForwardedHeaderFilter());
		return bean;
	}

	// SPRING APPLICATION SETUP
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<Application> applicationClass = Application.class;
}
