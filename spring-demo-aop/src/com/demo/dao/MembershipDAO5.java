package com.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO5 {

	public void addAccount() {
		System.out.println(getClass() + " :Doing my stuff : Adding a membership account ");
	}
	
	public void addSillyMember() {
		System.out.println(getClass() + " :Doing my stuff : Adding a silly membership account ");
	}

}
