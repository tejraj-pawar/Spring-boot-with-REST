package com.yolo.spring.aop.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository //it is for data layer, similar to @Component,
public class Dao2 {
	
	public String retrieveSomething()
	{
		return "Dao2";
	}

}
