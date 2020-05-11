package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

import com.eMart.persistence.dao.BaseDao;

@Repository("BuyerDao")
public class BuyerDao extends BaseDao{

	protected BuyerDao() {
		super("Buyer");
	}	
}
