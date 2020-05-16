package com.demo.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.demo.*..get*(..))")
	public void logcontrollerMethodsBef(JoinPoint joinpoint) {
		System.out.println("Started calling method >> " + joinpoint.getSignature().getName());
	}

	@After("execution(* com.demo.*..get*(*))")
	public void logcontrollerMethods(JoinPoint joinpoint) {
		System.out.println("Existing calling  method >> " + joinpoint.getSignature().getName());
	}
}
