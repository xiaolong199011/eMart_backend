package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("TransactionsDao")
public class TransactionsDao extends BaseDao{
	protected TransactionsDao() {
		super("Transactions");
	}	
}
