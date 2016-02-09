package com.easervices.response.model;

import org.springframework.stereotype.Component;

@Component
public class SearchCategoriesModel {


private String cat_type;
private String cat_name;
private String cat_id;
private String cat_desc; 
	public SearchCategoriesModel()
		{
			
		}
		
		 public SearchCategoriesModel(String cat_type,String cat_name,String cat_id,String cat_desc )
		{
			this.cat_type = cat_type;
			this.cat_name = cat_name;
			this.cat_id = cat_id;
			this.cat_desc = cat_desc;
		}

		public String getCat_type() {
			return cat_type;
		}

		public void setCat_type(String cat_type) {
			this.cat_type = cat_type;
		}

		public String getCat_name() {
			return cat_name;
		}

		public void setCat_name(String cat_name) {
			this.cat_name = cat_name;
		}

		public String getCat_id() {
			return cat_id;
		}

		public void setCat_id(String cat_id) {
			this.cat_id = cat_id;
		}
		
		
		public String getCat_desc() {
			return cat_desc;
		}

		public void setCat_desc(String cat_desc) {
			this.cat_desc = cat_desc;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			//fields from ABR_DATA_DATES "+this.getcreate_date()+","+this.getupdate_date()+
			return "sectinithist:["+this.getCat_type()+","+this.getCat_id()+","+this.getCat_name()+","+this.getCat_desc()+"]";
		}	
	

}
