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
@Table(name="PURCHASEHISTORY")
public class Purchasehistory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "BUYERID", nullable = false)
	private long buyerid;
	
	@Column(name = "SELLERID", nullable = false)
	private long sellerid;
	
	@Column(name = "TRANSACTIONID", nullable = false)
	private long transactionid;
	
	@Column(name = "ITEMID", nullable = false)
	private long itemid;
	
	@Column(name = "NUMBEROFITEMS", nullable = true)
	private String numberofitems;
	
	@Column(name = "CREATETIME")
	private Timestamp createtime;
	
	@Column(name = "REMARKS", nullable = true)
	private String remarks;

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

	public long getSellerid() {
		return sellerid;
	}

	public void setSellerid(long sellerid) {
		this.sellerid = sellerid;
	}

	public long getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(String numberofitems) {
		this.numberofitems = numberofitems;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
