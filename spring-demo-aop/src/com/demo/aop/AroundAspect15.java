package com.demo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class AroundAspect15 {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.demo.service.*.*(..))")
	public Object aroundGetAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n==>Executing after @Around on method " + method);

		long milis = System.currentTimeMillis();
		Object obj = null;
		try {
			obj = proceedingJoinPoint.proceed();
		} catch (Exception ex) {
			myLogger.warning(ex.getMessage());
			obj = "Accident but no worries, Your private Halicopter is on the way!";
		}

		long endmilis = System.currentTimeMillis();

		long duration = endmilis - milis;

		myLogger.info("\n==> Duration: " + duration / 1000.0 + " secs");
		return obj;
	}
}
