package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("DiscountsDao")
public class DiscountsDao extends BaseDao{

	protected DiscountsDao() {
		super("Discounts");
	}
}
