package com.easervices.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easervices.dao.AbrRepo;
import com.easervices.response.format.StringFormatter;
import com.easervices.response.model.DepartmentChartModel;
import com.easervices.response.model.SelectInitialHistoryTrailModel;
import com.easervices.response.model.SelectInitialReportModel;

import oracle.sql.DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Component
public class SelectInitialHistoryTrailService implements EAService {
	
	private String report_year;
	private String report_type;
	private String report_period;
	private String cat_type;
	private String cat_id;

	private static Logger logger = Logger.getLogger(SelectInitialHistoryTrailService.class);

	@Autowired
	private AbrRepo abrRepo;

	@Autowired
	private SelectInitialHistoryTrailModel selectinitHistModel;

	@Override
	public Map<String, List<SelectInitialHistoryTrailModel>> process(
			Map<String, Object> requestParams) {

		
		String where = "";
		for (Map.Entry<String, Object> entry : requestParams.entrySet()) {
			where += StringFormatter.varToUnderScore(entry.getKey())
					+ " like '%" + entry.getValue() + "%'";
		}
		for (Map.Entry<String, Object> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            if(key == "report_year")
            	report_year = "'"+(String) entry.getValue()+"'";
            if(key == "report_type")
            	report_type = "'"+(String) entry.getValue()+"'";
            if(key == "report_period")
            	report_period = "'"+(String) entry.getValue()+"'";
            if(key == "cat_type")
            	cat_type = "'"+(String) entry.getValue()+"'";
            if(key == "cat_id")
            	cat_id = "'"+(String) entry.getValue()+"'";
           // List<Object> values =  (List<Object>) entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = "+entry.getValue());
            System.out.println("value from report_year = "+report_year);
            System.out.println("value from report_type = "+report_type);
            System.out.println("value from report_period = "+report_period);
            System.out.println("value from cat_type = "+cat_type);
            System.out.println("value from cat_id = "+cat_id);
            
        }

		return prepareResponse(abrRepo.getNativeQueryData(buildQuery(where)));
	}

	public String buildQuery(String where) {
		if(where !=null && where !="")
			where = " "+where;
		String query =   " SELECT   C.CAT_TYPE, " 
				+ "         C.CAT_ID, " 
				+ "         ABR_KPI_CAT_NAME_FN( "+report_year+","+report_type+","+report_period+", C.CAT_TYPE, C.CAT_NAME, 'I') CAT_NAME " 
				+ " FROM     (SELECT ID " 
				+ "                , C.REPORT_YEAR " 
				+ "                , (CASE WHEN ID = 1 THEN 'all' " 
				+ "                        WHEN ID = 2 THEN 'region' " 
				+ "                        WHEN ID = 3 THEN 'channel' " 
				+ "                        WHEN ID = 4 THEN 'rvp_code' " 
				+ "                        WHEN ID = 5 THEN 'branch_code' END) CAT_TYPE " 
				+ "                , (CASE WHEN ID = 1 THEN 'all' " 
				+ "                        WHEN ID = 2 THEN C.REGION " 
				+ "                        WHEN ID = 3 THEN C.CHANNEL " 
				+ "                        WHEN ID = 4 THEN C.RVP_CODE " 
				+ "                        WHEN ID = 5 THEN C.BRANCH_CODE END) CAT_ID " 
				+ "           FROM   (SELECT LEVEL ID FROM DUAL CONNECT BY LEVEL <= 5) GEN " 
				+ "                , ABR_KPI_YR_CATEGORIES C " 
				+ "           WHERE  C.REPORT_YEAR = "+report_year+" " 
				+ "           AND    C.CAT_TYPE = "+cat_type+" " 
				+ "           AND    C.CAT_ID = "+cat_id+" "
				+ "           AND    (  (C.CAT_TYPE = 'branch_code' AND ID IN (1,2,4)) " 
				+ "                  OR (C.CAT_TYPE = 'rvp_code' AND ID IN (1,2,3)) " 
				+ "                  OR (C.CAT_TYPE = 'channel' AND ID IN (1,2)) " 
				+ "                  OR (C.CAT_TYPE = 'region') ) " 
				+ "          ) A " 
				+ "          JOIN ABR_KPI_YR_CATEGORIES B " 
				+ "            ON A.REPORT_YEAR = B.REPORT_YEAR " 
				+ "           AND A.CAT_TYPE = B.CAT_TYPE " 
				+ "           AND A.CAT_ID = B.CAT_ID " 
				+ "          JOIN ABR_KPI_CATEGORY C " 
				+ "            ON B.CAT_TYPE = C.CAT_TYPE " 
				+ "           AND B.CAT_ID = C.CAT_ID "
				+ " ORDER BY A.ID "; 
				//+ where ;
						//+ "CAT_TYPE = 'rvp_code' ";
							return query;
	}

	@SuppressWarnings("deprecation")
	private Map<String, List<SelectInitialHistoryTrailModel>> prepareResponse(List data) {

		List<SelectInitialHistoryTrailModel> list = new ArrayList<SelectInitialHistoryTrailModel>();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Object[] tuple = (Object[]) iterator.next();
			list.add(new SelectInitialHistoryTrailModel( tuple[0] + "",tuple[1] + "", tuple[2] + ""));

		}

		Map<String, List<SelectInitialHistoryTrailModel>> map = new HashMap<String, List<SelectInitialHistoryTrailModel>>();
		map.put("data", list);
		return map;

	}

}
