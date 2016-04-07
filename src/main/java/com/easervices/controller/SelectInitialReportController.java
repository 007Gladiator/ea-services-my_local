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
import com.easervices.response.model.SelectReportDataModel;
import com.easervices.response.model.SelectYOYChartDataModel;
import com.easervices.service.EmpService;
import com.easervices.service.SelectInitialReportService;
import com.easervices.service.SelectReportDataService;
import com.easervices.service.SelectYOYChartDataService;


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
	
	@Autowired
	private SelectYOYChartDataService selectYOYChartDataService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="sectyoy", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<SelectYOYChartDataModel>> getsectyoy(@RequestParam String report_year ,@RequestParam String report_type ,@RequestParam String region ,@RequestParam String rvp_code ,@RequestParam String channel ,@RequestParam String branch_code , @RequestParam String data_field)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
if (report_year!=null && report_year !="") {
			
			requestParams.put("report_year", report_year.toString());
			
		}
if (report_type!=null && report_type !="") {
			
			requestParams.put("report_type", report_type.toString());
			
		}
if (region!=null && region !="") {
			
			requestParams.put("region", region.toString());
			
		}
if (rvp_code!=null && rvp_code !="") {
			
			requestParams.put("rvp_code", rvp_code.toString());
			
		}
if (channel!=null && channel !="") {
			
			requestParams.put("channel", channel.toString());
			
		}
if (branch_code!=null && branch_code !="") {
			
			requestParams.put("branch_code", branch_code.toString());
			
		}
if (data_field!=null && data_field !="") {
	
	requestParams.put("data_field", data_field.toString());
	
}

		return (Map<String, List<SelectYOYChartDataModel>>) selectYOYChartDataService.process(requestParams);
		
	}
	
	@Autowired
	private SelectReportDataService selectReportDataService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="sectrdata", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<SelectReportDataModel>> getsectrdata(@RequestParam String report_year ,@RequestParam String report_type ,@RequestParam String region ,@RequestParam String rvp_code ,@RequestParam String channel ,@RequestParam String branch_code,@RequestParam String report_period, @RequestParam String cat_type)
	{
		Map<String, Object> requestParams = new HashMap<String, Object>();
		
if (report_year!=null && report_year !="") {
			
			requestParams.put("report_year", report_year.toString());
			
		}
if (report_type!=null && report_type !="") {
			
			requestParams.put("report_type", report_type.toString());
			
		}
if (region!=null && region !="") {
			
			requestParams.put("region", region.toString());
			
		}
if (rvp_code!=null && rvp_code !="") {
			
			requestParams.put("rvp_code", rvp_code.toString());
			
		}
if (channel!=null && channel !="") {
			
			requestParams.put("channel", channel.toString());
			
		}
if (branch_code!=null && branch_code !="") {
			
			requestParams.put("branch_code", branch_code.toString());
			
		}
if (report_period!=null && report_period !="") {
	
	requestParams.put("report_period", report_period.toString());
	
}
if (cat_type!=null && cat_type !="") {
	
	requestParams.put("cat_type", cat_type.toString());
	
}
		return (Map<String, List<SelectReportDataModel>>) selectReportDataService.process(requestParams);
		
	}
	
	
}
