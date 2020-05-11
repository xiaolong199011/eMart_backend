package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("PurchasehistoryDao")
public class PurchasehistoryDao extends BaseDao{
	protected PurchasehistoryDao() {
		super("Purchasehistory");
	}	
}
