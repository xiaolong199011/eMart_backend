package com.eMart.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISCOUNTS")
public class Discounts implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "DISCOUNTCODE", nullable = true)
	private String discountcode;
	
	@Column(name = "PERCENTAGE", nullable = true)
	private String percentage;
	
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;
	
	@Column(name = "STARTDATE")
	private Timestamp startdate;
	
	@Column(name = "ENDDATE")
	private Timestamp enddate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDiscountcode() {
		return discountcode;
	}

	public void setDiscountcode(String discountcode) {
		this.discountcode = discountcode;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	
	
}
