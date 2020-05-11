package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("SubcategoryDao")
public class SubcategoryDao extends BaseDao{
	protected SubcategoryDao() {
		super("Subcategory");
	}	
}
