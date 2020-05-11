package com.eMart.persistence.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

public class BaseDao implements Repository<Object, Serializable>{



    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEm() {
        return entityManager;
    }
    
//    protected Session getSession() {
//    	HibernateEntityManager hEntityManager = (HibernateEntityManager)entityManager;
//    	return hEntityManager.getSession();
//    }

    protected void setEm(EntityManager em) {
        this.entityManager = em;
    }
    
//    public LobCreator getLobCreator() {
//    	return Hibernate.getLobCreator(this.getSession());
//    }
    
	private String className = null;
	

	protected BaseDao(String cn) {
		this.className = cn;
	}

	public Object save(Object o) {

		return this.getEm().merge(o);
	}
	
	public void delete(Object o) {
		this.getEm().remove(o);
	}
		
	@SuppressWarnings("unchecked")
	public List<Object> findAll() {
		String hql="FROM " + this.getClassName() +" t ORDER by t.id desc";
		System.out.println(this.getEm().createQuery(hql).getResultList());
		return this.getEm().createQuery(hql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findByCondition(String conditionName,String conditionValue) {
		
		String hql="FROM " + this.getClassName() +" t WHERE t."+conditionName+" = " + "'"+conditionValue+"'"; 
		List<Object> l = this.getEm().createQuery(hql).getResultList();
		if (null != l) {
			return this.getEm().createQuery(hql).getResultList();
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Object findBy(long id) {
		
		String hql="FROM " + this.getClassName() +" t WHERE t.id = " + id; 		
		List<Object> l = this.getEm().createQuery(hql).getResultList();
		if (null != l && (1 == l.size())) {
			return this.getEm().createQuery(hql).getResultList().get(0);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findAll(int max) {
		String hql="FROM " + this.getClassName() +" t ORDER by t.lastUpdate desc";
		Query q = this.getEm().createQuery(hql);
		q.setMaxResults(max);
		return q.getResultList();
	}
	
	protected String getClassName() {
		return className;
	}

}
