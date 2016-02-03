package com.easervices.controller;

import java.math.BigDecimal;
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

import com.easervices.entities.AbrRegionSummary;
import com.easervices.response.model.DepartmentChartModel;
import com.easervices.service.EmpService;


@Controller(value="emp")
@ComponentScan(value="com.easervices")
public class EmpController 
{
	
	@Autowired
	private EmpService empService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="department", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<DepartmentChartModel>> getAbrSummary(@RequestParam String departmentName)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
		if (departmentName!=null && departmentName !="") {
			
			requestParams.put("departmentName", departmentName.toString());
			
		}
		return (Map<String, List<DepartmentChartModel>>) empService.process(requestParams);
		
	}
}
