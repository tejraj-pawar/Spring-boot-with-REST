/*
 * here we're creating spring-boot projects with springboot web starter
 * we're creating rest service. go to BooksRestController.java.
 * run this file and you can access all the rest services on localhost:8080(tomcat port) 
 * 
 * Spring Actuators:
 * add dependendy spring-boot-starter-actuator and spring-data-rest-hal-browser 
 * add property in application.properties file -> management.endpoints.web.exposure.include=* 
 * restart the applicatin
 * go to localhost:8080/actuator  [hal browser: localhost:8080]
 */



package com.yolo.springboot.basics.springboot;

import java.applet.AppletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * Three things done by @SpringBootApplication:
 * > indicates this as a spring context
 * > does @ComponentScan by its own
 * > does auto configuration by its own
 */
 
@SpringBootApplication 
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args); //returns application context
		
		// List all beans from application context
		System.out.println("Beans present in application context:");
		//for(String bean : applicationContext.getBeanDefinitionNames())
			//System.out.println(bean);
		System.err.println("Total beans in application context: " + applicationContext.getBeanDefinitionCount());
	}

}
