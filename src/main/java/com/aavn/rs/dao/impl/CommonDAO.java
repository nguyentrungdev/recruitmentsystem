package com.aavn.rs.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aavn.rs.dao.ICommonDAO;

@Repository
public abstract class CommonDAO<T> implements ICommonDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Object LOGMES = "Log From BayMax!";
	private static final Logger LOGGER = Logger.getLogger(CommonDAO.class);

	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public CommonDAO() {
		 entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@Transactional
	public boolean save(T entity) {
		Boolean flag = false;
		try {
			sessionFactory.getCurrentSession().save(entity);
			flag = true;
		} catch (Exception e) {
			LOGGER.error(LOGMES, e);

			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean update(T entity) {
		Boolean flag = false;
		try {
			sessionFactory.getCurrentSession().update(entity);
			flag = true;
		} catch (Exception e) {
			LOGGER.error(LOGMES, e);

			flag = false;
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean delete(T entity) {
		Boolean flag = false;
		try {
			sessionFactory.getCurrentSession().delete(entity);
			flag = true;
		} catch (Exception e) {
			LOGGER.error(LOGMES, e);

			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> loadAll() {
		return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T getById(int id) {		
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> loadByCriterion(List<Criterion> criterion){
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(entityClass);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();		
	}
	
}
