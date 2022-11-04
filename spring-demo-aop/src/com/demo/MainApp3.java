package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.dao.AccountDAO1;
import com.demo.dao.MembershipDAO5;
import com.demo.model.Account;

public class MainApp3 {

	public static void main(String... str) {
		// read config class
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(DemoConfig2.class);

		/// get the bean from config
		AccountDAO1 accountDao = config.getBean("accountDAO1", AccountDAO1.class);

		// call the business method
		Account acnt = new Account();
		acnt.setName("Does");
		acnt.setLevel("gold");
		accountDao.addAccount(acnt);
		// dao call getter and setter name
		accountDao.setName("maria");
		accountDao.setServiceCode("silver");

		String combined = accountDao.getName() + ":" + accountDao.getServiceCode();

		// calling the membership account
		MembershipDAO5 membershipDao = config.getBean("membershipDAO5", MembershipDAO5.class);
		membershipDao.addAccount();
		membershipDao.addSillyMember();

		// close the config context
		config.close();
	}

}
