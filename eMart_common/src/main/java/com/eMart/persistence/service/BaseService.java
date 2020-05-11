package com.eMart.persistence.service;

import java.util.List;

import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.transaction.annotation.Transactional;

import com.eMart.controller.rest.Result;
import com.eMart.persistence.dao.BaseDao;

@Transactional
public abstract class BaseService{


	
	protected abstract BaseDao getDao();
	
	public Object save(Object o) {
		try {
			return getDao().save(o);
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
//	public LobCreator getLobCreator() {
//    	return getDao().getLobCreator();
//    }
	
	public Result delete(Object o) {
		try {
			getDao().delete(o);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result("Failed",
					"Exception happened while deleting the object.");
		}
		return new Result("Success", "Deleted successfully");
	}
	
	public List<Object> findAll() {

		try {
			return getDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object findBy(long id) {
		return getDao().findBy(id);
	}
	
	public List<Object> findByCondition(String conditionName,String conditionValue) {

		try {
			List<Object> l = getDao().findByCondition( conditionName, conditionValue);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public List<Object> findWith(String condition) {
//
//		try {
//			List<Object> l = getDao().findWith(condition);
//			return l;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
//	@SuppressWarnings("unchecked")
//	public Object findByCondition(String conditionName,String conditionValue) {
//		
//		String hql="FROM " + this.getClassName() +" t WHERE t."+conditionName+" = " + conditionValue; 		
//		List<Object> l = this.getEm().createQuery(hql).getResultList();
//		if (null != l && (1 == l.size())) {
//			return this.getEm().createQuery(hql).getResultList().get(0);
//		}
//		
//		return null;
//	}
}
