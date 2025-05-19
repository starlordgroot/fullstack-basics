package com.example.fullstack.basics.repository;


import com.example.fullstack.basics.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByFirstName(String firstName);

}