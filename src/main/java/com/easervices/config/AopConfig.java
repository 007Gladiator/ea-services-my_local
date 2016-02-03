package com.easervices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.easervices.config.aop.LoggingAspect;



@Configuration
@EnableWebMvc
public class AopConfig {
	
	@Bean
	@Autowired
	public LoggingAspect getLoggingAspect()
	{
		return new LoggingAspect();
	}

}
