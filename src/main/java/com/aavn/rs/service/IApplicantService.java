package com.aavn.rs.service;

import java.util.List;

import com.aavn.rs.domain.Applicant;
import com.aavn.rs.dto.ApplicantAdvancedSearch;
public interface IApplicantService extends ICommonService<Applicant> {
	public List<Applicant> searchApplicant(ApplicantAdvancedSearch applicantAdvancedSearch);
}
