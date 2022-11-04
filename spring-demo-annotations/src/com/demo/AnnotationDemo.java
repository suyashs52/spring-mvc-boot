package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.service.Coach;

public class AnnotationDemo {
	// spring class should be in class path under buildpath
	// jre must be in modulepath
	public static void main(String... str) {
		// read config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// get the bean from container

		Coach c = context.getBean("tennisCoach", Coach.class);
		// call the method
		System.out.println(c.getDailyWorkOut());
		System.out.println(c.getDailyFortune());
		
		Coach tc=context.getBean("tennisCoach",Coach.class);
		// close the context
		context.close();
	}
}
