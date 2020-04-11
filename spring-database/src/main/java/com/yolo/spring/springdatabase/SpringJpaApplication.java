package com.yolo.spring.springdatabase;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yolo.spring.springdatabase.entity.Person;
import com.yolo.spring.springdatabase.jdbc.PersonJdbcDao;
import com.yolo.spring.springdatabase.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner{

	@Autowired
	PersonJpaRepository personJpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override // from CommandLineRunner interface
	public void run(String... args) throws Exception {
		System.out.println("Person with id 10001: " + personJpaRepository.findById(10001));
		//Person with id 10001: 
		//Person [id=10001, name=Ranga, location=Hyderabad, birthDate=2020-03-28 00:00:00.0]
		
		System.out.println("Inserting 10004: " + personJpaRepository.insertPerson(new Person(10004, "yolo", "san", new Date())));
	    System.out.println("Updating 10001: " + personJpaRepository.updatePerson(new Person(10001, "yolo1", "san1", new Date())));
	    /*
	    Inserting 10004: 
	    Person [id=1, name=yolo, location=san, birthDate=Sat Mar 28 13:17:36 IST 2020]
	    Updating 10001: 
	    Person [id=10001, name=yolo1, location=san1, birthDate=Sat Mar 28 13:17:36 IST 2020]
	    */
	        
	    System.out.println("Deleting person with id 10003");
	    personJpaRepository.deletePersonById(10003);
	    
	    System.out.println("List all the persons: " + personJpaRepository.findAllPerson());
	    /*
	     List all the persons: [
         Person [id=1, name=yolo, location=san, birthDate=2020-03-28 13:55:35.688], 
         Person [id=10001, name=yolo1, location=san1, birthDate=2020-03-28 13:55:35.769], 
         Person [id=10002, name=James, location=New York, birthDate=2020-03-28 00:00:00.0]]
	     */

	}

}
