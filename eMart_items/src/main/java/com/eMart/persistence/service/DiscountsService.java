package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.DiscountsDao;
import com.eMart.persistence.service.BaseService;

@Service("DiscountsService")
@Transactional
public class DiscountsService extends BaseService{

	@Autowired
	private DiscountsDao discountsDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return discountsDao;
	}
	
}
