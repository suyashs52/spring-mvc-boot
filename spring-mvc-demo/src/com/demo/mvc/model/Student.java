package com.demo.mvc.model;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;

public class Student {

	String firstName;
	String lastName;
	String country;
	// @Value("#{countryOptions}")
	private LinkedHashMap<String, String> countryOptions;// = new LinkedHashMap<String, String>();
	String language; 
	
	String [] os; 
	
	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IND", "India");

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}
	
	
	
	

}
