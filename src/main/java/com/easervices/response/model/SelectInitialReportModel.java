package com.easervices.response.model;



import java.util.Date;


import org.springframework.stereotype.Component;


@Component
public class SelectInitialReportModel {
	
	private String cat_id;
	private String cat_name;
	private String cat_type;
	private String  ovrd_cat_name;
	private String	product_type ;
	private String	report_type  ;
	private String	create_date    ;
	private String	update_date    ;
	private String report_year;
	private String report_period;
	public SelectInitialReportModel()
	{
		
	}
	public SelectInitialReportModel(String cat_type,String cat_id, 
			String cat_name,String ovrd_cat_name,String product_type,
			String	report_type,String create_date,String update_date,String report_year,String report_period ) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.cat_type = cat_type;
		this.ovrd_cat_name= ovrd_cat_name;
		this.product_type = product_type;
		this.report_type = report_type;
		this.create_date = create_date;
		this.update_date = update_date;
		this.report_year = report_year;
		this.report_period =  report_period;
	}
	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_type() {
		return cat_type;
	}

	public void setCat_type(String cat_type) {
		this.cat_type = cat_type;
	}

	

	public String getOvrd_cat_name() {
		return ovrd_cat_name;
	}
	public void setOvrd_cat_name(String ovrd_cat_name) {
		this.ovrd_cat_name = ovrd_cat_name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
	
	public String getReport_year() {
		return report_year;
	}
	public void setReport_year(String report_year) {
		this.report_year = report_year;
	}
	
	public String getReport_period() {
		return report_period;
	}
	public void setReport_period(String report_period) {
		this.report_period = report_period;
	}
	@Override
	public String toString() {
		//return cat_id+","+cat_name+","+cat_type;
		return cat_type+","+cat_id+","+cat_name+","+ovrd_cat_name+","+product_type+","+report_type+","+create_date+","+update_date+","+report_year+","+report_period;
	}
	
	
	
	
	

}
