package com.eMart.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SUBCATEGORY")
public class Subcategory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",unique = true, nullable = false)
	private long id;
	
	@Column(name = "SUBCATEGORYNAME", nullable = false)
	private String subcategoryname;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
//	@Column(name = "CATEGORYID", nullable = false)

	
	@Column(name = "BRIEFDETAILS", nullable = true)
	private String briefdetails;

	@Column(name = "GST", nullable = true)
	private String gst;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

//	public long getCategoryid() {
//		return categoryid;
//	}
//
//	public void setCategoryid(long categoryid) {
//		this.categoryid = categoryid;
//	}

	public String getBriefdetails() {
		return briefdetails;
	}

	public void setBriefdetails(String briefdetails) {
		this.briefdetails = briefdetails;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	
}
