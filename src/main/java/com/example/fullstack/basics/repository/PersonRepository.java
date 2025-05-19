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

    //Example with SQL
    @Query(value = "SELECT * FROM person WHERE firstName = ?1", nativeQuery = true)
    Person findByTheirNameSQL(String name);

}