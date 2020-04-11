package com.yolo.spring.springdatabase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yolo.spring.springdatabase.entity.Person;

@Repository //best alternative for @Component
public class PersonJdbcDao {
  
	@Autowired
	JdbcTemplate jdbcTemplate; //this will manage database connection by its own.
	
	class PersonRowMapper implements RowMapper<Person>
	{
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			
			//set values in Person from resultSet
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			
			return person;
		}
		
	}
	
	// return result of select * from person
		public List<Person> findAllUsingCustomRowMapper()
		{
			List<Person> result = jdbcTemplate.query("select * from person", new PersonRowMapper());
			// BeanPropertyRowMapper is to map output of query to Person bean
	        return result;	
		}
	
	// return result of select * from person
	public List<Person> findAll()
	{
		List<Person> result = jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
		// BeanPropertyRowMapper is to map output of query to Person bean
        return result;	
	}
	
	//find person by Id
	public Person findById(int id)
	{
		Person person = jdbcTemplate.queryForObject("select * from person where id=?",new Object[]{id}, 
				              new BeanPropertyRowMapper<Person>(Person.class));
		//2nd argument is use to pass input to query.
        return person;	
	}
	
	//delete person by Id
	public int deleteById(int id)
	{
		int howManyRowsDeleted = jdbcTemplate.update("delete from person where id=?",new Object[]{id});
		//use update method when you perform DML queries.
        return howManyRowsDeleted;	
	}
	
	//insert new person record into table
	public int insertPerson(Person person)
	{
		int howManyRowsUpdated = jdbcTemplate.update
				("insert into person values(?,?,?,?)",
				new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
		//use update method when you perform DML queries.
        return howManyRowsUpdated;	
	}
	
	//Update person record into table
		public int updatePerson(Person person)
		{
			int howManyRowsUpdated = jdbcTemplate.update
					("update person set name = ?, location = ?, birth_date = ? where id = ?",
					new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
			//use update method when you perform DML queries.
	        return howManyRowsUpdated;	
		}
	
	
	
	
}
