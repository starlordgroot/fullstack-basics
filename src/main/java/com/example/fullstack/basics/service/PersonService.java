package com.example.fullstack.basics.service;


import com.example.fullstack.basics.model.Person;
import com.example.fullstack.basics.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
