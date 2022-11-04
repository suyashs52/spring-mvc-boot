package com.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.dao.AccountDAO1;
import com.demo.model.Account;
import com.demo.service.FortuneService13;

public class AroundDemoApp14 {

	private static Logger myLogger = Logger.getLogger(AroundDemoApp14.class.getName());

	public static void main(String... str) {
		// read config class
		AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(DemoConfig2.class);

		/// get the bean from config
		FortuneService13 fortune = config.getBean("fortuneService13", FortuneService13.class);

		myLogger.info("\n Main Program Around Main app:");

		myLogger.info("Calling myFroturn Service");
		
		myLogger.info(fortune.getFortune(true));
		// close the config context
		config.close();
		myLogger.info("Finished");
	}

	private static void convertStringListToUpperCase(List<Account> accounts) {
		// TODO Auto-generated method stub

	}

}
