package com.easervices.response.model;

import org.springframework.stereotype.Component;

@Component
public class SelectYOYChartDataModel {


private String prev_kpi_date;
private String prev_kpi_date_lbl;
private String prev_kpi_lbl;
private String prev_kpi_val;
private String kpi_date;
private String kpi_date_lbl;
private String kpi_lbl;
private String kpi_val;

	public SelectYOYChartDataModel()
		{
			
		}
		
		 public SelectYOYChartDataModel( String prev_kpi_date,String prev_kpi_date_lbl,String prev_kpi_lbl,String prev_kpi_val,String kpi_date,String kpi_date_lbl,String kpi_lbl,String kpi_val )
		{
			 		this.prev_kpi_date = prev_kpi_date;
					this.prev_kpi_date_lbl = prev_kpi_date_lbl;
					this.prev_kpi_lbl = prev_kpi_lbl;
					this.prev_kpi_val = prev_kpi_val;
					this.kpi_date = kpi_date;
					this.prev_kpi_date_lbl = prev_kpi_date_lbl;
					this.kpi_lbl = kpi_lbl;
					this.kpi_val =kpi_val;
		}

		
		 
		public String getPrev_kpi_date() {
			return prev_kpi_date;
		}

		public void setPrev_kpi_date(String prev_kpi_date) {
			this.prev_kpi_date = prev_kpi_date;
		}

		public String getPrev_kpi_date_lbl() {
			return prev_kpi_date_lbl;
		}

		public void setPrev_kpi_date_lbl(String prev_kpi_date_lbl) {
			this.prev_kpi_date_lbl = prev_kpi_date_lbl;
		}

		public String getPrev_kpi_lbl() {
			return prev_kpi_lbl;
		}

		public void setPrev_kpi_lbl(String prev_kpi_lbl) {
			this.prev_kpi_lbl = prev_kpi_lbl;
		}

		public String getPrev_kpi_val() {
			return prev_kpi_val;
		}

		public void setPrev_kpi_val(String prev_kpi_val) {
			this.prev_kpi_val = prev_kpi_val;
		}

		public String getKpi_date() {
			return kpi_date;
		}

		public void setKpi_date(String kpi_date) {
			this.kpi_date = kpi_date;
		}

		public String getKpi_date_lbl() {
			return kpi_date_lbl;
		}

		public void setKpi_date_lbl(String kpi_date_lbl) {
			this.kpi_date_lbl = kpi_date_lbl;
		}

		public String getKpi_lbl() {
			return kpi_lbl;
		}

		public void setKpi_lbl(String kpi_lbl) {
			this.kpi_lbl = kpi_lbl;
		}

		public String getKpi_val() {
			return kpi_val;
		}

		public void setKpi_val(String kpi_val) {
			this.kpi_val = kpi_val;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			//fields from ABR_DATA_DATES "+this.getcreate_date()+","+this.getupdate_date()+
			return "sectinithist:["+this.getPrev_kpi_date()+","+this.getPrev_kpi_date_lbl()+","+this.getPrev_kpi_lbl()+","+this.getPrev_kpi_val()+","+this.getKpi_date()+","+this.getKpi_date_lbl()+","+this.getKpi_lbl()+","+this.getKpi_val()+","+this.getKpi_val()+"]";
		}	
	

}
