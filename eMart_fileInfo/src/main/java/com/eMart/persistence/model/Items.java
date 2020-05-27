package com.eMart.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Items{

	private long id;
	
	private long categoryid;
	
	private long subcategoryid;
	
	private String price;
	
	private String itemname;
	
	private String description;
	
	private String stocknumber;
	
	private String remarks;
	
	private long fileinfoid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public long getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(long subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStocknumber() {
		return stocknumber;
	}

	public void setStocknumber(String stocknumber) {
		this.stocknumber = stocknumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getFileinfoid() {
		return fileinfoid;
	}

	public void setFileinfoid(long fileinfoid) {
		this.fileinfoid = fileinfoid;
	}
	
	
}
