package com.easervices.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.easervices.entities.AbrKpiCategory;
import com.easervices.entities.AbrRegionSummary;
import com.easervices.response.model.DepartmentChartModel;
import com.easervices.response.model.SelectInitialReportModel;

@Repository
@ComponentScan(value="com.easervices")
public class AbrRepo {

	private static Logger logger = Logger.getLogger(AbrRepo.class);
	@Autowired(required=true)
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private DepartmentChartModel dChartModel;
	
	@Autowired
	private SelectInitialReportModel selectinitModel;
	
	
	
	public AbrRepo()
	{
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AbrRegionSummary> getAbrRegionData(DetachedCriteria criteria)
	{
		
		return (List<AbrRegionSummary>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<AbrKpiCategory> getAbrKpiCategoryData(DetachedCriteria criteria)
	{
		
		return (List<AbrKpiCategory>) this.hibernateTemplate.findByCriteria(criteria);
	}
	
	
	
	
	
	/*
	 * This method is to fetch the data from the db using native sqls.
	 * 
	 * 
	 * */
	public List getNativeQueryData(String sql)
	{
		SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql);
		List list = query.list();
		return list;
		//return (List<DepartmentChartModel>) this.hibernateTemplate.findByValueBean(sql, dChartModel);
	}

	
}
