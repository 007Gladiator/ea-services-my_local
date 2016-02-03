package com.easervices.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.easervices.dao.AbrRepo;
import com.easervices.entities.AbrRegionSummary;



@Component
public class AbrSmryService implements EAService{
	
	@Autowired
	AbrRepo abrRepo;
	
	@Override
	public Map<String, List<AbrRegionSummary>> process(Map<String, Object> requestParams)
	{
		Map<String, List<AbrRegionSummary>> responseMap=null;
		DetachedCriteria criteria = DetachedCriteria.forClass(AbrRegionSummary.class);
		
		// creating criteria for the query
		for(Entry<String, Object> map:requestParams.entrySet())
		{
			criteria.add(Restrictions.eq(map.getKey(), map.getValue()));
		}
		
		System.out.println(criteria.toString());
		
			List<AbrRegionSummary> list = abrRepo.getAbrRegionData(criteria);
			responseMap = new HashMap<String, List<AbrRegionSummary>>();
			responseMap.put("data", list);
		
		return responseMap;
	}

	
	

}
