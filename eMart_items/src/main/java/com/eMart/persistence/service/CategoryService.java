package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.CategoryDao;
import com.eMart.persistence.service.BaseService;

@Service("Category")
@Transactional
public class CategoryService extends BaseService{

	@Autowired
	private CategoryDao categoryDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return categoryDao;
	}
	
}
