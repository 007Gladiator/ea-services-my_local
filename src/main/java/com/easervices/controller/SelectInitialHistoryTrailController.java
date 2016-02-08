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
import com.easervices.response.model.SelectInitialHistoryTrailModel;
import com.easervices.response.model.SelectInitialReportModel;
import com.easervices.service.EmpService;
import com.easervices.service.SelectInitialHistoryTrailService;
import com.easervices.service.SelectInitialReportService;


@Controller(value="siht")
@ComponentScan(value="com.easervices")
public class SelectInitialHistoryTrailController 
{
	
	@Autowired
	private SelectInitialHistoryTrailService selectInitialHistoryTrailService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="selectinitHtrail", method= RequestMethod.GET)
	public @ResponseBody Map<String, List<SelectInitialHistoryTrailModel>> getsectinithist(@RequestParam String report_year,String report_type, String report_period,String cat_type, String cat_id)
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
		if (cat_type!=null && cat_type !="") {
			requestParams.put("cat_type", cat_type.toString());
			}
		if (cat_id!=null && cat_id !="") {
			requestParams.put("cat_id", cat_id.toString());
			}
		return (Map<String, List<SelectInitialHistoryTrailModel>>) selectInitialHistoryTrailService.process(requestParams);
		
	}
}