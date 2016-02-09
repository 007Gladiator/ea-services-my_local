package com.easervices.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easervices.response.model.SearchCategoriesModel;
import com.easervices.service.SearchCategoriesService;


@Controller(value="srcate")
@ComponentScan(value="com.easervices")
public class SearchCategories 
{
	
	@Autowired
	private SearchCategoriesService searchCategoriesService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="srcate", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<SearchCategoriesModel>> getsrcate(@RequestParam String report_year,String report_type, String report_period,String search)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
		if (report_year!=null && report_year !="") {
			requestParams.put("report_year", report_year.toString());
			}
		if (report_type!=null && report_type !="") {
			requestParams.put("report_type", report_type.toString());
			}
		if (report_period!=null && report_period !="") {
			requestParams.put("report_period", report_period.toString());
			}
		if (search!=null && search !="") {
			requestParams.put("search", search.toString());
			}
		
		return (Map<String, List<SearchCategoriesModel>>) searchCategoriesService.process(requestParams);
		
	}
}