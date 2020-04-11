package com.yolo.spring.aop.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yolo.spring.aop.springaop.dao.Dao2;


@Service //it is for business layer, similar to @Component,
public class Business2 {
	
	@Autowired
	private Dao2 dao2;
	
	public String calculateSomething()
	{
		//Business Logic
		return dao2.retrieveSomething();
	}

}
