package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("SellerDao")
public class SellerDao extends BaseDao{
	protected SellerDao() {
		super("Seller");
	}	
}
