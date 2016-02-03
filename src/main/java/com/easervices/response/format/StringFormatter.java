package com.easervices.response.format;

import com.google.common.base.CaseFormat;

public class StringFormatter {
	
	public static String underScoreToVar(String value)
	{
		if(value==null)
			throw new NullPointerException("parameter is null");
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, value.toLowerCase());
	}
	
	public static String varToUnderScore(String value)
	{
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, value);
		
	}

}
