package com.yolo.spring.aop.springaop.dao;

import org.springframework.stereotype.Repository;

import com.yolo.spring.aop.springaop.aspect.TrackTime;

@Repository //it is for data layer, similar to @Component,
public class Dao1 {
	
	@TrackTime
	public String retrieveSomething()
	{
		return "Dao1";
	}

}
