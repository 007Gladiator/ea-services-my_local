package com.easervices.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="ABR_KPI_SMY")
//@NamedQuery(name="AbrKpiSmy.findAll", query="SELECT g FROM AbrKpiSmy g")
public class AbrKpiSmy implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	  @Column(name="REPORT_TYPE")
		private String report_type;
		
		@Column(name="REPORT_YEAR")
		private String report_year

		;
		@Column(name="REPORT_PERIOD")
		private String report_period

		;
		@Column(name="BRANCH_CODE")
		private String branch_code

		;
		@Column(name="YP_CNT")
		private BigDecimal yp_cnt

		;
		@Column(name="YP_HDL_CNT")
		private BigDecimal yp_hdl_cnt

		;
		@Column(name="YP_SLD_CNT")
		private BigDecimal yp_sld_cnt

		;
		@Column(name="YP_ADV_CNT")
		private BigDecimal yp_adv_cnt

		;
		@Column(name="YP_ADV_HDL_CNT")
		private BigDecimal yp_adv_hdl_cnt

		;
		@Column(name="YP_NEW_CNT")
		private BigDecimal yp_new_cnt

		;
		@Column(name="YP_ASGN_AMT")
		private BigDecimal yp_asgn_amt

		;
		@Column(name="YP_HDL_AMT")
		private BigDecimal yp_hdl_amt

		;
		@Column(name="YP_SLD_AMT")
		private BigDecimal yp_sld_amt

		;
		@Column(name="YP_INC_AMT")
		private BigDecimal yp_inc_amt

		;
		@Column(name="YP_OBL_AMT")
		private BigDecimal yp_obl_amt

		;
		@Column(name="YP_NEW_AMT")
		private BigDecimal yp_new_amt

		;
		@Column(name="YP_NET_AMT")
		private BigDecimal yp_net_amt

		;
		@Column(name="YP_EU_NISD_AMT")
		private BigDecimal yp_eu_nisd_amt

		;
		@Column(name="YP_ED_NISD_AMT")
		private BigDecimal yp_ed_nisd_amt

		;
		@Column(name="YP_ED_BOTS_AMT")
		private BigDecimal yp_ed_bots_amt

		;
		@Column(name="YP_HDL_OBJ")
		private BigDecimal yp_hdl_obj

		;
		@Column(name="YP_SLD_OBJ")
		private BigDecimal yp_sld_obj

		;
		@Column(name="PREV_YP_ASGN_AMT")
		private BigDecimal prev_yp_asgn_amt

		;
		@Column(name="PREV_YP_HDL_AMT")
		private BigDecimal prev_yp_hdl_amt

		;
		@Column(name="PREV_YP_SLD_AMT")
		private BigDecimal prev_yp_sld_amt

		;
		@Column(name="PREV_YP_INC_AMT")
		private BigDecimal prev_yp_inc_amt

		;
		@Column(name="PREV_YP_OBL_AMT")
		private BigDecimal prev_yp_obl_amt

		;
		@Column(name="PREV_YP_NEW_AMT")
		private BigDecimal prev_yp_new_amt

		;
		@Column(name="PREV_YP_NET_AMT")
		private BigDecimal prev_yp_net_amt

		;
		@Column(name="PREV_YP_EU_NISD_AMT")
		private BigDecimal prev_yp_eu_nisd_amt

		;
		@Column(name="PREV_YP_ED_NISD_AMT")
		private BigDecimal prev_yp_ed_nisd_amt

		;
		@Column(name="PREV_YP_ED_BOTS_AMT")
		private BigDecimal prev_yp_ed_bots_amt

		;
		@Column(name="IYP_CNT")
		private BigDecimal iyp_cnt

		;
		@Column(name="IYP_HDL_CNT")
		private BigDecimal iyp_hdl_cnt

		;
		@Column(name="IYP_SLD_CNT")
		private BigDecimal iyp_sld_cnt

		;
		@Column(name="IYP_ADV_CNT")
		private BigDecimal iyp_adv_cnt

		;
		@Column(name="IYP_ADV_HDL_CNT")
		private BigDecimal iyp_adv_hdl_cnt

		;
		@Column(name="IYP_NEW_CNT")
		private BigDecimal iyp_new_cnt

		;
		@Column(name="IYP_ASGN_AMT")
		private BigDecimal iyp_asgn_amt

		;
		@Column(name="IYP_HDL_AMT")
		private BigDecimal iyp_hdl_amt

		;
		@Column(name="IYP_SLD_AMT")
		private BigDecimal iyp_sld_amt

		;
		@Column(name="IYP_INC_AMT")
		private BigDecimal iyp_inc_amt

		;
		@Column(name="IYP_OBL_AMT")
		private BigDecimal iyp_obl_amt

		;
		@Column(name="IYP_NEW_AMT")
		private BigDecimal iyp_new_amt

		;
		@Column(name="IYP_NET_AMT")
		private BigDecimal iyp_net_amt

		;
		@Column(name="IYP_EU_NISD_AMT")
		private BigDecimal iyp_eu_nisd_amt

		;
		@Column(name="IYP_ED_NISD_AMT")
		private BigDecimal iyp_ed_nisd_amt

		;
		@Column(name="IYP_ED_BOTS_AMT")
		private BigDecimal iyp_ed_bots_amt

		;
		@Column(name="IYP_HDL_OBJ")
		private BigDecimal iyp_hdl_obj

		;
		@Column(name="IYP_SLD_OBJ")
		private BigDecimal iyp_sld_obj

		;
		@Column(name="PREV_IYP_ASGN_AMT")
		private BigDecimal prev_iyp_asgn_amt

		;
		@Column(name="PREV_IYP_HDL_AMT")
		private BigDecimal prev_iyp_hdl_amt

		;
		@Column(name="PREV_IYP_SLD_AMT")
		private BigDecimal prev_iyp_sld_amt

		;
		@Column(name="PREV_IYP_INC_AMT")
		private BigDecimal prev_iyp_inc_amt

		;
		@Column(name="PREV_IYP_OBL_AMT")
		private BigDecimal prev_iyp_obl_amt

		;
		@Column(name="PREV_IYP_NEW_AMT")
		private BigDecimal prev_iyp_new_amt

		;
		@Column(name="PREV_IYP_NET_AMT")
		private BigDecimal prev_iyp_net_amt

		;
		@Column(name="PREV_IYP_EU_NISD_AM")
		private BigDecimal prev_iyp_eu_nisd_amt

		;
		@Column(name="PREV_IYP_ED_NISD_AM")
		private BigDecimal prev_iyp_ed_nisd_amt

		;
		@Column(name="PREV_IYP_ED_BOTS_AM")
		private BigDecimal prev_iyp_ed_bots_amt

		;
		@Column(name="TOT_CNT")
		private BigDecimal tot_cnt

		;
		@Column(name="TOT_HDL_CNT")
		private BigDecimal tot_hdl_cnt

		;
		@Column(name="TOT_SLD_CNT")
		private BigDecimal tot_sld_cnt

		;
		@Column(name="TOT_ADV_CNT")
		private BigDecimal tot_adv_cnt

		;
		@Column(name="TOT_ADV_HDL_CNT")
		private BigDecimal tot_adv_hdl_cnt

		;
		@Column(name="TOT_NEW_CNT")
		private BigDecimal tot_new_cnt

		;
		@Column(name="TOT_ASGN_AMT")
		private BigDecimal tot_asgn_amt

		;
		@Column(name="TOT_HDL_AMT")
		private BigDecimal tot_hdl_amt

		;
		@Column(name="TOT_SLD_AMT")
		private BigDecimal tot_sld_amt

		;
		@Column(name="TOT_INC_AMT")
		private BigDecimal tot_inc_amt

		;
		@Column(name="TOT_OBL_AMT")
		private BigDecimal tot_obl_amt

		;
		@Column(name="TOT_NEW_AMT")
		private BigDecimal tot_new_amt

		;
		@Column(name="TOT_NET_AMT")
		private BigDecimal tot_net_amt

		;
		@Column(name="TOT_EU_NISD_AMT")
		private BigDecimal tot_eu_nisd_amt

		;
		@Column(name="TOT_ED_NISD_AMT")
		private BigDecimal tot_ed_nisd_amt

		;
		@Column(name="TOT_ED_BOTS_AMT")
		private BigDecimal tot_ed_bots_amt

		;
		@Column(name="TOT_HDL_OBJ")
		private BigDecimal tot_hdl_obj

		;
		@Column(name="TOT_SLD_OBJ")
		private BigDecimal tot_sld_obj

		;
		@Column(name="PREV_TOT_ASGN_AMT")
		private BigDecimal prev_tot_asgn_amt

		;
		@Column(name="PREV_TOT_HDL_AMT")
		private BigDecimal prev_tot_hdl_amt

		;
		@Column(name="PREV_TOT_SLD_AMT")
		private BigDecimal prev_tot_sld_amt

		;
		@Column(name="PREV_TOT_INC_AMT")
		private BigDecimal prev_tot_inc_amt

		;
		@Column(name="PREV_TOT_OBL_AMT")
		private BigDecimal prev_tot_obl_amt

		;
		@Column(name="PREV_TOT_NEW_AMT")
		private BigDecimal prev_tot_new_amt

		;
		@Column(name="PREV_TOT_NET_AMT")
		private BigDecimal prev_tot_net_amt

		;
		@Column(name="PREV_TOT_EU_NISD_AM")
		private BigDecimal prev_tot_eu_nisd_amt

		;
		@Column(name="PREV_TOT_ED_NISD_AM")
		private BigDecimal prev_tot_ed_nisd_amt

		;
		@Column(name="PREV_TOT_ED_BOTS_AM")
		private BigDecimal prev_tot_ed_bots_amt

		;
		@Column(name="LOAD_DATE")
		private String load_date

		;

	
		public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
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
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public BigDecimal getYp_cnt() {
		return yp_cnt;
	}
	public void setYp_cnt(BigDecimal yp_cnt) {
		this.yp_cnt = yp_cnt;
	}
	public BigDecimal getYp_hdl_cnt() {
		return yp_hdl_cnt;
	}
	public void setYp_hdl_cnt(BigDecimal yp_hdl_cnt) {
		this.yp_hdl_cnt = yp_hdl_cnt;
	}
	public BigDecimal getYp_sld_cnt() {
		return yp_sld_cnt;
	}
	public void setYp_sld_cnt(BigDecimal yp_sld_cnt) {
		this.yp_sld_cnt = yp_sld_cnt;
	}
	public BigDecimal getYp_adv_cnt() {
		return yp_adv_cnt;
	}
	public void setYp_adv_cnt(BigDecimal yp_adv_cnt) {
		this.yp_adv_cnt = yp_adv_cnt;
	}
	public BigDecimal getYp_adv_hdl_cnt() {
		return yp_adv_hdl_cnt;
	}
	public void setYp_adv_hdl_cnt(BigDecimal yp_adv_hdl_cnt) {
		this.yp_adv_hdl_cnt = yp_adv_hdl_cnt;
	}
	public BigDecimal getYp_new_cnt() {
		return yp_new_cnt;
	}
	public void setYp_new_cnt(BigDecimal yp_new_cnt) {
		this.yp_new_cnt = yp_new_cnt;
	}
	public BigDecimal getYp_asgn_amt() {
		return yp_asgn_amt;
	}
	public void setYp_asgn_amt(BigDecimal yp_asgn_amt) {
		this.yp_asgn_amt = yp_asgn_amt;
	}
	public BigDecimal getYp_hdl_amt() {
		return yp_hdl_amt;
	}
	public void setYp_hdl_amt(BigDecimal yp_hdl_amt) {
		this.yp_hdl_amt = yp_hdl_amt;
	}
	public BigDecimal getYp_sld_amt() {
		return yp_sld_amt;
	}
	public void setYp_sld_amt(BigDecimal yp_sld_amt) {
		this.yp_sld_amt = yp_sld_amt;
	}
	public BigDecimal getYp_inc_amt() {
		return yp_inc_amt;
	}
	public void setYp_inc_amt(BigDecimal yp_inc_amt) {
		this.yp_inc_amt = yp_inc_amt;
	}
	public BigDecimal getYp_obl_amt() {
		return yp_obl_amt;
	}
	public void setYp_obl_amt(BigDecimal yp_obl_amt) {
		this.yp_obl_amt = yp_obl_amt;
	}
	public BigDecimal getYp_new_amt() {
		return yp_new_amt;
	}
	public void setYp_new_amt(BigDecimal yp_new_amt) {
		this.yp_new_amt = yp_new_amt;
	}
	public BigDecimal getYp_net_amt() {
		return yp_net_amt;
	}
	public void setYp_net_amt(BigDecimal yp_net_amt) {
		this.yp_net_amt = yp_net_amt;
	}
	public BigDecimal getYp_eu_nisd_amt() {
		return yp_eu_nisd_amt;
	}
	public void setYp_eu_nisd_amt(BigDecimal yp_eu_nisd_amt) {
		this.yp_eu_nisd_amt = yp_eu_nisd_amt;
	}
	public BigDecimal getYp_ed_nisd_amt() {
		return yp_ed_nisd_amt;
	}
	public void setYp_ed_nisd_amt(BigDecimal yp_ed_nisd_amt) {
		this.yp_ed_nisd_amt = yp_ed_nisd_amt;
	}
	public BigDecimal getYp_ed_bots_amt() {
		return yp_ed_bots_amt;
	}
	public void setYp_ed_bots_amt(BigDecimal yp_ed_bots_amt) {
		this.yp_ed_bots_amt = yp_ed_bots_amt;
	}
	public BigDecimal getYp_hdl_obj() {
		return yp_hdl_obj;
	}
	public void setYp_hdl_obj(BigDecimal yp_hdl_obj) {
		this.yp_hdl_obj = yp_hdl_obj;
	}
	public BigDecimal getYp_sld_obj() {
		return yp_sld_obj;
	}
	public void setYp_sld_obj(BigDecimal yp_sld_obj) {
		this.yp_sld_obj = yp_sld_obj;
	}
	public BigDecimal getPrev_yp_asgn_amt() {
		return prev_yp_asgn_amt;
	}
	public void setPrev_yp_asgn_amt(BigDecimal prev_yp_asgn_amt) {
		this.prev_yp_asgn_amt = prev_yp_asgn_amt;
	}
	public BigDecimal getPrev_yp_hdl_amt() {
		return prev_yp_hdl_amt;
	}
	public void setPrev_yp_hdl_amt(BigDecimal prev_yp_hdl_amt) {
		this.prev_yp_hdl_amt = prev_yp_hdl_amt;
	}
	public BigDecimal getPrev_yp_sld_amt() {
		return prev_yp_sld_amt;
	}
	public void setPrev_yp_sld_amt(BigDecimal prev_yp_sld_amt) {
		this.prev_yp_sld_amt = prev_yp_sld_amt;
	}
	public BigDecimal getPrev_yp_inc_amt() {
		return prev_yp_inc_amt;
	}
	public void setPrev_yp_inc_amt(BigDecimal prev_yp_inc_amt) {
		this.prev_yp_inc_amt = prev_yp_inc_amt;
	}
	public BigDecimal getPrev_yp_obl_amt() {
		return prev_yp_obl_amt;
	}
	public void setPrev_yp_obl_amt(BigDecimal prev_yp_obl_amt) {
		this.prev_yp_obl_amt = prev_yp_obl_amt;
	}
	public BigDecimal getPrev_yp_new_amt() {
		return prev_yp_new_amt;
	}
	public void setPrev_yp_new_amt(BigDecimal prev_yp_new_amt) {
		this.prev_yp_new_amt = prev_yp_new_amt;
	}
	public BigDecimal getPrev_yp_net_amt() {
		return prev_yp_net_amt;
	}
	public void setPrev_yp_net_amt(BigDecimal prev_yp_net_amt) {
		this.prev_yp_net_amt = prev_yp_net_amt;
	}
	public BigDecimal getPrev_yp_eu_nisd_amt() {
		return prev_yp_eu_nisd_amt;
	}
	public void setPrev_yp_eu_nisd_amt(BigDecimal prev_yp_eu_nisd_amt) {
		this.prev_yp_eu_nisd_amt = prev_yp_eu_nisd_amt;
	}
	public BigDecimal getPrev_yp_ed_nisd_amt() {
		return prev_yp_ed_nisd_amt;
	}
	public void setPrev_yp_ed_nisd_amt(BigDecimal prev_yp_ed_nisd_amt) {
		this.prev_yp_ed_nisd_amt = prev_yp_ed_nisd_amt;
	}
	public BigDecimal getPrev_yp_ed_bots_amt() {
		return prev_yp_ed_bots_amt;
	}
	public void setPrev_yp_ed_bots_amt(BigDecimal prev_yp_ed_bots_amt) {
		this.prev_yp_ed_bots_amt = prev_yp_ed_bots_amt;
	}
	public BigDecimal getIyp_cnt() {
		return iyp_cnt;
	}
	public void setIyp_cnt(BigDecimal iyp_cnt) {
		this.iyp_cnt = iyp_cnt;
	}
	public BigDecimal getIyp_hdl_cnt() {
		return iyp_hdl_cnt;
	}
	public void setIyp_hdl_cnt(BigDecimal iyp_hdl_cnt) {
		this.iyp_hdl_cnt = iyp_hdl_cnt;
	}
	public BigDecimal getIyp_sld_cnt() {
		return iyp_sld_cnt;
	}
	public void setIyp_sld_cnt(BigDecimal iyp_sld_cnt) {
		this.iyp_sld_cnt = iyp_sld_cnt;
	}
	public BigDecimal getIyp_adv_cnt() {
		return iyp_adv_cnt;
	}
	public void setIyp_adv_cnt(BigDecimal iyp_adv_cnt) {
		this.iyp_adv_cnt = iyp_adv_cnt;
	}
	public BigDecimal getIyp_adv_hdl_cnt() {
		return iyp_adv_hdl_cnt;
	}
	public void setIyp_adv_hdl_cnt(BigDecimal iyp_adv_hdl_cnt) {
		this.iyp_adv_hdl_cnt = iyp_adv_hdl_cnt;
	}
	public BigDecimal getIyp_new_cnt() {
		return iyp_new_cnt;
	}
	public void setIyp_new_cnt(BigDecimal iyp_new_cnt) {
		this.iyp_new_cnt = iyp_new_cnt;
	}
	public BigDecimal getIyp_asgn_amt() {
		return iyp_asgn_amt;
	}
	public void setIyp_asgn_amt(BigDecimal iyp_asgn_amt) {
		this.iyp_asgn_amt = iyp_asgn_amt;
	}
	public BigDecimal getIyp_hdl_amt() {
		return iyp_hdl_amt;
	}
	public void setIyp_hdl_amt(BigDecimal iyp_hdl_amt) {
		this.iyp_hdl_amt = iyp_hdl_amt;
	}
	public BigDecimal getIyp_sld_amt() {
		return iyp_sld_amt;
	}
	public void setIyp_sld_amt(BigDecimal iyp_sld_amt) {
		this.iyp_sld_amt = iyp_sld_amt;
	}
	public BigDecimal getIyp_inc_amt() {
		return iyp_inc_amt;
	}
	public void setIyp_inc_amt(BigDecimal iyp_inc_amt) {
		this.iyp_inc_amt = iyp_inc_amt;
	}
	public BigDecimal getIyp_obl_amt() {
		return iyp_obl_amt;
	}
	public void setIyp_obl_amt(BigDecimal iyp_obl_amt) {
		this.iyp_obl_amt = iyp_obl_amt;
	}
	public BigDecimal getIyp_new_amt() {
		return iyp_new_amt;
	}
	public void setIyp_new_amt(BigDecimal iyp_new_amt) {
		this.iyp_new_amt = iyp_new_amt;
	}
	public BigDecimal getIyp_net_amt() {
		return iyp_net_amt;
	}
	public void setIyp_net_amt(BigDecimal iyp_net_amt) {
		this.iyp_net_amt = iyp_net_amt;
	}
	public BigDecimal getIyp_eu_nisd_amt() {
		return iyp_eu_nisd_amt;
	}
	public void setIyp_eu_nisd_amt(BigDecimal iyp_eu_nisd_amt) {
		this.iyp_eu_nisd_amt = iyp_eu_nisd_amt;
	}
	public BigDecimal getIyp_ed_nisd_amt() {
		return iyp_ed_nisd_amt;
	}
	public void setIyp_ed_nisd_amt(BigDecimal iyp_ed_nisd_amt) {
		this.iyp_ed_nisd_amt = iyp_ed_nisd_amt;
	}
	public BigDecimal getIyp_ed_bots_amt() {
		return iyp_ed_bots_amt;
	}
	public void setIyp_ed_bots_amt(BigDecimal iyp_ed_bots_amt) {
		this.iyp_ed_bots_amt = iyp_ed_bots_amt;
	}
	public BigDecimal getIyp_hdl_obj() {
		return iyp_hdl_obj;
	}
	public void setIyp_hdl_obj(BigDecimal iyp_hdl_obj) {
		this.iyp_hdl_obj = iyp_hdl_obj;
	}
	public BigDecimal getIyp_sld_obj() {
		return iyp_sld_obj;
	}
	public void setIyp_sld_obj(BigDecimal iyp_sld_obj) {
		this.iyp_sld_obj = iyp_sld_obj;
	}
	public BigDecimal getPrev_iyp_asgn_amt() {
		return prev_iyp_asgn_amt;
	}
	public void setPrev_iyp_asgn_amt(BigDecimal prev_iyp_asgn_amt) {
		this.prev_iyp_asgn_amt = prev_iyp_asgn_amt;
	}
	public BigDecimal getPrev_iyp_hdl_amt() {
		return prev_iyp_hdl_amt;
	}
	public void setPrev_iyp_hdl_amt(BigDecimal prev_iyp_hdl_amt) {
		this.prev_iyp_hdl_amt = prev_iyp_hdl_amt;
	}
	public BigDecimal getPrev_iyp_sld_amt() {
		return prev_iyp_sld_amt;
	}
	public void setPrev_iyp_sld_amt(BigDecimal prev_iyp_sld_amt) {
		this.prev_iyp_sld_amt = prev_iyp_sld_amt;
	}
	public BigDecimal getPrev_iyp_inc_amt() {
		return prev_iyp_inc_amt;
	}
	public void setPrev_iyp_inc_amt(BigDecimal prev_iyp_inc_amt) {
		this.prev_iyp_inc_amt = prev_iyp_inc_amt;
	}
	public BigDecimal getPrev_iyp_obl_amt() {
		return prev_iyp_obl_amt;
	}
	public void setPrev_iyp_obl_amt(BigDecimal prev_iyp_obl_amt) {
		this.prev_iyp_obl_amt = prev_iyp_obl_amt;
	}
	public BigDecimal getPrev_iyp_new_amt() {
		return prev_iyp_new_amt;
	}
	public void setPrev_iyp_new_amt(BigDecimal prev_iyp_new_amt) {
		this.prev_iyp_new_amt = prev_iyp_new_amt;
	}
	public BigDecimal getPrev_iyp_net_amt() {
		return prev_iyp_net_amt;
	}
	public void setPrev_iyp_net_amt(BigDecimal prev_iyp_net_amt) {
		this.prev_iyp_net_amt = prev_iyp_net_amt;
	}
	public BigDecimal getPrev_iyp_eu_nisd_amt() {
		return prev_iyp_eu_nisd_amt;
	}
	public void setPrev_iyp_eu_nisd_amt(BigDecimal prev_iyp_eu_nisd_amt) {
		this.prev_iyp_eu_nisd_amt = prev_iyp_eu_nisd_amt;
	}
	public BigDecimal getPrev_iyp_ed_nisd_amt() {
		return prev_iyp_ed_nisd_amt;
	}
	public void setPrev_iyp_ed_nisd_amt(BigDecimal prev_iyp_ed_nisd_amt) {
		this.prev_iyp_ed_nisd_amt = prev_iyp_ed_nisd_amt;
	}
	public BigDecimal getPrev_iyp_ed_bots_amt() {
		return prev_iyp_ed_bots_amt;
	}
	public void setPrev_iyp_ed_bots_amt(BigDecimal prev_iyp_ed_bots_amt) {
		this.prev_iyp_ed_bots_amt = prev_iyp_ed_bots_amt;
	}
	public BigDecimal getTot_cnt() {
		return tot_cnt;
	}
	public void setTot_cnt(BigDecimal tot_cnt) {
		this.tot_cnt = tot_cnt;
	}
	public BigDecimal getTot_hdl_cnt() {
		return tot_hdl_cnt;
	}
	public void setTot_hdl_cnt(BigDecimal tot_hdl_cnt) {
		this.tot_hdl_cnt = tot_hdl_cnt;
	}
	public BigDecimal getTot_sld_cnt() {
		return tot_sld_cnt;
	}
	public void setTot_sld_cnt(BigDecimal tot_sld_cnt) {
		this.tot_sld_cnt = tot_sld_cnt;
	}
	public BigDecimal getTot_adv_cnt() {
		return tot_adv_cnt;
	}
	public void setTot_adv_cnt(BigDecimal tot_adv_cnt) {
		this.tot_adv_cnt = tot_adv_cnt;
	}
	public BigDecimal getTot_adv_hdl_cnt() {
		return tot_adv_hdl_cnt;
	}
	public void setTot_adv_hdl_cnt(BigDecimal tot_adv_hdl_cnt) {
		this.tot_adv_hdl_cnt = tot_adv_hdl_cnt;
	}
	public BigDecimal getTot_new_cnt() {
		return tot_new_cnt;
	}
	public void setTot_new_cnt(BigDecimal tot_new_cnt) {
		this.tot_new_cnt = tot_new_cnt;
	}
	public BigDecimal getTot_asgn_amt() {
		return tot_asgn_amt;
	}
	public void setTot_asgn_amt(BigDecimal tot_asgn_amt) {
		this.tot_asgn_amt = tot_asgn_amt;
	}
	public BigDecimal getTot_hdl_amt() {
		return tot_hdl_amt;
	}
	public void setTot_hdl_amt(BigDecimal tot_hdl_amt) {
		this.tot_hdl_amt = tot_hdl_amt;
	}
	public BigDecimal getTot_sld_amt() {
		return tot_sld_amt;
	}
	public void setTot_sld_amt(BigDecimal tot_sld_amt) {
		this.tot_sld_amt = tot_sld_amt;
	}
	public BigDecimal getTot_inc_amt() {
		return tot_inc_amt;
	}
	public void setTot_inc_amt(BigDecimal tot_inc_amt) {
		this.tot_inc_amt = tot_inc_amt;
	}
	public BigDecimal getTot_obl_amt() {
		return tot_obl_amt;
	}
	public void setTot_obl_amt(BigDecimal tot_obl_amt) {
		this.tot_obl_amt = tot_obl_amt;
	}
	public BigDecimal getTot_new_amt() {
		return tot_new_amt;
	}
	public void setTot_new_amt(BigDecimal tot_new_amt) {
		this.tot_new_amt = tot_new_amt;
	}
	public BigDecimal getTot_net_amt() {
		return tot_net_amt;
	}
	public void setTot_net_amt(BigDecimal tot_net_amt) {
		this.tot_net_amt = tot_net_amt;
	}
	public BigDecimal getTot_eu_nisd_amt() {
		return tot_eu_nisd_amt;
	}
	public void setTot_eu_nisd_amt(BigDecimal tot_eu_nisd_amt) {
		this.tot_eu_nisd_amt = tot_eu_nisd_amt;
	}
	public BigDecimal getTot_ed_nisd_amt() {
		return tot_ed_nisd_amt;
	}
	public void setTot_ed_nisd_amt(BigDecimal tot_ed_nisd_amt) {
		this.tot_ed_nisd_amt = tot_ed_nisd_amt;
	}
	public BigDecimal getTot_ed_bots_amt() {
		return tot_ed_bots_amt;
	}
	public void setTot_ed_bots_amt(BigDecimal tot_ed_bots_amt) {
		this.tot_ed_bots_amt = tot_ed_bots_amt;
	}
	public BigDecimal getTot_hdl_obj() {
		return tot_hdl_obj;
	}
	public void setTot_hdl_obj(BigDecimal tot_hdl_obj) {
		this.tot_hdl_obj = tot_hdl_obj;
	}
	public BigDecimal getTot_sld_obj() {
		return tot_sld_obj;
	}
	public void setTot_sld_obj(BigDecimal tot_sld_obj) {
		this.tot_sld_obj = tot_sld_obj;
	}
	public BigDecimal getPrev_tot_asgn_amt() {
		return prev_tot_asgn_amt;
	}
	public void setPrev_tot_asgn_amt(BigDecimal prev_tot_asgn_amt) {
		this.prev_tot_asgn_amt = prev_tot_asgn_amt;
	}
	public BigDecimal getPrev_tot_hdl_amt() {
		return prev_tot_hdl_amt;
	}
	public void setPrev_tot_hdl_amt(BigDecimal prev_tot_hdl_amt) {
		this.prev_tot_hdl_amt = prev_tot_hdl_amt;
	}
	public BigDecimal getPrev_tot_sld_amt() {
		return prev_tot_sld_amt;
	}
	public void setPrev_tot_sld_amt(BigDecimal prev_tot_sld_amt) {
		this.prev_tot_sld_amt = prev_tot_sld_amt;
	}
	public BigDecimal getPrev_tot_inc_amt() {
		return prev_tot_inc_amt;
	}
	public void setPrev_tot_inc_amt(BigDecimal prev_tot_inc_amt) {
		this.prev_tot_inc_amt = prev_tot_inc_amt;
	}
	public BigDecimal getPrev_tot_obl_amt() {
		return prev_tot_obl_amt;
	}
	public void setPrev_tot_obl_amt(BigDecimal prev_tot_obl_amt) {
		this.prev_tot_obl_amt = prev_tot_obl_amt;
	}
	public BigDecimal getPrev_tot_new_amt() {
		return prev_tot_new_amt;
	}
	public void setPrev_tot_new_amt(BigDecimal prev_tot_new_amt) {
		this.prev_tot_new_amt = prev_tot_new_amt;
	}
	public BigDecimal getPrev_tot_net_amt() {
		return prev_tot_net_amt;
	}
	public void setPrev_tot_net_amt(BigDecimal prev_tot_net_amt) {
		this.prev_tot_net_amt = prev_tot_net_amt;
	}
	public BigDecimal getPrev_tot_eu_nisd_amt() {
		return prev_tot_eu_nisd_amt;
	}
	public void setPrev_tot_eu_nisd_amt(BigDecimal prev_tot_eu_nisd_amt) {
		this.prev_tot_eu_nisd_amt = prev_tot_eu_nisd_amt;
	}
	public BigDecimal getPrev_tot_ed_nisd_amts() {
		return prev_tot_ed_nisd_amt;
	}
	public void setPrev_tot_ed_nisd_amt(BigDecimal prev_tot_ed_nisd_amt) {
		this.prev_tot_ed_nisd_amt = prev_tot_ed_nisd_amt;
	}
	public BigDecimal getPrev_tot_ed_bots_amt() {
		return prev_tot_ed_bots_amt;
	}
	public void setPrev_tot_ed_bots_amt(BigDecimal prev_tot_ed_bots_amt) {
		this.prev_tot_ed_bots_amt = prev_tot_ed_bots_amt;
	}
	public String getLoad_date() {
		return load_date;
	}
	public void setLoad_date(String load_date) {
		this.load_date = load_date;
	}
	

}
