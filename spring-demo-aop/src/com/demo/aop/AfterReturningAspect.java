package com.demo.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.model.Account;

@Aspect
@Component
@Order(3)
public class AfterReturningAspect {

	// add a new advice for @AfterReturning on the findAccount method
	@AfterReturning(pointcut = "execution(* com.demo.dao.AccountDAO1.findAccount(..))", returning = "theResult")
	public void afterReturningFindAccoutsAdvice(JoinPoint joinPoint, List<Account> theResult) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n executing @AfterReturning  on method " + method);
		convertStringListToUpperCase(theResult);

		System.out.println("\n==> result is " + theResult);
	}

	private void convertStringListToUpperCase(List<Account> theResult) {
		for (Account acn : theResult) {
			// get upper case of name
			// update the name of account
			acn.setName(acn.getName().toUpperCase());

		}

	}
}
