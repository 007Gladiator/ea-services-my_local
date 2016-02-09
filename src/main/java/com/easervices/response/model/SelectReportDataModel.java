package com.easervices.response.model;

import org.springframework.stereotype.Component;

@Component
public class SelectReportDataModel {


	private String report_year;
	private String report_period;
	private String cat_type;
	private String cat_id;
	private String cat_name;
	private String hdl_amt;
	private String prev_hdl_amt;
	private String hdl_chg_pct;
	private String hdl_chg_amt;
	private String hdl_obj;
	private String hdl_chg_obj_pct;
	private String hdl_chg_obj_amt;
	private String inc_amt;
	private String inc_obj;
	private String inc_chg_pct;
	private String inc_chg_amt;
	private String obl_amt;
	private String obl_obj;
	private String obl_chg_pct;
	private String obl_chg_amt;
	private String new_amt;
	private String new_obj;
	private String new_chg_pct;
	private String new_chg_amt;
	private String sld_amt;
	private String prev_sld_amt;
	private String sld_chg_pct;
	private String sld_chg_amt;
	private String sld_obj;
	private String sld_chg_obj_pct;
	private String sld_chg_obj_amt;
	private String net_amt;
	private String prev_net_amt;
	private String net_chg_pct;
	private String net_chg_amt;
	private String net_obj;
	private String net_chg_obj_pct;
	private String net_chg_obj_amt;
	private String prev_net_srv_pct;
	private String net_srv_pct;
	private String net_pct_growth;
	private String yoy_net_pct;

	public SelectReportDataModel()
		{
			
		}
		
		 public SelectReportDataModel(String report_year,
				 String report_period,
				 String cat_type,
				 String cat_id,
				 String cat_name,
				 String hdl_amt,
				 String prev_hdl_amt,
				 String hdl_chg_pct,
				 String hdl_chg_amt,
				 String hdl_obj,
				 String hdl_chg_obj_pct,
				 String hdl_chg_obj_amt,
				 String inc_amt,
				 String inc_obj,
				 String inc_chg_pct,
				 String inc_chg_amt,
				 String obl_amt,
				 String obl_obj,
				 String obl_chg_pct,
				 String obl_chg_amt,
				 String new_amt,
				 String new_obj,
				 String new_chg_pct,
				 String new_chg_amt,
				 String sld_amt,
				 String prev_sld_amt,
				 String sld_chg_pct,
				 String sld_chg_amt,
				 String sld_obj,
				 String sld_chg_obj_pct,
				 String sld_chg_obj_amt,
				 String net_amt,
				 String prev_net_amt,
				 String net_chg_pct,
				 String net_chg_amt,
				 String net_obj,
				 String net_chg_obj_pct,
				 String net_chg_obj_amt,
				 String prev_net_srv_pct,
				 String net_srv_pct,
				 String net_pct_growth,
				 String yoy_net_pct)
		{
			 this.report_year     = report_year;
			 this.report_period   = report_period;
			 this.cat_type        = cat_type;
			 this.cat_id          = cat_id;
			 this.cat_name        = cat_name;
			 this.hdl_amt         = hdl_amt;
			 this.prev_hdl_amt    = prev_hdl_amt;
			 this.hdl_chg_pct     = hdl_chg_pct;
			 this.hdl_chg_amt     = hdl_chg_amt;
			 this.hdl_obj         = hdl_obj;
			 this.hdl_chg_obj_pct = hdl_chg_obj_pct;
			 this.hdl_chg_obj_amt = hdl_chg_obj_amt;
			 this.inc_amt         = inc_amt;
			 this.inc_obj         = inc_obj;
			 this.inc_chg_pct     = inc_chg_pct;
			 this.inc_chg_amt     = inc_chg_amt;
			 this.obl_amt         = obl_amt;
			 this.obl_obj         = obl_obj;
			 this.obl_chg_pct     = obl_chg_pct;
			 this.obl_chg_amt     = obl_chg_amt;
			 this.new_amt         = new_amt;
			 this.new_obj         = new_obj;
			 this.new_chg_pct     = new_chg_pct;
			 this.new_chg_amt     = new_chg_amt;
			 this.sld_amt         = sld_amt;
			 this.prev_sld_amt    = prev_sld_amt;
			 this.sld_chg_pct     = sld_chg_pct;
			 this.sld_chg_amt     = sld_chg_amt;
			 this.sld_obj         = sld_obj;
			 this.sld_chg_obj_pct = sld_chg_obj_pct;
			 this.sld_chg_obj_amt = sld_chg_obj_amt;
			 this.net_amt         = net_amt;
			 this.prev_net_amt    = prev_net_amt;
			 this.net_chg_pct     = net_chg_pct;
			 this.net_chg_amt     = net_chg_amt;
			 this.net_obj         = net_obj;
			 this.net_chg_obj_pct = net_chg_obj_pct;
			 this.net_chg_obj_amt = net_chg_obj_amt;
			 this.prev_net_srv_pct= prev_net_srv_pct;
			 this.net_srv_pct     =  net_srv_pct;
			 this.net_pct_growth  = net_pct_growth;
			 this.yoy_net_pct     = yoy_net_pct;
			 
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

		public String getCat_type() {
			return cat_type;
		}

		public void setCat_type(String cat_type) {
			this.cat_type = cat_type;
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

		public String getHdl_amt() {
			return hdl_amt;
		}

		public void setHdl_amt(String hdl_amt) {
			this.hdl_amt = hdl_amt;
		}

		public String getPrev_hdl_amt() {
			return prev_hdl_amt;
		}

		public void setPrev_hdl_amt(String prev_hdl_amt) {
			this.prev_hdl_amt = prev_hdl_amt;
		}

		public String getHdl_chg_pct() {
			return hdl_chg_pct;
		}

		public void setHdl_chg_pct(String hdl_chg_pct) {
			this.hdl_chg_pct = hdl_chg_pct;
		}

		public String getHdl_chg_amt() {
			return hdl_chg_amt;
		}

		public void setHdl_chg_amt(String hdl_chg_amt) {
			this.hdl_chg_amt = hdl_chg_amt;
		}

		public String getHdl_obj() {
			return hdl_obj;
		}

		public void setHdl_obj(String hdl_obj) {
			this.hdl_obj = hdl_obj;
		}

		public String getHdl_chg_obj_pct() {
			return hdl_chg_obj_pct;
		}

		public void setHdl_chg_obj_pct(String hdl_chg_obj_pct) {
			this.hdl_chg_obj_pct = hdl_chg_obj_pct;
		}

		public String getHdl_chg_obj_amt() {
			return hdl_chg_obj_amt;
		}

		public void setHdl_chg_obj_amt(String hdl_chg_obj_amt) {
			this.hdl_chg_obj_amt = hdl_chg_obj_amt;
		}

		public String getInc_amt() {
			return inc_amt;
		}

		public void setInc_amt(String inc_amt) {
			this.inc_amt = inc_amt;
		}

		public String getInc_obj() {
			return inc_obj;
		}

		public void setInc_obj(String inc_obj) {
			this.inc_obj = inc_obj;
		}

		public String getInc_chg_pct() {
			return inc_chg_pct;
		}

		public void setInc_chg_pct(String inc_chg_pct) {
			this.inc_chg_pct = inc_chg_pct;
		}

		public String getInc_chg_amt() {
			return inc_chg_amt;
		}

		public void setInc_chg_amt(String inc_chg_amt) {
			this.inc_chg_amt = inc_chg_amt;
		}

		public String getObl_amt() {
			return obl_amt;
		}

		public void setObl_amt(String obl_amt) {
			this.obl_amt = obl_amt;
		}

		public String getObl_obj() {
			return obl_obj;
		}

		public void setObl_obj(String obl_obj) {
			this.obl_obj = obl_obj;
		}

		public String getObl_chg_pct() {
			return obl_chg_pct;
		}

		public void setObl_chg_pct(String obl_chg_pct) {
			this.obl_chg_pct = obl_chg_pct;
		}

		public String getObl_chg_amt() {
			return obl_chg_amt;
		}

		public void setObl_chg_amt(String obl_chg_amt) {
			this.obl_chg_amt = obl_chg_amt;
		}

		public String getNew_amt() {
			return new_amt;
		}

		public void setNew_amt(String new_amt) {
			this.new_amt = new_amt;
		}

		public String getNew_obj() {
			return new_obj;
		}

		public void setNew_obj(String new_obj) {
			this.new_obj = new_obj;
		}

		public String getNew_chg_pct() {
			return new_chg_pct;
		}

		public void setNew_chg_pct(String new_chg_pct) {
			this.new_chg_pct = new_chg_pct;
		}

		public String getNew_chg_amt() {
			return new_chg_amt;
		}

		public void setNew_chg_amt(String new_chg_amt) {
			this.new_chg_amt = new_chg_amt;
		}

		public String getSld_amt() {
			return sld_amt;
		}

		public void setSld_amt(String sld_amt) {
			this.sld_amt = sld_amt;
		}

		public String getPrev_sld_amt() {
			return prev_sld_amt;
		}

		public void setPrev_sld_amt(String prev_sld_amt) {
			this.prev_sld_amt = prev_sld_amt;
		}

		public String getSld_chg_pct() {
			return sld_chg_pct;
		}

		public void setSld_chg_pct(String sld_chg_pct) {
			this.sld_chg_pct = sld_chg_pct;
		}

		public String getSld_chg_amt() {
			return sld_chg_amt;
		}

		public void setSld_chg_amt(String sld_chg_amt) {
			this.sld_chg_amt = sld_chg_amt;
		}

		public String getSld_obj() {
			return sld_obj;
		}

		public void setSld_obj(String sld_obj) {
			this.sld_obj = sld_obj;
		}

		public String getSld_chg_obj_pct() {
			return sld_chg_obj_pct;
		}

		public void setSld_chg_obj_pct(String sld_chg_obj_pct) {
			this.sld_chg_obj_pct = sld_chg_obj_pct;
		}

		public String getSld_chg_obj_amt() {
			return sld_chg_obj_amt;
		}

		public void setSld_chg_obj_amt(String sld_chg_obj_amt) {
			this.sld_chg_obj_amt = sld_chg_obj_amt;
		}

		public String getNet_amt() {
			return net_amt;
		}

		public void setNet_amt(String net_amt) {
			this.net_amt = net_amt;
		}

		public String getPrev_net_amt() {
			return prev_net_amt;
		}

		public void setPrev_net_amt(String prev_net_amt) {
			this.prev_net_amt = prev_net_amt;
		}

		public String getNet_chg_pct() {
			return net_chg_pct;
		}

		public void setNet_chg_pct(String net_chg_pct) {
			this.net_chg_pct = net_chg_pct;
		}

		public String getNet_chg_amt() {
			return net_chg_amt;
		}

		public void setNet_chg_amt(String net_chg_amt) {
			this.net_chg_amt = net_chg_amt;
		}

		public String getNet_obj() {
			return net_obj;
		}

		public void setNet_obj(String net_obj) {
			this.net_obj = net_obj;
		}

		public String getNet_chg_obj_pct() {
			return net_chg_obj_pct;
		}

		public void setNet_chg_obj_pct(String net_chg_obj_pct) {
			this.net_chg_obj_pct = net_chg_obj_pct;
		}

		public String getNet_chg_obj_amt() {
			return net_chg_obj_amt;
		}

		public void setNet_chg_obj_amt(String net_chg_obj_amt) {
			this.net_chg_obj_amt = net_chg_obj_amt;
		}

		public String getPrev_net_srv_pct() {
			return prev_net_srv_pct;
		}

		public void setPrev_net_srv_pct(String prev_net_srv_pct) {
			this.prev_net_srv_pct = prev_net_srv_pct;
		}

		public String getNet_srv_pct() {
			return net_srv_pct;
		}

		public void setNet_srv_pct(String net_srv_pct) {
			this.net_srv_pct = net_srv_pct;
		}

		public String getNet_pct_growth() {
			return net_pct_growth;
		}

		public void setNet_pct_growth(String net_pct_growth) {
			this.net_pct_growth = net_pct_growth;
		}

		public String getYoy_net_pct() {
			return yoy_net_pct;
		}

		public void setYoy_net_pct(String yoy_net_pct) {
			this.yoy_net_pct = yoy_net_pct;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			//fields from ABR_DATA_DATES "+this.getcreate_date()+","+this.getupdate_date()+
			return "sectrdata:["+this.getReport_year()+","+this.getReport_period()+","+this.getCat_type()+","+this.getCat_id()+","+this.getCat_name()+","+this.getHdl_amt()+","+this.getPrev_hdl_amt()+","+this.getHdl_chg_pct()+","+this.getHdl_chg_amt()+","+this.getHdl_obj()+","+this.getHdl_chg_obj_pct()+","+this.getHdl_chg_obj_amt()+","+this.getInc_amt()+","+this.getInc_obj()+","+this.getInc_chg_pct()+","+this.getInc_chg_amt()+","+this.getObl_amt()+","+this.getObl_obj()+","+this.getObl_chg_pct()+","+this.getObl_chg_amt()+","+this.getNew_amt()+","+this.getNew_obj()+","+this.getNew_chg_pct()+","+this.getNew_chg_amt()+","+this.getSld_amt()+","+this.getPrev_sld_amt()+","+this.getSld_chg_pct()+","+this.getSld_chg_amt()+","+this.getSld_obj()+","+this.getSld_chg_obj_pct()+","+this.getSld_chg_obj_amt()+","+this.getNet_amt()+","+this.getPrev_net_amt()+","+this.getNet_chg_pct()+","+this.getNet_chg_amt()+","+this.getNet_obj()+","+this.getNet_chg_obj_pct()+","+this.getNet_chg_obj_amt()+","+this.getPrev_net_srv_pct()+","+this.getNet_srv_pct()+","+this.getNet_pct_growth()+","+this.getYoy_net_pct()+"]";
		}	
	

}
