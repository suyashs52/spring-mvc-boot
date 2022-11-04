package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.model.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspect4 {

	// add related advices for logging

	// BEfore advice

	// @Before("execution(public void addAccount())") // inside this point cut
	// experession match on any class
	// execution pointcut-->execution(modifiers pattern?return type pattern
	// declaring type pattern?method name pattern(param name pattern) thorws
	// pattern?)
	// spring aop only support public,return type:void boolean...,declaring
	// type:class name,
	// () match method with no argument,(*) match with 1 argument of any type,(..)
	// match with 0 or more arg
	// com.demo.*.*(..) //math on any package any method
	// can combine two experssion using && || !
	// @Before("execution(public void com.demo.dao.MembershipDAO5.addAccount())")
	@Before("execution(* add*(..))")
	@Order(2)
	public void beforeAddAccount() {
		// run basic custom code before method run of addAccount
		System.out.println("\n=====> Execute @Before advice on addAccount(); ");
	}

	@Before("execution(* add*(com.demo.model.Account))")
	@Order(1)
	public void beforeAddAccountWithParam() {
		// run basic custom code before method run of addAccount
		System.out.println("\n=====> Execute @Before advice on addAccount(Account act); ");
	}

	// @Before("useBeforeInDao()")
	@Before("com.demo.aop.MyAnalyticsAspect6.forDaoPackageNoGetterandSetter()")
	@Order(-10)
	public void addBeforeInDao(JoinPoint theJoinPoint) {
		System.out.println("\n=====> Execute @Before addBeforeInDao advice in Dao package add.. method ");
		// display the method signature

		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();

		// get argy
		Object[] arg = theJoinPoint.getArgs();
		// loop through arg
		for (Object a : arg) {
			System.out.println(a);
			if (a instanceof Account) {
				// downcast and print the detail
				Account ac = (Account) a;
				System.out.println("Account name " + ac.getName());
			}
		}

		// display the method argument
		System.out.println("Method: " + methodSign.toString());
	}

}
