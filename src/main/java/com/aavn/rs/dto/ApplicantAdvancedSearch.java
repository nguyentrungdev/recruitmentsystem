package com.aavn.rs.dto;

import java.util.Date;


public class ApplicantAdvancedSearch {
	private String fullName;
	private String email;
	private Date graduateFrom;
	private Date graduateTo;
	private Date applyFrom;
	private Date applyTo;
	private String eventName;
	
	
	public ApplicantAdvancedSearch(String fullName, String email,
			Date graduateFrom, Date graduateTo, Date applyFrom, Date applyTo,
			String eventName) {
	
		this.fullName = fullName;
		this.email = email;
		this.graduateFrom = graduateFrom;
		this.graduateTo = graduateTo;
		this.applyFrom = applyFrom;
		this.applyTo = applyTo;
		this.eventName = eventName;
	}
	public ApplicantAdvancedSearch() {
		
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getGraduateFrom() {
		return graduateFrom;
	}
	public void setGraduateFrom(Date graduateFrom) {
		this.graduateFrom = graduateFrom;
	}
	public Date getGraduateTo() {
		return graduateTo;
	}
	public void setGraduateTo(Date graduateTo) {
		this.graduateTo = graduateTo;
	}
	public Date getApplyFrom() {
		return applyFrom;
	}
	public void setApplyFrom(Date applyFrom) {
		this.applyFrom = applyFrom;
	}
	public Date getApplyTo() {
		return applyTo;
	}
	public void setApplyTo(Date applyTo) {
		this.applyTo = applyTo;
	}


}
