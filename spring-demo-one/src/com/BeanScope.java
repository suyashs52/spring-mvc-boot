package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coach.TrackCoach;
import com.service.Coach;

public class BeanScope {

	public static void main(String[] args) {
		Coach coach = new TrackCoach();
		System.out.println(coach.getDailyWorkOut());

		System.out.println("-----Bean Scope-----");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve the bean from spring container
		Coach myCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		// in the case of prototypes, configured destruction lifecycle callbacks are not
		// called. The client code must clean up prototype-scoped objects and release
		// expensive resources that the prototype bean(s) are holding.
		// prototype scoped beans MUST implement the DisposableBean interface. 
		Coach myProtoTypeCoach = context.getBean("myProtoTypeCoach", Coach.class);
		Coach myProtoTypeAlphaCoach = context.getBean("myProtoTypeCoach", Coach.class);
		// check if both are the same
		boolean result = (myCoach == alphaCoach);
		boolean resultAlpha = (myProtoTypeCoach == myProtoTypeAlphaCoach);
		// print the result
		System.out.println("Pointing to same object " + result);
		System.out.println("Memory location for myCoach " + myCoach);
		System.out.println("Memory location for the alphaCoach " + alphaCoach);
		System.out.println("Pointing to same object prototype " + resultAlpha);
		System.out.println("Memory location for myProtoTypeCoach " + myProtoTypeCoach);
		System.out.println("Memory location for the myProtoTypeAlphaCoach " + myProtoTypeAlphaCoach);
		// closing the context
		context.close();
	}

}
