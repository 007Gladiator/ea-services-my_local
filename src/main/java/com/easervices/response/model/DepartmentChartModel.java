package com.easervices.response.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;


@Component
public class DepartmentChartModel {
	
	private BigDecimal departmentId;
	private String departmentName;
	private BigDecimal noOfEmployees;
	
	public DepartmentChartModel()
	{
		
	}
	
	public DepartmentChartModel(BigDecimal departmentId, String departmentName,BigDecimal noOfEmployees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.noOfEmployees = noOfEmployees;
	}
	public BigDecimal getDepartmentId() {
		return departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public BigDecimal getNoOfEmployees() {
		return noOfEmployees;
	}
	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setNoOfEmployees(BigDecimal noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
	@Override
	public String toString() {
		return departmentId+","+departmentName+","+noOfEmployees;
	}
	

	

}
