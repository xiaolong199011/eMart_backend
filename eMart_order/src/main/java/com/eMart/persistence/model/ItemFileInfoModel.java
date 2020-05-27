package com.eMart.persistence.model;

public class ItemFileInfoModel {

	private long id;
	
	private long categoryid;
	
	private long subcategoryid;
	
	private String price;
	
	private String itemname;
	
	private String description;
	
	private String stocknumber;
	
	private String remarks;
	
	private long fileinfoid;
	
	private long sellerid;
	
	private String filename;

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

	public long getSellerid() {
		return sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}
	
	
	
	

}
