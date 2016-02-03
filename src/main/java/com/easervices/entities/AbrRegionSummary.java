package com.easervices.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ABR_REGION_SUMMARY")
public class AbrRegionSummary implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="S_NO")
	private BigDecimal id;	
	@Column(name="YEAR")
	private BigDecimal year;
	
	@Column(name="REGION")
	private String region;
	
	@Column(name="CLICKS")
	private BigDecimal clicks;
	
	@Column(name="VIEWS")
	private BigDecimal views;

	public BigDecimal getYear() {
		return year;
	}

	public String getRegion() {
		return region;
	}

	public BigDecimal getClicks() {
		return clicks;
	}

	public BigDecimal getViews() {
		return views;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setClicks(BigDecimal clicks) {
		this.clicks = clicks;
	}

	public void setViews(BigDecimal views) {
		this.views = views;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "RegionSummary:["+this.getYear()+","+this.getRegion()+","+this.getClicks()+","+this.getViews()+"]";
	}
	
	
	
	

}