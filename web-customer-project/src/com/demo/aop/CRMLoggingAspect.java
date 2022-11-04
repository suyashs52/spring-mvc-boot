package com.demo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.demo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.demo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.demo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {

	}

	@Before("forAppFlow()")
	public void beforeAppflow(JoinPoint theJointPoint) {
		// display method we are calling
		String methodname = theJointPoint.getSignature().toShortString();
		logger.info("====> in @Before Calling method " + methodname);

		Object[] arg = theJointPoint.getArgs();

		for (Object obj : arg) {
			logger.info("===>argument " + obj);
		}

	}
}
