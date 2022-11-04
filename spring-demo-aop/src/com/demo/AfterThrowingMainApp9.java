package com.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.dao.AccountDAO1;
import com.demo.model.Account;

public class AfterThrowingMainApp9 {

	public static void main(String... str) {
		// read config class
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(DemoConfig2.class);

		/// get the bean from config
		AccountDAO1 accountDao = config.getBean("accountDAO1", AccountDAO1.class);

		List<Account> accounts = null;

		try {

			accounts = accountDao.findAccount(true);
		} catch (Exception exc) { // this ll run after aspect
			System.out.println("\n Main program caught exception " + exc);
		}

		System.out.println("\n\n AfterReturnMainApp7 After running account method in \n");
		System.out.println(accounts);
		System.out.println("\n");

		// close the config context
		config.close();
	}

	private static void convertStringListToUpperCase(List<Account> accounts) {
		// TODO Auto-generated method stub

	}

}
