package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class AfterThrowingAspect11 {
	

	// AfterThrowing after exception throw pass the control to aspect proxy-> return
		// to main func, can send the mail / log the exception
		// add a new advice for @AfterReturning on the findAccount method
		@AfterThrowing(pointcut = "execution(* com.demo.dao.AccountDAO1.findAccount(..))", throwing = "theExc")
		public void afterThrowingFindAccoutsAdvice(JoinPoint joinPoint, Throwable theExc) {
			String method = joinPoint.getSignature().toShortString();
			System.out.println("\n executing @AfterThrowing  on method " + method);

			System.out.println("\n==> The exception is " + theExc);
		}
}
