package com.easervices.service;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easervices.dao.AbrRepo;
import com.easervices.response.format.StringFormatter;
import com.easervices.response.model.DepartmentChartModel;
import com.easervices.response.model.SelectInitialReportModel;

import oracle.sql.DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Component
public class SelectInitialReportService implements EAService {

	private static Logger logger = Logger.getLogger(SelectInitialReportService.class);

	@Autowired
	private AbrRepo abrRepo;

	@Autowired
	private SelectInitialReportModel selectinitModel;

	@Override
	public Map<String, List<SelectInitialReportModel>> process(
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
		String query = "SELECT  CAT_TYPE,CAT_ID,CAT_NAME,OVRD_CAT_NAME,'I' PRODUCT_TYPE,"
				+ "			'M' REPORT_TYPE,to_char(CREATE_DATE),to_char(UPDATE_DATE),"
				+ " SUBSTR((SELECT MAX(CUR_RPT_MTH) FROM ABR_DATA_DATES),1,4) REPORT_YEAR, "
				+ " TO_CHAR(TO_DATE((SELECT MAX(CUR_RPT_MTH) FROM ABR_DATA_DATES),'YYYYMM'),'MM/DD/YYYY') REPORT_PERIOD "
				+ " FROM  ABR_KPI_CATEGORY "
						+ where ;
						//+ "CAT_TYPE = 'rvp_code' ";
							return query;
	}

	@SuppressWarnings("deprecation")
	private Map<String, List<SelectInitialReportModel>> prepareResponse(List data) {

		List<SelectInitialReportModel> list = new ArrayList<SelectInitialReportModel>();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Object[] tuple = (Object[]) iterator.next();
			list.add(new SelectInitialReportModel( tuple[0] + "",tuple[1] + "", tuple[2] + "",  tuple[3] + "",
					tuple[4] + "",tuple[5] + "",(String) tuple[6] + "",(String) tuple[7] + "",tuple[8] + "",tuple[9] + ""));

		}

		Map<String, List<SelectInitialReportModel>> map = new HashMap<String, List<SelectInitialReportModel>>();
		map.put("data", list);
		return map;

	}

}
