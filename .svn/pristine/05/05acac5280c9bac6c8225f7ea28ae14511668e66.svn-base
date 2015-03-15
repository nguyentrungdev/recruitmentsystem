package com.aavn.rs.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aavn.rs.domain.Car;

@Component("BasicView")
public class BasicView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	@Autowired
	private CarService service;

	@PostConstruct
	public void init() {
		cars = service.createCars(10);
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public CarService getService() {
		return service;
	}
}