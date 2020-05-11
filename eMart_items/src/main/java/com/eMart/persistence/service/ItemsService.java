package com.eMart.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.persistence.dao.BaseDao;
import com.eMart.persistence.dao.ItemsDao;

@Service("ItemsService")
@Transactional
public class ItemsService extends BaseService{

	@Autowired
	private ItemsDao itemsDao;	
	
	@Override
	protected BaseDao getDao() {
		// TODO Auto-generated method stub
		return itemsDao;
	}
	
}
