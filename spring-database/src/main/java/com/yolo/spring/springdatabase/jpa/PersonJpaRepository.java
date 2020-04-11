package com.yolo.spring.springdatabase.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yolo.spring.springdatabase.entity.Person;

@Repository //alternative to @Component
@Transactional //transaction management
public class PersonJpaRepository {
	
	// Connect to the database
	@PersistenceContext 
	EntityManager entityManager;
	
	//find all persons
	public List<Person> findAllPerson()
	{
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
	    List<Person> personList = namedQuery.getResultList();
		return personList;
	}
	
	//find person by id
	public Person findById(int id)
	{
		Person person = entityManager.find(Person.class, id);//(Entity Class, Primary Key)
		return person;	
	}
	
	//update a person
	public Person updatePerson(Person person)
	{
		Person updatedPerson = entityManager.merge(person);
		//use merge while updating, if id is present then it will update respective person else it will insert it.
		return updatedPerson;
	}
	
	//insert a person
	public Person insertPerson(Person person)
	{
		Person insertedPerson = entityManager.merge(person);
		//use merge while updating, if id is present then it will update respective person else it will insert it.
		return insertedPerson;
	}
	
	//insert a person
	public void deletePersonById(int id)
	{
		Person deletePerson = findById(id);
		entityManager.remove(deletePerson); //remove returns nothing.
		//in this first we have to get person from id and then remove it.
	}
}
