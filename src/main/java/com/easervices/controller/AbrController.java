package com.easervices.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easervices.dao.AbrRepo;
import com.easervices.entities.AbrKpiCategory;
import com.easervices.entities.AbrRegionSummary;
import com.easervices.service.AbrSmryService;
import com.easervices.service.AbrKpiCategoryService;


@Controller(value="abr")
@ComponentScan(value="com.easervices")
public class AbrController {
	
	@Autowired
	AbrRepo abrRepo;
	
	@Autowired
	AbrSmryService abrSmryService;
	
	
	@RequestMapping(value="abrsmry", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<AbrRegionSummary>> getAbrSummary(@RequestParam String year, @RequestParam String region)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
		if(year != null && year !="")
		requestParams.put("year", new BigDecimal(year));
		if(region != null && region !="")
		requestParams.put("region", region);
	
		return abrSmryService.process(requestParams);
		
	}
	
	@Autowired
	AbrKpiCategoryService abrKpiCategoryService;
	
	@RequestMapping(value="abrkpicat", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<AbrKpiCategory>> getAbrkpicat(@RequestParam String cat_id, @RequestParam String cat_type)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
		if(cat_id != null && cat_id !="")
		requestParams.put("cat_id",cat_id);
		if(cat_type != null && cat_type !="")
		requestParams.put("cat_type", cat_type);
	
		return abrKpiCategoryService.process(requestParams);
		
	}
}
