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
import com.easervices.response.model.SelectInitialReportModel;
import com.easervices.service.EmpService;
import com.easervices.service.SelectInitialReportService;


@Controller(value="sir")
@ComponentScan(value="com.easervices")
public class SelectInitialReportController 
{
	
	@Autowired
	private SelectInitialReportService selectInitialReportService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="selectinit", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<SelectInitialReportModel>> getselectinit(@RequestParam String cat_type)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
		if (cat_type!=null && cat_type !="") {
			
			requestParams.put("cat_type", cat_type.toString());
			
		}
		return (Map<String, List<SelectInitialReportModel>>) selectInitialReportService.process(requestParams);
		
	}
}
