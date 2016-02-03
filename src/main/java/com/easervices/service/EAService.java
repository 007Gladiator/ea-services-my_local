package com.easervices.service;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
@Component
@ComponentScan(value="com.easervices.dao")
public interface EAService {
	
	public Object process(Map<String, Object> requestParams);
	
}
