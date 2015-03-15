package com.aavn.rs.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aavn.rs.dao.ICommonDAO;
import com.aavn.rs.service.ICommonService;

@Service
public abstract class CommonService<T> implements ICommonService<T> {
	
	@Autowired
	protected ICommonDAO<T> commonDAO;
	

	public List<T> loadAll() {
		return this.commonDAO.loadAll();
	}

	public T getById(int id) {
		return this.commonDAO.getById(id);
	}

	public boolean save(T obj) {
		return this.commonDAO.save(obj);
	}

	public boolean update(T obj) {
		return this.commonDAO.update(obj);
	}

	public boolean delete(T obj) {
		return this.commonDAO.delete(obj);
	}
	
	public List<T> loadByCriterion(List<Criterion> criterion){
		if(criterion == null)
			return this.commonDAO.loadAll();
		return this.commonDAO.loadByCriterion(criterion);
	}
}
