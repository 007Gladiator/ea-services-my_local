package com.easervices.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;



@Entity
@Table(name="ABR_DATA_DATES")
//@NamedQuery(name="AbrKpiDataDates.findAll", query="SELECT g FROM AbrKpiDataDates g")
public class AbrKpiDataDates  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="record_id")
	private BigDecimal record_id;

    @Column(name="data_date")
	private Date data_date;	
	
	@Column(name="cur_rpt_mth")
	private String cur_rpt_mth;
	
	@Column(name="fut_hist_mth")
	private String fut_hist_mth;
	
	

	

	public BigDecimal getRecord_id() {
		return record_id;
	}





	public void setRecord_id(BigDecimal record_id) {
		this.record_id = record_id;
	}





	public Date getData_date() {
		return data_date;
	}





	public void setData_date(Date data_date) {
		this.data_date = data_date;
	}





	public String getCur_rpt_mth() {
		return cur_rpt_mth;
	}





	public void setCur_rpt_mth(String cur_rpt_mth) {
		this.cur_rpt_mth = cur_rpt_mth;
	}





	public String getFut_hist_mth() {
		return fut_hist_mth;
	}





	public void setFut_hist_mth(String fut_hist_mth) {
		this.fut_hist_mth = fut_hist_mth;
	}





	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//fields from ABR_DATA_DATES "+this.getcreate_date()+","+this.getupdate_date()+
		return "KpiDataDates:["+this.getRecord_id()+","+this.getData_date()+","+this.getCur_rpt_mth()+","+this.getFut_hist_mth()+"]";
	}	

}






