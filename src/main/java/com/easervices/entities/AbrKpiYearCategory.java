package com.easervices.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AbrKpiYearCategory implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="REPORT_YEAR")
	 private String REPORT_YEAR;
	@Column(name="CAT_TYPE")
	 private String CAT_TYPE;
	@Column(name="CAT_ID")
	 private String CAT_ID;
	@Column(name="REGION")
	 private String REGION;
	@Column(name="REGION_CNT")
	 private BigDecimal REGION_CNT;
	@Column(name="CHANNEL")
	 private String CHANNEL;
	@Column(name="CHANNEL_CNT")
	 private BigDecimal CHANNEL_CNT;
	@Column(name="RVP_CODE")
	 private String RVP_CODE;
	@Column(name="RVP_CODE_CNT")
	 private BigDecimal RVP_CODE_CNT;
	@Column(name="BRANCH_CODE")
	 private String BRANCH_CODE;
	@Column(name="BRANCH_CODE_CNT")
	 private BigDecimal BRANCH_CODE_CNT;
	@Column(name="CREATE_DATE")
	 private String CREATE_DATE;
	@Column(name="UPDATE_DATE")
	private String UPDATE_DATE;
	public String getREPORT_YEAR() {
		return REPORT_YEAR;
	}
	public void setREPORT_YEAR(String rEPORT_YEAR) {
		REPORT_YEAR = rEPORT_YEAR;
	}
	public String getCAT_TYPE() {
		return CAT_TYPE;
	}
	public void setCAT_TYPE(String cAT_TYPE) {
		CAT_TYPE = cAT_TYPE;
	}
	public String getCAT_ID() {
		return CAT_ID;
	}
	public void setCAT_ID(String cAT_ID) {
		CAT_ID = cAT_ID;
	}
	public String getREGION() {
		return REGION;
	}
	public void setREGION(String rEGION) {
		REGION = rEGION;
	}
	public BigDecimal getREGION_CNT() {
		return REGION_CNT;
	}
	public void setREGION_CNT(BigDecimal rEGION_CNT) {
		REGION_CNT = rEGION_CNT;
	}
	public String getCHANNEL() {
		return CHANNEL;
	}
	public void setCHANNEL(String cHANNEL) {
		CHANNEL = cHANNEL;
	}
	public BigDecimal getCHANNEL_CNT() {
		return CHANNEL_CNT;
	}
	public void setCHANNEL_CNT(BigDecimal cHANNEL_CNT) {
		CHANNEL_CNT = cHANNEL_CNT;
	}
	public String getRVP_CODE() {
		return RVP_CODE;
	}
	public void setRVP_CODE(String rVP_CODE) {
		RVP_CODE = rVP_CODE;
	}
	public BigDecimal getRVP_CODE_CNT() {
		return RVP_CODE_CNT;
	}
	public void setRVP_CODE_CNT(BigDecimal rVP_CODE_CNT) {
		RVP_CODE_CNT = rVP_CODE_CNT;
	}
	public String getBRANCH_CODE() {
		return BRANCH_CODE;
	}
	public void setBRANCH_CODE(String bRANCH_CODE) {
		BRANCH_CODE = bRANCH_CODE;
	}
	public BigDecimal getBRANCH_CODE_CNT() {
		return BRANCH_CODE_CNT;
	}
	public void setBRANCH_CODE_CNT(BigDecimal bRANCH_CODE_CNT) {
		BRANCH_CODE_CNT = bRANCH_CODE_CNT;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}

	
}
