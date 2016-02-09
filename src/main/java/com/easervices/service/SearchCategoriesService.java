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
import com.easervices.response.model.SearchCategoriesModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Component
public class SearchCategoriesService implements EAService {
	
	private String report_year;
	private String report_type;
	private String report_period;
	private String cat_name;
	private String search;


	private static Logger logger = Logger.getLogger(SearchCategoriesService.class);

	@Autowired
	private AbrRepo abrRepo;

	@Autowired
	private SearchCategoriesModel searchCategoriesModel;

	@Override
	public Map<String, List<SearchCategoriesModel>> process(
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
            if(key == "cat_name")
            	cat_name = "'"+(String) entry.getValue()+"'";
            if(key == "search")
            	search = "'"+(String) entry.getValue()+"'";
       
           // List<Object> values =  (List<Object>) entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = "+entry.getValue());
            System.out.println("value from report_year = "+report_year);
            System.out.println("value from report_type = "+report_type);
            System.out.println("value from report_period = "+report_period);
            System.out.println("value from cat_name = "+cat_name);
            System.out.println("value from search = "+search);
        }

		return prepareResponse(abrRepo.getNativeQueryData(buildQuery(where)));
	}

	public String buildQuery(String where) {
		if(where !=null && where !="")
			where = " "+where;
		String query =   " SELECT CAT_TYPE , "
				+ "   CAT_ID , "
				+ "   CAT_NAME , "
				+ "   CAT_DESC "
				+ " FROM "
				+ "   (SELECT YC.CAT_TYPE, "
				+ "     YC.CAT_ID , "
				+ "     ABR_KPI_CAT_NAME_FN("+report_year+","+report_type+","+report_period+", C.CAT_TYPE, C.CAT_NAME, 'I') CAT_NAME , "
				+ "     ( "
				+ "     CASE YC.CAT_TYPE "
				+ "       WHEN 'region' "
				+ "       THEN 'Region' "
				+ "       WHEN 'channel' "
				+ "       THEN 'Channel' "
				+ "       WHEN 'rvp_code' "
				+ "       THEN 'RVP' "
				+ "       WHEN 'branch_code' "
				+ "       THEN 'Branch' "
				+ "     end) CAT_DESC , "
				+ "     ROW_NUMBER() over(partition BY 1 order by INSTR(LOWER(C.CAT_NAME), lower("+search+")) , CAT_NAME) RNUM "
				+ "   FROM ABR_KPI_YR_CATEGORIES YC "
				+ "   JOIN ABR_KPI_CATEGORY C "
				+ "   ON YC.CAT_TYPE = C.CAT_TYPE "
				+ "   AND YC.CAT_ID  = C.CAT_ID "
				+ "   where LOWER(ABR_KPI_CAT_NAME_FN("+report_year+","+report_type+","+report_period+", C.CAT_TYPE, C.CAT_NAME, 'I')) like '%' "
				+ "     ||LOWER("+search+") "
				+ "     ||'%' "
				+ "   AND YC.REPORT_YEAR = "+report_year+" "
				+ "   ) "
				+ " WHERE RNUM <= 30 "
				+ " ORDER BY RNUM ";
				//+ where ;
						//+ "CAT_TYPE = 'rvp_code' ";
							return query;
	}

	@SuppressWarnings("deprecation")
	private Map<String, List<SearchCategoriesModel>> prepareResponse(List data) {

		List<SearchCategoriesModel> list = new ArrayList<SearchCategoriesModel>();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Object[] tuple = (Object[]) iterator.next();
			list.add(new SearchCategoriesModel( tuple[0] + "",tuple[1] + "", tuple[2] + "", tuple[3] + ""));

		}

		Map<String, List<SearchCategoriesModel>> map = new HashMap<String, List<SearchCategoriesModel>>();
		map.put("data", list);
		return map;

	}

}
