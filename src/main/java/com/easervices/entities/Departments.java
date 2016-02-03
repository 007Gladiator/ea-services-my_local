package com.easervices.entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author Pallav
 *
 */

@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name="Departments.findAll", query="SELECT d FROM Departments d")
public class Departments implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID")
	private BigDecimal departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="LOCATION_ID")
	private BigDecimal locationId;

	@Column(name="MANAGER_ID")
	private BigDecimal managerId;

	//bi-directional many-to-one association to Employees
	@OneToMany(mappedBy="department")
	private List<Employees> employees;

	public Departments() {
	}

	
	public BigDecimal getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(BigDecimal locationId) {
		this.locationId = locationId;
	}

	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}

	public List<Employees> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public Employees addEmployee(Employees employee) {
		getEmployees().add(employee);
		employee.setDepartment(this);

		return employee;
	}

	public Employees removeEmployee(Employees employee) {
		getEmployees().remove(employee);
		employee.setDepartment(null);

		return employee;
	}

}