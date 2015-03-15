package com.aavn.rs.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StaticServiceContext {

	private static StaticServiceContext instance;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void registerInstance() {
        instance = this;
    }

    public static <T> T getService(Class<T> serviceClass) {
        return instance.applicationContext.getBean(serviceClass);
    }
}
