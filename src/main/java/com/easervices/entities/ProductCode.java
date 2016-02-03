package com.easervices.entities;

import java.io.Serializable;
import javax.persistence.*;



/**
 * @author Pallav
 *
 */
@Entity
@Table(name="PRODUCT_CODE")
@NamedQuery(name="ProductCode.findAll", query="SELECT p FROM ProductCode p")
public class ProductCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_CODE")
	private String productCode;

	@Column(name="PRODUCT_DESC")
	private String productDesc;

	public ProductCode() {
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

}