package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.BuyerDao;
import com.eMart.persistence.service.BaseService;

@Service("buyerService")
@Transactional
public class BuyerService extends BaseService{

	@Autowired
	private BuyerDao buyerDao;	
	

	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return buyerDao;
	}
	

	
}
