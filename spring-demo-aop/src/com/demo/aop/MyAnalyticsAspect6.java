package com.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnalyticsAspect6 {

	// declaring point cut and reuse it at various method
	@Pointcut("execution(* com.demo.dao.*.*(..))")
	public void useBeforeInDao() {
	}

	@Pointcut("execution(* com.demo.*.*.*get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.demo.*.*.*set*(..))")
	public void setter() {
		System.out.println("=====> @Pointcut :setter() ");
	}

	@Pointcut("useBeforeInDao() && !(getter() || setter())")
	public void forDaoPackageNoGetterandSetter() {
	}

}
