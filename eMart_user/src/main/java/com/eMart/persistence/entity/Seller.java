package com.eMart.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SELLER")
public class Seller implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",unique = true, nullable = false)
	private long id;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "COMPANYNAME", nullable = true)
	private String companyname;
	
	@Column(name = "GSTIN", nullable = true)
	private String gstin;
	
	@Column(name = "BRIEFABOUTCOMPANY", nullable = true)
	private String briefaboutcompany;
	
	@Column(name = "POSTALADDRESS", nullable = true)
	private String postaladdress;
	
	@Column(name = "WEBSITE", nullable = true)
	private String website;
	
	@Column(name = "EMAIL", nullable = true)
	private String email;
	
	@Column(name = "CONTACTNUMBER", nullable = true)
	private String contactnumber;
	
	@Column(name = "ROLE", nullable = true)
	private String role;
	
	@Column(name = "LASTLOGINTIME")
	private Date lastlogintime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getBriefaboutcompany() {
		return briefaboutcompany;
	}

	public void setBriefaboutcompany(String briefaboutcompany) {
		this.briefaboutcompany = briefaboutcompany;
	}

	public String getPostaladdress() {
		return postaladdress;
	}

	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public Date getLastlogintime() {
		return lastlogintime;
	}

	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	


	
	
}
