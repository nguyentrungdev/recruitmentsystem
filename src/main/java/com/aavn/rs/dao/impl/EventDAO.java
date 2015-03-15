package com.aavn.rs.dao.impl;

import org.springframework.stereotype.Repository;

import com.aavn.rs.dao.IEventDAO;
import com.aavn.rs.domain.Event;

@Repository
public class EventDAO<T extends Event> extends CommonDAO<Event> implements IEventDAO{

}
