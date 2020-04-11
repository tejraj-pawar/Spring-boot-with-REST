package com.yolo.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect //AOP
@Configuration //Configuration
public class AfterAspect {

	@AfterReturning(
			value=
			"execution(* com.yolo.spring.aop.springaop.business.*.*(..))",
			returning="result")
	public void afterReturnnig(JoinPoint joinpoint, Object result) 
    {
    	//above @After will intercept all method from defined package and this method will execute each time after Returning from intercepted method execution.
		System.out.println("Intercepted Method: " + joinpoint);
		System.out.println("Above intercepted method returned with: " + result.toString());
		System.out.println("Doing stuff after intercepted method returns");
    }
	
	@AfterThrowing(
			value="execution(* com.yolo.spring.aop.springaop.business.*.*(..))",
			throwing="exception")
	public void afterThrowing(JoinPoint joinpoint, Object exception) 
    {
    	//above @AfterThrowing will intercept all method from defined package and this method will run when intercepted method caught exception .
		System.out.println("Intercepted Method: " + joinpoint);
		System.out.println("Above intercepted method returned with exception: " + exception.toString());
		System.out.println("Doing stuff after intercepted method throws an exception");
    }
	
	@After(
			value="execution(* com.yolo.spring.aop.springaop.business.*.*(..))")
	public void after(JoinPoint joinpoint) 
    {
    	//above @After will intercept all method from defined package and this method will execute each time after intercepted method executed.
		System.out.println("Intercepted Method: " + joinpoint);
		System.out.println("Doing stuff after executing above intercepted method");
    }
}
