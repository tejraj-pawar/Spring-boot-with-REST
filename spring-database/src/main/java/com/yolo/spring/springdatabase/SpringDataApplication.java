package com.yolo.spring.springdatabase;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yolo.spring.springdatabase.entity.Person;
import com.yolo.spring.springdatabase.jdbc.PersonJdbcDao;
import com.yolo.spring.springdatabase.jpa.PersonJpaRepository;
import com.yolo.spring.springdatabase.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	@Autowired
	 PersonSpringDataRepository springDataRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override // from CommandLineRunner interface
	public void run(String... args) throws Exception {
		
		
		System.out.println("Inserting person: " + springDataRepository.save(new Person("yoloishere", "san", new Date())));
		System.out.println("Inserting person: " + springDataRepository.save(new Person("yolo1", "san1", new Date())));
		System.out.println("Person with id 1: " + springDataRepository.findById(1));
		
	    System.out.println("Updating person: " + springDataRepository.save(new Person("yolo1", "san1", new Date())));

	        
	    System.out.println("Deleting person with id 3");
	    springDataRepository.deleteById(3);
	    
	    System.out.println("List all the persons: " + springDataRepository.findAll());
	}

}
