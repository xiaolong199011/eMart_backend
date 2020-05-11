package com.eMart.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS")
public class Items implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "CATEGORYID", nullable = false)
	private long categoryid;
	
	@Column(name = "SUBCATEGORYID", nullable = false)
	private long subcategoryid;
	
	@Column(name = "PRICE", nullable = true)
	private String price;
	
	@Column(name = "ITEMNAME", nullable = true)
	private String itemname;
	
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;
	
	@Column(name = "STOCKNUMBER", nullable = true)
	private String stocknumber;
	
	@Column(name = "REMARKS", nullable = true)
	private String remarks;

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
}
