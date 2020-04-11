package com.yolo.spring.springdatabase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@Table(name="person") no need as our table and class name is same.
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {
	
	@Id //primary key
	@GeneratedValue //like sequence in sql (auto-increment)
	private int id;
	
	//@Column(name="name")
	private String name;
	private String location;
	private Date birthDate;
	/*
	 * if variable name and table column name are same then No need to define @Column.
	 */
	
	// for hibernate, as hibernate will manage id.(@GeneratedValue)
	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public Person()
	{
		// this no-args constructor is compulsory for BeanPropertyRowMapper to work/run.
	}
	
	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	
	
}
