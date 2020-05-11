package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.SubcategoryDao;
import com.eMart.persistence.service.BaseService;

@Service("SubcategoryService")
@Transactional
public class SubcategoryService extends BaseService{

	@Autowired
	private SubcategoryDao subcategoryDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return subcategoryDao;
	}
	
}
