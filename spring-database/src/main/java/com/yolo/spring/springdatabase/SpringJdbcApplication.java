package com.yolo.spring.springdatabase;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yolo.spring.springdatabase.entity.Person;
import com.yolo.spring.springdatabase.jdbc.PersonJdbcDao;

////@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner{

	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override // from CommandLineRunner interface
	public void run(String... args) throws Exception {
        System.out.println("All records from Person Table: " + personJdbcDao.findAll()); 
        /*
         * All records from Person Table: [
           Person [id=10001, name=Ranga, location=Hyderabad, birthDate=2020-03-27 00:00:00.0], 
           Person [id=10002, name=James, location=New York, birthDate=2020-03-27 00:00:00.0], 
           Person [id=10003, name=Pieter, location=Amsterdam, birthDate=2020-03-27 00:00:00.0]
           ]
         */
        System.out.println("Person with id 10001: " + personJdbcDao.findById(10001));
        /*
         * Person with id 10001: 
           Person [id=10001, name=Ranga, location=Hyderabad, birthDate=2020-03-27 00:00:00.0]
         */
        System.out.println("Deleting id 10003: -> No of rows deleted: " + personJdbcDao.deleteById(10003));
	    //Deleting id 10003: -> No of rows deleted: 1
	    System.out.println("Inserting 10004: -> No of rows inserted: " + personJdbcDao.insertPerson(new Person(10004, "yolo", "san", new Date())));
	    //Inserting 10004: -> No of rows inserted: 1
	    System.out.println("Updating 10001: -> No of rows updated: " + personJdbcDao.updatePerson(new Person(10001, "yolo1", "san1", new Date())));
	    //Updating 10001: -> No of rows updated: 1
	    System.out.println("All records from Person using Custom RowMapper: " + personJdbcDao.findAllUsingCustomRowMapper());
	    /*
	     * All records from Person using Custom RowMapper: [
           Person [id=10001, name=yolo1, location=san1, birthDate=2020-03-27 22:15:03.826], 
           Person [id=10002, name=James, location=New York, birthDate=2020-03-27 00:00:00.0], 
           Person [id=10004, name=yolo, location=san, birthDate=2020-03-27 22:15:03.824]]
	     */
	}

}
