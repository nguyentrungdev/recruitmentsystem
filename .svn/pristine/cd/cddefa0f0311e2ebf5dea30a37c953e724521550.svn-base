package com.aavn.rs.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aavn.rs.dao.IApplicantDAO;
import com.aavn.rs.domain.Applicant;
import com.aavn.rs.dto.ApplicantAdvancedSearch;

@Repository
public class ApplicantDAO<T extends Applicant> extends CommonDAO<Applicant> implements IApplicantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Applicant> searchApplicants(
			ApplicantAdvancedSearch applicantAdvancedSearch) {
		// TODO Auto-generated method stub

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Applicant.class,"aplc");

	
		
		List<Applicant> list = criteria.list();

		System.out.println(list.size());

		/*for (Applicant applicant : list) {
			System.out.println(
								applicant.getEvent().getEventName() + "	" +
								applicant.getFirstName() + "	" +
								  applicant.getLastName() + "	" +
								  applicant.getBirthday() + "	" +
								  applicant.getEmail() );
		}*/
		return list;
	}

}
