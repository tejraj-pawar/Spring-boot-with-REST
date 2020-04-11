package com.yolo.spring.springdatabase.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolo.spring.springdatabase.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{}
