package com.example.fullstack.basics.service;


import com.example.fullstack.basics.model.Person;
import com.example.fullstack.basics.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.personRepository = repository;
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public void update(Long id, Person person){
        personRepository.save(person);
    }

    public List<Person> readAll(){
        final Iterable<Person> allRecords = personRepository.findAll();
        final List<Person> result = new ArrayList<>();

        allRecords.forEach(result::add);

        return result;
    }

    public Person create(Person personToCreate){
        if (personToCreate == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if (personToCreate.getFirstName() == null || personToCreate.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (personToCreate.getLastName() == null || personToCreate.getLastName().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is required");
        }

        return personRepository.save(personToCreate);

    }

}
