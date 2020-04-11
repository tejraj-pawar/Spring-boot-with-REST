package com.yolo.spring.aop.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yolo.spring.aop.springaop.dao.Dao1;


@Service //it is for business layer, similar to @Component,
public class Business1 {
	
	@Autowired
	private Dao1 dao1;
	
	public String calculateSomething()
	{
		//Business Logic
		return dao1.retrieveSomething();
	}

}
