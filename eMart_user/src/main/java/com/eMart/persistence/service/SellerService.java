package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.BuyerDao;
import com.eMart.persistence.dao.SellerDao;
import com.eMart.persistence.service.BaseService;

@Service("SellerService")
@Transactional
public class SellerService extends BaseService{

	@Autowired
	private SellerDao sellerDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return sellerDao;
	}
	
}
