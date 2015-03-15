package com.aavn.rs.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.aavn.rs.domain.Event;
import com.aavn.rs.service.IEventService;

@Component("event_Bean")
@Scope(value = "session")
public class EventBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IEventService eventService;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private List<Event> listEvents;
	
	public IEventService getEventService() {
		return eventService;
	}

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}

	public List<Event> getListEvents() {
		listEvents = new ArrayList<Event>();
		if (eventService.loadAll() != null)
			listEvents.addAll(eventService.loadAll());
		return listEvents;
	}

	public void setListEvents(List<Event> listEvents) {
		this.listEvents = listEvents;
	}

	

	

}
