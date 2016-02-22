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
import com.easervices.response.model.SelectReportDataModel;

import oracle.sql.DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Component
public class SelectReportDataService implements EAService {
	
	private String report_year;// = "'2015'";
	private String report_type;// = "'M'";
	private String region;// = "'Southeast'";
	private String rvp_code;// = "'SC2'";
	private String channel;// = "'Premise'";
	private String branch_code;// = "'AS'";
	private String report_period;// = "'01-02-2015'";
	private String cat_type;// = "rvp_code";
	
	

	private static Logger logger = Logger.getLogger(SelectReportDataService.class);

	@Autowired
	private AbrRepo abrRepo;

	@Autowired
	private SelectReportDataModel selectReportDataModel;

	@Override
	public Map<String, List<SelectReportDataModel>> process(
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
            if(key == "region")
            	region = "'"+(String) entry.getValue()+"'";
            if(key == "rvp_code")
            	rvp_code = "'"+(String) entry.getValue()+"'";
            if(key == "channel")
            	channel = "'"+(String) entry.getValue()+"'";
            if(key == "branch_code")
            	branch_code = "'"+(String) entry.getValue()+"'";
            if(key == "report_period")
            	report_period = "'"+(String) entry.getValue()+"'";
            if(key == "cat_type")
            	cat_type = "'"+(String) entry.getValue()+"'";
           // List<Object> values =  (List<Object>) entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = "+entry.getValue());
            System.out.println("value from report_year = "+report_year);
            System.out.println("value from report_type = "+report_type);
            System.out.println("value from report_period = "+report_period);
            System.out.println("value from cat_type = "+cat_type);
            System.out.println("value from channel = "+channel);
            System.out.println("value from branch_code = "+branch_code);
            System.out.println("value from report_period = "+report_period);
            System.out.println("value from cat_type = "+cat_type);
        }

		return prepareResponse(abrRepo.getNativeQueryData(buildQuery(where)));
	}

	public String buildQuery(String where) {
		if(where !=null && where !="")
			where = "WHERE "+where;
		String query =  " SELECT REPORT_YEAR , "
				+ "       REPORT_PERIOD2 REPORT_PERIOD "
				+ "      , CAT_TYPE "
				+ "      , CAT_ID "
				+"      , CAT_NAME "
				//+"      -- HNDL_AMT "
				+"      , HDL_AMT "
				+"      , PREV_HDL_AMT "
				+"      , (CASE WHEN ROUND(PREV_HDL_AMT) = 0 THEN SIGN(HDL_AMT) "
				+"              ELSE ROUND((ROUND(HDL_AMT)-ROUND(PREV_HDL_AMT))/ABS(ROUND(PREV_HDL_AMT)),4) "
				+"          END) HDL_CHG_PCT "
				+"      , HDL_AMT - PREV_HDL_AMT HDL_CHG_AMT "
				+"      , HDL_OBJ "
				+"      , (CASE WHEN ROUND(HDL_OBJ) = 0 THEN SIGN(HDL_AMT) "
				+"              ELSE ROUND((ROUND(HDL_AMT)-ROUND(HDL_OBJ))/ABS(ROUND(HDL_OBJ)),4) "
				+"          END) HDL_CHG_OBJ_PCT "
				+"      , HDL_AMT - HDL_OBJ HDL_CHG_OBJ_AMT "
				//+"      -- INCREASE_AMT "
				+"      , INC_AMT "
				+"      , PREV_INC_AMT     INC_OBJ "
				+"      , (CASE WHEN ROUND(PREV_INC_AMT) = 0 THEN SIGN(INC_AMT) "
				+"              ELSE ROUND((ROUND(INC_AMT)-ROUND(PREV_INC_AMT))/ABS(ROUND(PREV_INC_AMT)),4) "
				+"          END) INC_CHG_PCT "
				+"      , INC_AMT - PREV_INC_AMT INC_CHG_AMT "
				//+"      -- OBL_AMT "
				+"      , OBL_AMT "
				+"      , PREV_OBL_AMT     OBL_OBJ "
				+"      , (CASE WHEN ROUND(PREV_OBL_AMT) = 0 THEN SIGN(OBL_AMT) "
				+"              ELSE ROUND((ROUND(OBL_AMT)-ROUND(PREV_OBL_AMT))/ABS(ROUND(PREV_OBL_AMT)),4) "
				+"          END) OBL_CHG_PCT "
				+"      , OBL_AMT - PREV_OBL_AMT OBL_CHG_AMT "
				//+"      -- NEW_AMT "
				+"      , NEW_AMT "
				+"      , PREV_NEW_AMT     NEW_OBJ "
				+"      , (CASE WHEN ROUND(PREV_NEW_AMT) = 0 THEN SIGN(NEW_AMT) "
				+"              ELSE ROUND((ROUND(NEW_AMT)-ROUND(PREV_NEW_AMT))/ABS(ROUND(PREV_NEW_AMT)),4) "
				+"          END) NEW_CHG_PCT "
				+"      , NEW_AMT - PREV_NEW_AMT NEW_CHG_AMT "
				//+"      -- SOLD_AMT "
				+"      , SLD_AMT "
				+"      , PREV_SLD_AMT "
				+"      , (CASE WHEN ROUND(PREV_SLD_AMT) = 0 THEN SIGN(SLD_AMT) "
				+"              ELSE ROUND((ROUND(SLD_AMT)-ROUND(PREV_SLD_AMT))/ABS(ROUND(PREV_SLD_AMT)),4) "
				+"          END) SLD_CHG_PCT "
				+"      , SLD_AMT - PREV_SLD_AMT SLD_CHG_AMT "
				+"      , SLD_OBJ "
				+"      , (CASE WHEN ROUND(SLD_OBJ) = 0 THEN SIGN(SLD_AMT) "
				+"              ELSE ROUND((ROUND(SLD_AMT)-ROUND(SLD_OBJ))/ABS(ROUND(SLD_OBJ)),4) "
				+"          END) SLD_CHG_OBJ_PCT "
				+"      , SLD_AMT - SLD_OBJ SLD_CHG_OBJ_AMT "
				//+"      -- NET_AMT "
				+"      , NET_AMT "
				+"      , PREV_NET_AMT "
				+"      , (CASE WHEN ROUND(PREV_NET_AMT) = 0 THEN SIGN(SLD_AMT) "
				+"              ELSE ROUND((ROUND(NET_AMT)-ROUND(PREV_NET_AMT))/ABS(ROUND(PREV_NET_AMT)),4) "
				+"          END) NET_CHG_PCT "
				+"      , NET_AMT - PREV_NET_AMT NET_CHG_AMT "
				+"      , NET_OBJ "
				+"      , (CASE WHEN ROUND(NET_OBJ) = 0 THEN SIGN(NET_AMT) "
				+"              ELSE ROUND((ROUND(NET_AMT)-ROUND(NET_OBJ))/ABS(ROUND(NET_OBJ)),4) "
				+"          END) NET_CHG_OBJ_PCT "
				+"      , NET_AMT - NET_OBJ NET_CHG_OBJ_AMT "
				+"      , ROUND((CASE WHEN PREV_HDL_AMT = 0 THEN 0 ELSE PREV_NET_AMT/PREV_HDL_AMT END), 4) PREV_NET_SRV_PCT "
				+"      , ROUND((CASE WHEN HDL_AMT = 0 THEN 0 ELSE NET_AMT/HDL_AMT END), 4) NET_SRV_PCT "
				+"      , (CASE WHEN ROUND(PREV_SLD_AMT) = 0 THEN SIGN(SLD_AMT)  "
				+"              ELSE ROUND(ROUND(SLD_AMT)/ROUND(PREV_SLD_AMT),4) - 1 "
				+"         END) NET_PCT_GROWTH "
				+"      , (CASE WHEN HDL_AMT = 0 THEN 0 ELSE ROUND(NET_AMT/HDL_AMT,3) END) - (CASE WHEN PREV_HDL_AMT = 0 THEN 0 ELSE ROUND(PREV_NET_AMT/PREV_HDL_AMT,3) END) YOY_NET_PCT "
				+" FROM   (SELECT   REPORT_YEAR "
				+"                , REPORT_PERIOD2 "
				+"                , CAT_TYPE "
				+"                , CAT_ID "
				+"                , CAT_NAME "
				+"                , SUM(PREV_HDL_AMT)         PREV_HDL_AMT "
				+"                , SUM(PREV_INC_AMT)         PREV_INC_AMT "
				+"                , SUM(PREV_OBL_AMT)         PREV_OBL_AMT "
				+"                , SUM(PREV_NEW_AMT)         PREV_NEW_AMT "
				+"                , SUM(PREV_SLD_AMT)         PREV_SLD_AMT "
				+"                , SUM(PREV_NET_AMT)         PREV_NET_AMT "
				+"                , SUM(HDL_AMT)              HDL_AMT "
				+"                , SUM(INC_AMT)              INC_AMT "
				+"                , SUM(OBL_AMT)              OBL_AMT "
				+"                , SUM(NEW_AMT)              NEW_AMT "
				+"                , SUM(SLD_AMT)              SLD_AMT "
				+"                , SUM(NET_AMT)              NET_AMT "
				+"                , SUM(HDL_OBJ)              HDL_OBJ "
				+"                , SUM(SLD_OBJ)              SLD_OBJ "
				+"                , SUM(SLD_OBJ-HDL_OBJ)      NET_OBJ "
				+"                , SUM(HDL_AMT-PREV_HDL_AMT) YOY_HDL_CHG "
				+"                , SUM(INC_AMT-PREV_INC_AMT) YOY_INC_CHG "
				+"                , SUM(OBL_AMT-PREV_OBL_AMT) YOY_OBL_CHG "
				+"                , SUM(NEW_AMT-PREV_NEW_AMT) YOY_NEW_CHG "
				+"                , SUM(SLD_AMT-PREV_SLD_AMT) YOY_SLD_CHG "
				+"                , SUM(NET_AMT-PREV_NET_AMT) YOY_NET_CHG "
				+"         FROM     (SELECT  D.REPORT_YEAR "
				+"                         , D.REPORT_PERIOD2 "
				+"                         , D.CAT_TYPE "
				+"                         , D.CAT_ID "
				+"                        ,  ABR_KPI_CAT_NAME_FN("+report_year+", "+report_type+", "+report_period+", D.CAT_TYPE, C.CAT_NAME, 'I') CAT_NAME "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN PREV_IYP_HDL_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN PREV_YP_HDL_AMT ELSE 0 END)  PREV_HDL_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN PREV_IYP_INC_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN PREV_YP_INC_AMT ELSE 0 END)   PREV_INC_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN PREV_IYP_OBL_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN PREV_YP_OBL_AMT ELSE 0 END)   PREV_OBL_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN PREV_IYP_NEW_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN PREV_YP_NEW_AMT ELSE 0 END)   PREV_NEW_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN PREV_IYP_SLD_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN PREV_YP_SLD_AMT ELSE 0 END) PREV_SLD_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN PREV_IYP_NET_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN PREV_YP_NET_AMT ELSE 0 END)   PREV_NET_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_HDL_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_HDL_AMT ELSE 0 END)           HDL_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_INC_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_INC_AMT ELSE 0 END)   INC_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_OBL_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_OBL_AMT ELSE 0 END)             OBL_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_NEW_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_NEW_AMT ELSE 0 END)             NEW_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_SLD_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_SLD_AMT ELSE 0 END)           SLD_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_NET_AMT ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_NET_AMT ELSE 0 END)             NET_AMT "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_HDL_OBJ ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_HDL_OBJ ELSE 0 END) HDL_OBJ "
				+"                         , (CASE WHEN 'I' IN ('C','I') THEN IYP_SLD_OBJ ELSE 0 END) + (CASE WHEN 'I' IN ('C','P') THEN YP_SLD_OBJ ELSE 0 END) SLD_OBJ "
				+"                   FROM    (SELECT   NVL("+cat_type+",'all') CAT_TYPE "
				+"                                   , (CASE "+cat_type+" "
				+"                                           WHEN 'branch_code' THEN S.BRANCH_CODE "
				+"                                           WHEN 'channel' THEN B.ADJ_CHANNEL "
				+"                                           WHEN 'rvp_code' THEN B.RVP_CODE "
				+"                                           WHEN 'region' THEN B.ADJ_REGION "
				+"                                           ELSE 'ALL' END) CAT_ID "
				+"                                   , (CASE WHEN "+report_type+" = 'Y' THEN 'YTD' ELSE "+report_period+" END) REPORT_PERIOD2 "
				+"                                   , S.* "
				+"                            FROM     ABR_KPI_SMY S "
				+"                                     JOIN ABR_KPI_BRANCH B "
				+"                                       ON S.BRANCH_CODE = B.BRANCH_CODE "
				+"                            WHERE    S.BRANCH_CODE = NVL("+branch_code+",S.BRANCH_CODE) "
				+"                            AND      B.ADJ_CHANNEL = NVL("+channel+",B.ADJ_CHANNEL) "
				+"                            AND      B.RVP_CODE = NVL("+rvp_code+",B.RVP_CODE) "
				+"                            AND      B.ADJ_REGION = NVL("+region+",B.ADJ_REGION) "
				+"                            AND      S.REPORT_TYPE = "+report_type+" "
				+"                            AND      S.REPORT_YEAR = "+report_year+" "
				+"                            AND      S.REPORT_PERIOD = NVL(TO_DATE((CASE WHEN "+report_type+" = 'Y' THEN NULL ELSE "+report_period+" END),'DD-MM-YYYY'),S.REPORT_PERIOD) "
				+"                           ) D "
				+"                           LEFT OUTER JOIN ABR_KPI_CATEGORY C "
				+"                             ON D.CAT_TYPE = C.CAT_TYPE "
				+"                            AND D.CAT_ID = C.CAT_ID "
				+"                  ) "
				+"         GROUP BY REPORT_YEAR "
				+"                , CAT_NAME "
				+"                , REPORT_PERIOD2 "
				+"                , CAT_ID "
				+"                , CAT_TYPE "
				+"        ) "
				+" ORDER BY REPORT_YEAR "
				+"        , CAT_NAME "
				+"        , SLD_OBJ DESC ";

				 
						// where ;
						//+ "CAT_TYPE = 'rvp_code' ";
							return query;
	}

	@SuppressWarnings("deprecation")
	private Map<String, List<SelectReportDataModel>> prepareResponse(List data) {

		List<SelectReportDataModel> list = new ArrayList<SelectReportDataModel>();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Object[] tuple = (Object[]) iterator.next();
			list.add(new SelectReportDataModel(tuple[0] + "",
					tuple[1] + "",
					tuple[2] + "",
					tuple[3] + "",
					tuple[4] + "",
					tuple[5] + "",
					tuple[6] + "",
					tuple[7] + "",
					tuple[8] + "",
					tuple[9] + "",
					tuple[10] + "",
					tuple[11] + "",
					tuple[12] + "",
					tuple[13] + "",
					tuple[14] + "",
					tuple[15] + "",
					tuple[16] + "",
					tuple[17] + "",
					tuple[18] + "",
					tuple[19] + "",
					tuple[20] + "",
					tuple[21] + "",
					tuple[22] + "",
					tuple[23] + "",
					tuple[24] + "",
					tuple[25] + "",
					tuple[26] + "",
					tuple[27] + "",
					tuple[28] + "",
					tuple[29] + "",
					tuple[30] + "",
					tuple[31] + "",
					tuple[32] + "",
					tuple[33] + "",
					tuple[34] + "",
					tuple[35] + "",
					tuple[36] + "",
					tuple[37] + "",
					tuple[38] + "",
					tuple[39] + "",
					tuple[40] + "",
					tuple[41] + ""));

		}

		Map<String, List<SelectReportDataModel>> map = new HashMap<String, List<SelectReportDataModel>>();
		map.put("data", list);
		return map;

	}

}
