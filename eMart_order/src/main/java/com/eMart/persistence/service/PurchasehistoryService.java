package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.PurchasehistoryDao;
import com.eMart.persistence.service.BaseService;

@Service("PurchasehistoryService")
@Transactional
public class PurchasehistoryService extends BaseService{

	@Autowired
	private PurchasehistoryDao purchasehistoryDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return purchasehistoryDao;
	}
	
}
