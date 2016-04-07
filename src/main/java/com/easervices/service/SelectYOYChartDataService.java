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
import com.easervices.response.model.SelectYOYChartDataModel;

import oracle.sql.DATE;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

@Component
public class SelectYOYChartDataService implements EAService {
	
	private String report_year; //= "'2015'";
	private String report_type; //= "'M'";
	private String region; //= "'Southeast'";
	private String rvp_code; //= "'SC2'";
	private String channel; //= "'Premise'";
	private String branch_code; //= "'AS'";
	private String data_field;
	//private String report_period;
	//private String cat_id;
	//private String cat_type;
	

	private static Logger logger = Logger.getLogger(SelectInitialReportService.class);

	@Autowired
	private AbrRepo abrRepo;

	@Autowired
	private SelectYOYChartDataModel selectYOYChartDataModel;

	@Override
	public Map<String, List<SelectYOYChartDataModel>> process(
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
            if(key == "data_field")
            	data_field = "'"+(String) entry.getValue()+"'";
           // List<Object> values =  (List<Object>) entry.getValue();
            System.out.println("Key = " + key);
            System.out.println("Values = "+entry.getValue());
            System.out.println("value from report_year = "+report_year);
            System.out.println("value from report_type = "+report_type);
            System.out.println("value from report_period = "+region);
            System.out.println("value from rvp_code = "+rvp_code);
            System.out.println("value from channel = "+channel);
            System.out.println("value from branch_code = "+branch_code);
            System.out.println("value from data_field = "+data_field);
            
        }

		return prepareResponse(abrRepo.getNativeQueryData(buildQuery(where)));
	}

	public String buildQuery(String where) {
		if(where !=null && where !="")
			where = "WHERE "+where;
		String query =  " with report_periods as "
				 + " (select    data_field "
				 + "          , report_type "  
				 + "          , (case when report_type in ('X','M') then add_months(end_report_period, -(level-1)) "
				 + "                  when report_type = 'W' then end_report_period - ((level-1)*7) "
				// + "                  --when report_type = 'D' then start_report_period + (level-1) "
				 + "             end) report_period "
				 + "          , (case when report_type in ('X','M') then add_months(end_report_period, -(level-1) - 12) "
				 + "                  when report_type = 'W' then trunc(add_months(end_report_period - ((level-1)*7), -12),'DAY') + 1 "
				// + "                  --when report_type = 'D' then start_report_period + (level-1) "
				 + "             end) prev_report_period "
				 // Hard coded data field = 'AYUSH' instead of input
				 + "  from      (select  "+data_field+" data_field , "
				 + "                    report_type "
				 + "                   , "+report_year+" report_year "
				 + "                   , (case report_type when 'X' then to_date('01'||"+report_year+",'MMYYYY') "
				 + "                                       when 'M' then to_date('01'||"+report_year+",'MMYYYY') "
				 + "                                       when 'W' then least(trunc(to_date('0101'||"+report_year+",'MMDDYYYY'),'DAY'), data_date-91) "
				 + "                      end) start_report_period "
				 + "                   , (case report_type when 'X' then to_date('12'||"+report_year+",'MMYYYY') "
				 + "                                       when 'M' then to_date('12'||"+report_year+",'MMYYYY') "
				 + "                                       when 'W' then least(trunc(to_date('1231'||"+report_year+",'MMDDYYYY'),'DAY'), data_date) "
				 + "                      end) end_report_period "
				 + "              from   (select max(data_date) data_date "
				 + "                           , nvl(nullif("+report_type+", 'Y'),'M') report_type "
				 + "                      from   abr_data_dates) t "
				 + "             ) "
				 + "  where      level <= 12 "
				 + "  connect by level <= (case when report_type='X' then (months_between(end_report_period, start_report_period) + 1) "
				 + "                            when report_type='M' then (months_between(end_report_period, start_report_period) + 1) "
				 + "                            when report_type='W' then ((end_report_period-start_report_period)/7)+1 "
				// + "                            --when report_type='D' then end_report_period-start_report_period "
				 + "                       end) "
				 + "  order by 3 "
				 + " ) "
				+  " select   to_char(p.prev_report_period,'MM/DD/YYYY') prev_kpi_date "
				 + "        , (case when p.report_type in ('X','M') then to_char(p.prev_report_period,'Mon') "
				 + "                when p.report_type = 'W' then to_char(p.prev_report_period,'Mon FMDD') "
				// + "                --when p.report_type = 'D' then to_char(p.prev_report_period,'Mon D') "
				 + "           end)  prev_kpi_date_lbl "
				 + "        , to_char(p.prev_report_period,'YYYY') prev_kpi_lbl "
				 + "        , nvl(prev.kpi_val,0) prev_kpi_val "
				 + "        , to_char(p.report_period,'MM/DD/YYYY') kpi_date "
				 + "        , (case when p.report_type in ('X','M') then to_char(p.report_period,'Mon') "
				 + "                when p.report_type = 'W' then to_char(p.report_period,'Mon FMDD') "
				// + "                --when p.report_type = 'D' then to_char(p.report_period,'Mon D') "
				 + "           end)  kpi_date_lbl " 
				 + "        , to_char(p.report_period,'YYYY') kpi_lbl "
				 + "        , nvl(curr.kpi_val,0) kpi_val "
				 + " from     report_periods p "
				 + "          left outer join "
				 + "          (select   p.report_period " 
				 + "                  , nvl(case p.data_field "
				 + "                           when 'hdl_amt' then sum(curr.hdl_amt) "
				 + "                           when 'sld_amt' then sum(curr.sld_amt) "
				 + "                           when 'net_amt' then sum(curr.net_amt) "
				 + "                           when 'net_srv_pct' then round(case when sum(curr.hdl_amt) = 0 then 0 else sum(curr.net_amt)/sum(curr.hdl_amt) end,3)*100 "
				 + "                           when 'sld_chg_amt' then sum(curr.sld_amt) - sum(curr.prev_sld_amt) "
				 + "                           when 'net_pct_growth' then round(case when sum(curr.prev_sld_amt) <= 0 and sum(curr.sld_amt) = 0 then 0 "
				 + "                                                                 when sum(curr.prev_sld_amt) <= 0 then 1 "
				 + "                                                                 else round(sum(curr.sld_amt)/sum(curr.prev_sld_amt),4) - 1 "
				 + "                                                            end,3)*100 "
				 + "                           when 'new_amt' then sum(curr.new_amt) "
				 + "                           when 'inc_amt' then sum(curr.inc_amt) "
				 + "                           when 'obl_amt' then sum(curr.obl_amt) "
				 + "                           when 'hdl_obj' then sum(curr.hdl_obj) "
				 + "                           when 'sld_obj' then sum(curr.sld_obj) "
				 + "                           when 'yoy_hdl_amt' then sum(hdl_amt) - sum(prev_hdl_amt) "
				 + "                           when 'yoy_sld_amt' then sum(sld_amt) - sum(prev_sld_amt) "
				 + "                           when 'yoy_net_amt' then sum(net_amt) - sum(prev_net_amt) "
				 + "                           when 'yoy_new_amt' then sum(new_amt) - sum(prev_new_amt) "
				 + "                           when 'yoy_inc_amt' then sum(inc_amt) - sum(prev_inc_amt) "
				 + "                           when 'yoy_obl_amt' then sum(obl_amt) - sum(prev_obl_amt) "
				 + "                           when 'yoy_net_pct' then ((case when sum(hdl_amt) = 0 then 0 else round(sum(net_amt)/sum(hdl_amt),3) end) - (case when sum(prev_hdl_amt) = 0 then 0 else round(sum(prev_net_amt)/sum(prev_hdl_amt),3) end)) * 100 "
				 + "                        end, 0) kpi_val " 
				 + "           from     report_periods p " 
				 + "                    left outer join "
				 + "                       (select /*+ parallel(s,4) */ s.* "
				 + "                            , (case when 'I' in ('C','I') then iyp_hdl_amt else 0 end) + (case when 'I' in ('C','P') then yp_hdl_amt else 0 end) hdl_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_sld_amt else 0 end) + (case when 'I' in ('C','P') then yp_sld_amt else 0 end) sld_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_net_amt else 0 end) + (case when 'I' in ('C','P') then yp_net_amt else 0 end) net_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_inc_amt else 0 end) + (case when 'I' in ('C','P') then yp_inc_amt else 0 end) inc_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_new_amt else 0 end) + (case when 'I' in ('C','P') then yp_new_amt else 0 end) new_amt " 
				 + "                            , (case when 'I' in ('C','I') then iyp_obl_amt else 0 end) + (case when 'I' in ('C','P') then yp_obl_amt else 0 end) obl_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_hdl_amt else 0 end) + (case when 'I' in ('C','P') then prev_yp_hdl_amt else 0 end) prev_hdl_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_sld_amt else 0 end) + (case when 'I' in ('C','P') then prev_yp_sld_amt else 0 end) prev_sld_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_net_amt else 0 end) + (case when 'I' in ('C','P') then prev_yp_net_amt else 0 end) prev_net_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_inc_amt else 0 end) + (case when 'I' in ('C','P') then prev_yp_inc_amt else 0 end) prev_inc_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_new_amt else 0 end) + (case when 'I' in ('C','P') then prev_yp_new_amt else 0 end) prev_new_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_obl_amt else 0 end) + (case when 'I' in ('C','P') then prev_yp_obl_amt else 0 end) prev_obl_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_hdl_obj else 0 end) + (case when 'I' in ('C','P') then yp_hdl_obj else 0 end) hdl_obj "
				 + "                            , (case when 'I' in ('C','I') then iyp_sld_obj else 0 end) + (case when 'I' in ('C','P') then yp_sld_obj else 0 end) sld_obj "
				 + "                        from   abr_kpi_smy s "
				 + "                               join abr_kpi_branch b "
				 + "                                 on s.branch_code = b.branch_code "
				 + "                        where  s.report_year = "+report_year+" "
				 + "                        and    s.report_type = nvl(nullif("+report_type+",'Y'),'M') "
				 + "                        and    s.branch_code = nvl("+branch_code+", s.branch_code) "
				 + "                        and    b.adj_channel = nvl("+channel+", b.adj_channel) "
				 + "                        and    b.rvp_code = nvl("+rvp_code+", b.rvp_code) "
				 + "                        and    b.adj_region = nvl("+region+", b.adj_region) "
				 + "                        ) curr "
				 + "                      on p.report_type = curr.report_type " 
				 + "                     and p.report_period = curr.report_period "
				 + "           group by  p.report_period " 
				 + "                   , p.data_field "
				 + "          ) curr "
				 + "            on p.report_period = curr.report_period "
				 + "          left outer join "
				 + "          (select   p.prev_report_period "
				 + "                  , nvl(case p.data_field "
				 + "                           when 'hdl_amt' then sum(prev.hdl_amt) "
				 + "                           when 'sld_amt' then sum(prev.sld_amt) "
				 + "                           when 'net_amt' then sum(prev.net_amt) "
				 + "                           when 'net_srv_pct' then round(case when sum(prev.hdl_amt) = 0 then 0 else sum(prev.net_amt)/sum(prev.hdl_amt) end,3)*100 "
				 + "                           when 'sld_chg_amt' then sum(prev.sld_amt) - sum(prev.prev_sld_amt) "
				 + "                           when 'net_pct_growth' then round(case when sum(prev.prev_sld_amt) <= 0 and sum(prev.sld_amt) = 0 then 0 "
				 + "                                                                 when sum(prev.prev_sld_amt) <= 0 then 1 "
				 + "                                                                 else round(sum(prev.sld_amt)/sum(prev.prev_sld_amt),4) - 1 "
				 + "                                                            end,3)*100 "
				 + "                           when 'new_amt' then sum(prev.new_amt) "
				 + "                           when 'inc_amt' then sum(prev.inc_amt) "
				 + "                           when 'obl_amt' then sum(prev.obl_amt) "
				 + "                           when 'hdl_obj' then sum(prev.hdl_obj) "
				 + "                           when 'sld_obj' then sum(prev.sld_obj) "
				 + "                           when 'yoy_hdl_amt' then sum(hdl_amt) - sum(prev_hdl_amt) "
				 + "                           when 'yoy_sld_amt' then sum(sld_amt) - sum(prev_sld_amt) "
				 + "                           when 'yoy_net_amt' then sum(net_amt) - sum(prev_net_amt) "
				 + "                           when 'yoy_new_amt' then sum(new_amt) - sum(prev_new_amt) "
				 + "                           when 'yoy_inc_amt' then sum(inc_amt) - sum(prev_inc_amt) "
				 + "                           when 'yoy_obl_amt' then sum(obl_amt) - sum(prev_obl_amt) "
				 + "                           when 'yoy_net_pct' then ((case when sum(hdl_amt) = 0 then 0 else round(sum(net_amt)/sum(hdl_amt),3) end) - (case when sum(prev_hdl_amt) = 0 then 0 else round(sum(prev_net_amt)/sum(prev_hdl_amt),3) end)) * 100 "
				 + "                        end, 0) kpi_val "
				 + "           from     report_periods p "
				 + "                    left outer join "
				 + "                       (select /*+ parallel(s,4) */ s.* "
				 + "                            , (case when 'I' in ('C','I') then iyp_hdl_amt else 0 end)/divider + (case when 'I' in ('C','P') then yp_hdl_amt else 0 end)/divider hdl_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_sld_amt else 0 end)/divider + (case when 'I' in ('C','P') then yp_sld_amt else 0 end)/divider sld_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_net_amt else 0 end)/divider + (case when 'I' in ('C','P') then yp_net_amt else 0 end)/divider net_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_inc_amt else 0 end)/divider + (case when 'I' in ('C','P') then yp_inc_amt else 0 end)/divider inc_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_new_amt else 0 end)/divider + (case when 'I' in ('C','P') then yp_new_amt else 0 end)/divider new_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_obl_amt else 0 end)/divider + (case when 'I' in ('C','P') then yp_obl_amt else 0 end)/divider obl_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_hdl_amt else 0 end)/divider + (case when 'I' in ('C','P') then prev_yp_hdl_amt else 0 end)/divider prev_hdl_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_sld_amt else 0 end)/divider + (case when 'I' in ('C','P') then prev_yp_sld_amt else 0 end)/divider prev_sld_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_net_amt else 0 end)/divider + (case when 'I' in ('C','P') then prev_yp_net_amt else 0 end)/divider prev_net_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_inc_amt else 0 end)/divider + (case when 'I' in ('C','P') then prev_yp_inc_amt else 0 end)/divider prev_inc_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_new_amt else 0 end)/divider + (case when 'I' in ('C','P') then prev_yp_new_amt else 0 end)/divider prev_new_amt "
				 + "                            , (case when 'I' in ('C','I') then prev_iyp_obl_amt else 0 end)/divider + (case when 'I' in ('C','P') then prev_yp_obl_amt else 0 end)/divider prev_obl_amt "
				 + "                            , (case when 'I' in ('C','I') then iyp_hdl_obj else 0 end)/divider + (case when 'I' in ('C','P') then yp_hdl_obj else 0 end)/divider hdl_obj "
				 + "                            , (case when 'I' in ('C','I') then iyp_sld_obj else 0 end)/divider + (case when 'I' in ('C','P') then yp_sld_obj else 0 end)/divider sld_obj "
				 + "                            , (case when nvl(nullif("+report_type+",'Y'),'M') in ('Y','M','X') then add_months(to_date(d.fut_hist_mth,'YYYYMM'),-12) "
				 + "                                    else d.data_date " 
				 + "                               end) report_period2 "
				 + "                        from   abr_kpi_smy s "
				 + "                               join abr_kpi_branch b "
				 + "                                 on s.branch_code = b.branch_code "
				 + "                               join (select d.* "
				 + "                                          , (case when "+report_type+" = 'X' then count(distinct data_date) over (partition by d.fut_hist_mth) "
				 + "                                                  else 1 "
				 + "                                             end) divider "
				 + "                                     from   abr_data_dates d) d "
				 + "                                 on s.report_period = d.data_date "
				 + "                        where  s.report_year = to_char("+report_year+"-1) "
				 + "                        and    s.report_type = 'W' "
				 //+ " -- prev year data in future months must be calculated from weekly data! "
				 + "                        and    s.branch_code = nvl("+branch_code+", s.branch_code) "
				 + "                        and    b.adj_channel = nvl("+channel+", b.adj_channel) "
				 + "                        and    b.rvp_code = nvl("+rvp_code+", b.rvp_code) "
				 + "                        and    b.adj_region = nvl("+region+", b.adj_region) "
				 + "                        ) prev "
				 + "                      on p.prev_report_period = prev.report_period2 "
				 + "           group by p.prev_report_period "
				 + "                  , p.data_field "
				 + "          ) prev "
				 + "            on p.prev_report_period = prev.prev_report_period "
				 + " order by p.report_period ";
				 
						// where ;
						//+ "CAT_TYPE = 'rvp_code' ";
							return query;
	}

	@SuppressWarnings("deprecation")
	private Map<String, List<SelectYOYChartDataModel>> prepareResponse(List data) {

		List<SelectYOYChartDataModel> list = new ArrayList<SelectYOYChartDataModel>();
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Object[] tuple = (Object[]) iterator.next();
			list.add(new SelectYOYChartDataModel( tuple[0] + "",tuple[1] + "", tuple[2] + "", new BigDecimal (tuple[3] + ""),
					tuple[4] + "",tuple[5] + "", tuple[6] + "", new BigDecimal(tuple[7] + "")));

		}

		Map<String, List<SelectYOYChartDataModel>> map = new HashMap<String, List<SelectYOYChartDataModel>>();
		map.put("data", list);
		return map;

	}

}
