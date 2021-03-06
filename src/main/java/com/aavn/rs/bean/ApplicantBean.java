package com.aavn.rs.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.push.AdvancedPushContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aavn.rs.domain.Applicant;
import com.aavn.rs.dto.ApplicantAdvancedSearch;
import com.aavn.rs.service.IApplicantService;

@Component("applicant_Bean")
@Scope(value = "session")
public class ApplicantBean {

	@Autowired
	private IApplicantService applicantService;

	private Applicant applicant;

	private ApplicantAdvancedSearch applicantAdvancedSearch = new ApplicantAdvancedSearch();;
	
	public ApplicantAdvancedSearch getApplicantAdvancedSearch() {
		return applicantAdvancedSearch;
	}
	
	public ApplicantBean()
	{
		applicantAdvancedSearch= new ApplicantAdvancedSearch();
		
	}
	
	public void setApplicantAdvancedSearch(
			ApplicantAdvancedSearch applicantAdvancedSearch) {
		this.applicantAdvancedSearch = applicantAdvancedSearch;
	}
	private List<Applicant> listApplicants;

	private List<Applicant> filteredApplicants;

	public IApplicantService getApplicantService() {
		return applicantService;
	}

	public void setApplicantService(IApplicantService applicantService) {
		this.applicantService = applicantService;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public List<Applicant> getFilteredApplicants() {
		return filteredApplicants;
	}

	public void setFilteredApplicants(List<Applicant> filteredApplicants) {
		this.filteredApplicants = filteredApplicants;
	}

	public List<Applicant> getListApplicants() {
		listApplicants = new ArrayList<Applicant>();
		if (applicantService.loadAll() != null)
			listApplicants.addAll(applicantService.loadAll());
		return listApplicants;
	}

	public void setListApplicants(List<Applicant> listApplicants) {
		this.listApplicants = listApplicants;
	}

	public void deleteApplicant(Applicant applicant) {
		applicantService.delete(applicant);
	}
	public String searchApplicants() {
		//System.out.println(applicantAdvancedSearch.getFullName());
		//System.out.println(applicantAdvancedSearch.getGraduateFrom().toString());
		//System.out.println(applicantAdvancedSearch.getGraduateTo().toString());
		
		listApplicants=applicantService.searchApplicant(applicantAdvancedSearch);
		return null;
	}
	
	public String editApplicant(java.lang.Integer id) {
		if (id != null && id > 0)
			return "update?faces-redirect=true&id=" + id;
		return "";
	}
	
}
