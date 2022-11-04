package com.demo.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("theTennisCoach") 
@Component // if no name specify default bean id is t(lowerCase): tennisCoach
@Scope("prototype") // singleton and prototype --check demo-one ,default is singleton
public class TennisCoach implements Coach, DisposableBean {
	// work like bean id , spring ll automatically register this bean when component
	// scan has this package
	// default beanname for RESTFortune is not rEST....
	// spring use uses the Java Beans Introspector to generate the default bean name
	// so if first character is in upper case then it is ok otherwise define your
	// own name
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;

	// add default constructor
	public TennisCoach() {
		System.out.println("TennisCoach: default constructor");
		if (fortuneService == null) {
			System.out.println("TennisCoach: default constructor didn't inject the dependency");
		}
	}

	// define method injection
	@Autowired
	@Qualifier("happyFortuneService")
	public void doMethodInjectFortuneService(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside doMethodInjectFortuneService() method ");
		fortuneService = theFortuneService;
	}

	// define setter method
	@Autowired
	@Qualifier("randomFortuneService")
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println("TennisCoach: inside setFortuneService() method ");
		fortuneService = theFortuneService;
	}
	// constructor injection
	// it don't support qualifier

	@Autowired

	public TennisCoach(@Qualifier("happyFortuneService") FortuneService theFortuneService) {
		// Autowired(@Autowired) ask spring to do constructor dependency injection
		// spring search for the class that implement the
		// service and automatically // // assign object to this variable if multiple
		// class implementing the interface // and we need to distinguish
		System.out.println("TennisCoach: inside TennisCoach() method for constructor injection ");
		if (fortuneService == null) {
			System.out.println("TennisCoach: constructor didn't inject the dependency");
		}
		fortuneService = theFortuneService;
	}

	// define init method called before initializing the class object
	// we can't have return type and param arg constructor
	@PostConstruct // part of javax annotation -> from java9 this has been removed so need to add
					// as external jar in class path
	void doSomeStuffBeforeBeanCreate() {
		System.out.println("TennisCoach: inside of doSomeStuffBeforeBeanCreate");
	}

	@PreDestroy
	// For "prototype" scoped beans, Spring does not call the @PreDestroy method.
	// because does not manage the complete lifecycle of a
	// prototype bean,client code must clean up prototype-scoped objects and release expensive resources
	//to workaround create CustomBeanProcessor class and implement here DisposableBean
	void doCleanStuffyBeforeBeanDistroy() {
		System.out.println("TennisCoach: inside destroy of doCleanStuffyBeforeBeanDistroy");
	}

	@Override
	public String getDailyWorkOut() {

		return "Practice your vallye bolly";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune() + " for email: " + email;
	}

	@Override
	public void destroy() throws Exception {
		 
		System.out.println(">> TennisCoach: inside destroy()");
	}

}
