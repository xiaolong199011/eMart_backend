package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDao extends BaseDao {
	protected UserDao() {
		super("User");
	}
}
