package com.eMart.persistence.dao;

import org.springframework.stereotype.Repository;

@Repository("fileInfoDao")
public class FileInfoDao extends BaseDao {

	protected FileInfoDao() {
		super("FileInfo");
		// TODO Auto-generated constructor stub
	}

}