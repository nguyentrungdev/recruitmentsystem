package com.aavn.rs.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aavn.rs.domain.Event;
import com.aavn.rs.domain.Gender;
import com.aavn.rs.domain.Applicant;
import com.aavn.rs.domain.Skill;
import com.aavn.rs.service.IApplicantService;
import com.aavn.rs.service.IEventService;
import com.aavn.rs.service.ISkillService;
import com.aavn.rs.service.StaticServiceContext;
import com.aavn.rs.util.NumberUtils;

@Component("applicantForm")
@Scope("request")
public class ApplicantForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SEARCH_PAGE = "advancedSearch";
	private static String SUCCESS_PAGE = SEARCH_PAGE;
	private static String REDIRECT_STR = "?faces-redirect=true";

	private Applicant applicant;
	private List<Skill> skills;
	private List<Integer> selectedSkills;
	private List<Event> listEvents;
	private int eventId;
	private boolean isNeedRerender = false;

	@Autowired
	private IApplicantService applicantService;
	@Autowired
	private ISkillService skillService;
	@Autowired
	private IEventService eventService;

	@PostConstruct
	public void init() {
		listEvents = eventService.loadAll();
		skills = skillService.loadAll();
		String strId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (applicant == null) {
			boolean isValid = false;
			if (strId != null) {
				if (NumberUtils.isInteger(strId)) {
					int id = Integer.parseInt(strId);
					if (id > 0) {
						applicant = applicantService.getById(id);
						if (applicant != null)
							isValid = true;
					}
				}
				if (isValid) {
					loadValue();
				} else {
					FacesContext.getCurrentInstance().addMessage("applicantForm:message",
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "There is something wrong with id"));
					FacesContext.getCurrentInstance().addMessage(
							"growlMessage",
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "There is something wrong with id"));
					//RequestContext rContext = RequestContext.getCurrentInstance();
					isNeedRerender = true;
					//rContext.addCallbackParam("search", true);
					applicant = new Applicant();
				}
			} else {
				applicant = new Applicant();
			}
			
		}
	}

	public boolean loadValue() {
		// Redisplay selected skill on page.
		selectedSkills = new ArrayList<>(applicant.getSkills().size());
		for (Iterator<Skill> iterator = applicant.getSkills().iterator(); iterator.hasNext();) {
			Skill skill = iterator.next();
			selectedSkills.add(skill.getId());
		}
		return true;
	}

	public boolean setValue() {
		// Set value for event, skills
		applicant.setEvent(new Event(eventId));
		applicant.getSkills().clear();
		for (Integer skillId : selectedSkills) {
			applicant.getSkills().add(new Skill(skillId));
		}
		return true;
	}

	public String save() {
		setValue();
		if (applicantService.save(applicant)) {
			FacesContext.getCurrentInstance().addMessage(
					"growlMessage",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Create applicant successfully", applicant.getFirstName() + " "
							+ applicant.getLastName()));
		} else {
			FacesContext.getCurrentInstance().addMessage("applicantForm:message",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to create applicant"));
			return "";
		}
		return SUCCESS_PAGE;
	}

	public String update() {
		setValue();
		if (applicantService.update(applicant)) {
			FacesContext.getCurrentInstance().addMessage(
					"growlMessage",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Update applicant successfully", applicant.getFirstName() + " "
							+ applicant.getLastName()));
		} else {
			FacesContext.getCurrentInstance().addMessage("applicantForm:message",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to update applicant"));
			return "";
		}
		return SUCCESS_PAGE;
	}

	public void isAdmin(ComponentSystemEvent event){
		FacesContext fc = FacesContext.getCurrentInstance();
		if (isNeedRerender) {
			ConfigurableNavigationHandler nav 
			   = (ConfigurableNavigationHandler) 
				fc.getApplication().getNavigationHandler();
			isNeedRerender = false;
			nav.performNavigation(SUCCESS_PAGE + REDIRECT_STR);
		}
	  }	
	
	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String submitTest() {
		return "";
	}

	public Gender[] getGenders() {
		return Gender.values();
	}

	public Collection<Skill> getSkills() {
		return this.skills;
	}

	public IApplicantService getApplicantService() {
		return applicantService;
	}

	public void setApplicantService(IApplicantService applicantService) {
		this.applicantService = applicantService;
	}

	public ISkillService getSkillService() {
		return skillService;
	}

	public void setSkillService(ISkillService skillService) {
		this.skillService = skillService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Integer> getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(List<Integer> selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<Event> getListEvents() {
		return listEvents;
	}

	public void setListEvents(List<Event> listEvents) {
		this.listEvents = listEvents;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public static String getSuccessPage() {
		return SUCCESS_PAGE;
	}

	public static void setSuccessPage(String successPage) {
		SUCCESS_PAGE = successPage;
	}
}
