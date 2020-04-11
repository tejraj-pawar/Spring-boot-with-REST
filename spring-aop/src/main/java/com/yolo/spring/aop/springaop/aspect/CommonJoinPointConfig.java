package com.yolo.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

//pass this pointCut method's qualified name in place of pointCut

public class CommonJoinPointConfig {
	@Pointcut("execution(* com.yolo.spring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution()
	{
	}
	
	@Pointcut("execution(* com.yolo.spring.aop.springaop.business.*.*(..))")
	public void businessLayerExecution()
	{
	}
	
	@Pointcut("com.yolo.spring.aop.springaop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.yolo.spring.aop.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void bothLayerExecution()
	{
	}
     
	@Pointcut("bean(Dao*)")
	public void beanStartingWithDao()
	{
	}
	
	@Pointcut("bean(*Dao*)")
	public void beanContainingDao()
	{
	}
	
	@Pointcut("within(com.yolo.spring.aop.springaop.data..*)")
	public void withinPackage()
	{
	}
	
	
	// for custom annotations
	@Pointcut("@annotation(com.yolo.spring.aop.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation()
	{
	}
}
