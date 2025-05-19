package com.example.fullstack.basics.repository;


import com.example.fullstack.basics.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByFirstName(String firstName);

    //Example of @Query annotation in JPQL
    @Query("SELECT p FROM Person p WHERE p. firstName LIKE %:name%")
    Person findByThierName(String name);

}