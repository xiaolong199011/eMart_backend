package com.eMart.persistence.model;

import java.sql.Timestamp;

import javax.persistence.Column;

public class TransactionItemModel {
	
	private long id;
	
	private long buyerid;
	
	private int shopcart;
	
	private String transactiontype;
	
	private Timestamp datetime;
	
	private String remarks;
	
	private long categoryid;
	
	private long subcategoryid;
	
	private String price;
	
	private String itemname;
	
	private String description;
	
	private String stocknumber;
	
	private String filename;
	
	private long sellerid;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(long buyerid) {
		this.buyerid = buyerid;
	}

	public int getShopcart() {
		return shopcart;
	}

	public void setShopcart(int shopcart) {
		this.shopcart = shopcart;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public long getSellerid() {
		return sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}
	
	

}
