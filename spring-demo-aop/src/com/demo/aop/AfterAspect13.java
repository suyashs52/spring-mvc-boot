package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class AfterAspect13 {
	// After works after return / exception occur
	// like finally block
	// to main func, can send the mail / log the exception
	// add a new advice for @AfterReturning on the findAccount method
	@After("execution(* com.demo.dao.AccountDAO1.findAccount(..))")
	public void afterFinallyFindAccoutsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n executing @After(finally)  on method " + method);

	}

}
