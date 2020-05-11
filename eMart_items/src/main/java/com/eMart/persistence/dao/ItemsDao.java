package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("ItemsDao")
public class ItemsDao extends BaseDao{

	protected ItemsDao() {
		super("Items");
	}	
}
