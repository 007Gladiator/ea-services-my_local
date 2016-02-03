package com.easervices.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="ABR_KPI_CATEGORY")
@NamedQuery(name="SelectInitialReportPOJO.findAll", query="SELECT g FROM SelectInitialReportPOJO g")
public class SelectInitialReportPOJO implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="cat_id")
	private String cat_id;

    @Column(name="cat_type")
	private String cat_type;	
	
	@Column(name="cat_name")
	private String cat_name;
	
	@Column(name="ovrd_cat_name")
	private String ovrd_cat_name;
	
	@Transient
	private String product_type = "I";
	
	@Transient
	private String report_type = "M";
	@Temporal (TemporalType.DATE)
	@Column(name="create_date")
	private Date create_date;
  
    @Column(name="update_date")
	private Date update_date;
	
/*	@Embedded
	private AbrDataDates abrdatadates;
	*/
	public String getcat_id() {
		return cat_id;
	}

	public String getcat_type() {
		return cat_type;
	}
    
	public String getcat_name() {
		return cat_name;
	}
		
	public String getovrd_cat_name() {
		return ovrd_cat_name;
	}

  	public String getproduct_type() {
		return product_type;
	}
	
	public String getreport_type() {
		return report_type;
	}

//	public Date getcreate_date() {
//		return create_date;
//	}
//	
//	public Date getupdate_date() {
//		return update_date;
//	}

	public void setcat_type(String cat_type) {
		this.cat_type = cat_type;
	}

	public void setcreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public void setupdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public void setcat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public void setcat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public void setovrd_cat_name(String ovrd_cat_name) {
		this.ovrd_cat_name = ovrd_cat_name;
	}
    
	public void setproduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	public void setreport_type(String report_type) {
		this.report_type = report_type;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	
}