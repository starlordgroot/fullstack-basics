package com.example.fullstack.basics.config;


import com.example.fullstack.basics.model.Person;
import com.example.fullstack.basics.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Autowired
    private PersonRepository personRepository;


    @PostConstruct
    public void setup(){
        System.out.println("PersonConfig.setup()");

        Person person = new Person();

        String firstName = "David";
        String lastName = "Wise";

        person.setFirstName(firstName);
        person.setLastName(lastName);

        personRepository.save(person);

    }


}
