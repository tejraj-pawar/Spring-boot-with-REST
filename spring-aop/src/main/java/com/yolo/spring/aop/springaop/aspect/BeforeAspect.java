package com.yolo.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect //AOP
@Configuration //Configuration
public class BeforeAspect {

	//PointCut -> What types of method call i want to intercept [advice: @Before(pointCut)]
    
	//execution(* PACKAGE.*.*(..)) 
	//[1st star:all return types, 2nd star:all classes, 3rd star:all methods and *(..):all methods irrespective of arguments] 
	
	@Before("execution(* com.yolo.spring.aop.springaop.business.*.*(..))")
	public void before(JoinPoint joinpoint) 
    {
		//jointpoint provides details about intercepted methods 
    	//above @Before will intercept all method from defined package and this method will execute each time before intercepted method executed.
		//Logic implemented in this method is called as ADVICE
		
		System.out.println("Intercepted Method Call: " + joinpoint);
		System.out.println("Doing stuff before executing above intercepted method");
		
    }
}
