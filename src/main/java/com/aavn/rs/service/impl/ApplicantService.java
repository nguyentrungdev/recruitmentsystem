package com.aavn.rs.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aavn.rs.dao.IApplicantDAO;
import com.aavn.rs.dao.ICommonDAO;
import com.aavn.rs.domain.Applicant;
import com.aavn.rs.dto.ApplicantAdvancedSearch;
import com.aavn.rs.service.IApplicantService;
import com.aavn.rs.service.ICommonService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
@Service
public class ApplicantService extends CommonService<Applicant> implements IApplicantService {

	@Autowired 
	protected IApplicantDAO applicantDAO;	
	
	@Override
	@Transactional
	public List<Applicant> searchApplicant(ApplicantAdvancedSearch applicantAdvancedSearch) {
		List<Criterion> criterions = null;
/*
		
		Date graduateFrom = applicantAdvancedSearch.getGraduateFrom();
		Date graduateTo = applicantAdvancedSearch.getGraduateTo();
		Date applyFrom = applicantAdvancedSearch.getApplyFrom();
		Date applyTo = applicantAdvancedSearch.getApplyTo();
		String email = applicantAdvancedSearch.getEmail();
		String fullName = applicantAdvancedSearch.getFullName();
		String eventName = applicantAdvancedSearch.getEventName();
		eventName="Career";
		
	
		if (graduateFrom != null) 
			criterions.add(Restrictions.ge("graduateTime", graduateFrom));
				
		if (graduateTo != null) 
			criterions.add(Restrictions.le("graduateTime", graduateTo));
		 
		if (applyFrom != null) 
			criterions.add(Restrictions.ge("applyTime", applyFrom));

		 
		if (applyFrom != null) 
			criterion.add(Restrictions.lt("applyTime", applyTo));
		 
		
		if (email!=null)
			criterions.add(Restrictions.ilike("email", email,MatchMode.ANYWHERE));
		if (fullName!=null)
			criterions.add(Restrictions.ilike("email", fullName,MatchMode.ANYWHERE));
		
		if (eventName!=null){
			Criterion criterion;
			criterion.createAlias("aplc.event", "evt");
			criterions.add(Restrictions.ilike("evt.eventName", eventName,MatchMode.ANYWHERE));
			
		}*/
		
			
		return loadByCriterion(criterions);		
	}

}
