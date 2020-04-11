/*
 * Go through Spring AOP SS. I have mentioned everything over there.
 */

package com.yolo.spring.aop.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yolo.spring.aop.springaop.business.Business1;
import com.yolo.spring.aop.springaop.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner
// Spring invokes everything defined in CommandLineRunner, when spring application launches.
{
    @Autowired
    Business1 bussines1;
    @Autowired
    Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	    System.out.println("This will run after run() executed"); // this will print after run() metho d executed.
	}

	@Override // from interface CommandLineRunner
	public void run(String... args) throws Exception {
		System.out.println(bussines1.calculateSomething());
		System.out.println(business2.calculateSomething());
	}

}
