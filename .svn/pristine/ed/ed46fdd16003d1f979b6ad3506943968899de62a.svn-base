package com.aavn.rs.bean;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aavn.rs.domain.Car;
import com.aavn.rs.bean.CarService;
 
@Component("dtFilterView")
public class FilterView {    

	private List<Car> cars;
     
    private List<Car> filteredCars;
     
    @Autowired
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars = service.createCars(10);
    }
     
    
    @SuppressWarnings("unchecked")
	public boolean filterByColor(Object value, Object filter, Locale locale) {
    	String filterText = (filter == null) ? null: filter.toString().trim();
    	System.out.println(filterText);
    	if(filterText == null || filterText.equals("")) {
    		return true;
    	} 
    	if( value == null) {
    		return false;
    	}
    	
    	return ((Comparable<String>) value).compareTo(filterText) == 0; 
    }
    
    public List<String> getBrands() {
        return service.getBrands();
    }
     
    public List<String> getColors() {
        return service.getColors();
    }
     
    public List<Car> getCars() {
        return cars;
    }
 
    public List<Car> getFilteredCars() {
        return filteredCars;
    }
 
    public void setFilteredCars(List<Car> filteredCars) {
        this.filteredCars = filteredCars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
}