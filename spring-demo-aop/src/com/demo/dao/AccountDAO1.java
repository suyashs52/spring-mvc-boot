package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.model.Account;

@Component
public class AccountDAO1 {
	// added aspectjweaver/1.9.6 jar from maven in classpath,lib
	// aop can be added by aspect j, spring aop,
	// spring aop do run time aspect: logging, security
	// @transactinoal work as AOP, add begin and commit automaticall
	// only work on method level, aspectj is little complex work on
	// construction,fields and method level
	// aspectj is total aop implementation introduced in 2001, spring aop sometimes
	// extends some class of aspectj aop
	// spring aop use proxy design pattern, means it checks between main app and
	// target object
	// main app<-->aop proxy<--->logging aspect<--->targetObject
	// aop pointcut->a predicate expression for where advice should be applied
	public void addAccount() {
		System.out.println(getClass() + " Doing my DB work : Adding an account ");
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + " Doing my DB work : Adding an account for " + account.getName());

	}

	private String name;
	private String serviceCode;

	private List<Account> listAccount = new ArrayList<Account>() {
		{
			add(new Account("John", "Silver"));
			add(new Account("Madhu", "Gold"));
			add(new Account("Luca", "Platinum"));
		}
	};

	public List<Account> findAccount(boolean tripWire) {

		if (tripWire == true) {
			throw new RuntimeException("No Soup for You!!!");
		}
		return listAccount;
	}

	public String getName() {
		System.out.println(getClass() + " :getName() ");

		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " :setName(name) ");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " :getServiceCode() ");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " :setServiceCode(service) ");
		this.serviceCode = serviceCode;
	}

}
