package com.easervices.service;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easervices.dao.AbrRepo;
import com.easervices.response.format.StringFormatter;
import com.easervices.response.model.DepartmentChartModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Component
public class EmpService implements EAService {

	private static Logger logger = Logger.getLogger(EmpService.class);

	@Autowired
	private AbrRepo abrRepo;

	@Autowired
	private DepartmentChartModel dChartModel;

	@Override
	public Map<String, List<DepartmentChartModel>> process(
			Map<String, Object> requestParams) {

		String where = "";
		for (Map.Entry<String, Object> entry : requestParams.entrySet()) {
			where += StringFormatter.varToUnderScore(entry.getKey())
					+ " like '%" + entry.getValue() + "%'";
		}

		return prepareResponse(abrRepo.getNativeQueryData(buildQuery(where)));
	}

	public String buildQuery(String where) {
		if(where !=null && where !="")
			where = "WHERE "+where;
		String query = "SELECT D.DEPARTMENT_ID departmentid, D.DEPARTMENT_NAME departmentname, COUNT(E.EMPLOYEE_ID) noOfEmployees FROM Departments D "
				+ " JOIN Employees E ON D.DEPARTMENT_ID=E.DEPARTMENT_ID "
				+ where
				+ " GROUP BY D.DEPARTMENT_ID, D.DEPARTMENT_NAME ";
		return query;
	}

	private Map<String, List<DepartmentChartModel>> prepareResponse(List data) {

		List<DepartmentChartModel> list = new ArrayList<DepartmentChartModel>();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Object[] tuple = (Object[]) iterator.next();
			list.add(new DepartmentChartModel(new BigDecimal(tuple[0] + ""),
					tuple[1] + "", new BigDecimal(tuple[2] + "")));

		}

		Map<String, List<DepartmentChartModel>> map = new HashMap<String, List<DepartmentChartModel>>();
		map.put("data", list);
		return map;

	}

}
