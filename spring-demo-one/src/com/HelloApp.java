package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coach.TrackCoach;
import com.service.Coach;

public class HelloApp {
	public static void main(String[] args) {

		// aop example -> application context-> use to init beans of a class
		// beans def store in xml file, app context work as a container

		// load the spring config file
		ClassPathXmlApplicationContext contxt = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve the bean from container
		Coach bbc = contxt.getBean("myCoach", Coach.class);

		// call metod of the bean
		System.out.println("Getter inject demo");
		System.out.println(bbc.getDailyWorkOut());
		System.out.println(bbc.getDailyFortune());
		System.out.println("---Setter inject demo (literal, interface)----");
		bbc = contxt.getBean("myCricket", Coach.class);

		System.out.println(bbc.getDailyWorkOut());
		System.out.println(bbc.getDailyFortune());

		// close the context
		contxt.close();

	}
}
