package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.TransactionsDao;
import com.eMart.persistence.service.BaseService;

@Service("TransactionsService")
@Transactional
public class TransactionsService extends BaseService{

	@Autowired
	private TransactionsDao transactionsDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return transactionsDao;
	}
	
}
