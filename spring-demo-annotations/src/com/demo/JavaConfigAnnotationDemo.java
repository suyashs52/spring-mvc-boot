package com.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.SportConfig;
import com.demo.javaannotation.service.SwimCoach;
import com.demo.service.Coach;

public class JavaConfigAnnotationDemo {
	// spring class should be in class path under buildpath
	// jre must be in modulepath
	public static void main(String... str) {
		// read config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from container

		// Coach c = context.getBean("tennisCoach", Coach.class);
		SwimCoach c = context.getBean("swimCoach", SwimCoach.class);
		// call the method
		System.out.println(c.getDailyWorkOut());
		System.out.println(c.getDailyFortune());
		System.out.println("email: "+ c.getEmail());
		System.out.println("team: "+ c.getTeam());

		// close the context
		context.close();
	}
}
