package com.yolo.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

//@Aspect //AOP
@Configuration //Configuration
public class MethodExecCalAspect {
	
	//@Around will first intercept the method and then allow it to run and come back to @Around after execution completion.

	//below method is cal. time taken by intercepted method
	//@Around("execution(* com.yolo.spring.aop.springaop.business.*.*(..))")
	@Around("com.yolo.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void calExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		proceedingJoinPoint.proceed(); // allowing intercepted method to run
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("Intercepted method: " + proceedingJoinPoint);
		System.out.println("Exection time of Intercepted Method: " + timeTaken);
	}
}
