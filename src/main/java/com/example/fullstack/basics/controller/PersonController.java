package com.example.fullstack.basics.controller;

import com.example.fullstack.basics.model.Person;
import com.example.fullstack.basics.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/full-stack-demo/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<Person> create(@RequestBody Person person){
        final Person responseBody = personService.create(person);
        final ResponseEntity<Person> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        return responseEntity;
        }

    //"id" and {id} must match
    @RequestMapping(path = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> readById(@PathVariable Long id) {
        final Person responseBody = personService.getById(id);
        final ResponseEntity<Person> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
        personService.update(id, person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> readAll(){

        List<Person> people = personService.readAll();
        ResponseEntity<List<Person>> responseEntity = new ResponseEntity<>(people, HttpStatus.OK);
        return responseEntity;

    }

}
