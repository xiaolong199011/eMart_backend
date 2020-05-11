package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("CategoryDao")
public class CategoryDao extends BaseDao{

	protected CategoryDao() {
		super("Category");
	}	
}
