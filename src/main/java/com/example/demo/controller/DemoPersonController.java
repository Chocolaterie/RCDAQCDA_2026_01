package com.example.demo.controller;

import com.example.demo.bo.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoPersonController {

    @GetMapping("/demo-pointer")
    public Person test(){
        // Instancier une classe Person
        Person personA = new Person();
        personA.firstname = "Tata";

        Person personB = new Person();
        personB.firstname = "Velocipastor";

        // Copier coller des valeur
        personA = personB;

        //
        personB.firstname = "Titi";

        // retourner l'instance
        return personA;
    }


    @GetMapping("/get-data")
    public Person sdfklsdlkfklsdfljsdjf(){
        // Instancier une classe Person
        Person person = new Person();
        person.firstname = "Tata";

        // retourner l'instance
        return person;
    }

    @PostMapping("/get-data")
    public Person getDataPost(@RequestBody Person bodyPerson, @RequestBody Person dsdsd){
        // Instancier une classe Person
        Person person = new Person();
        person.firstname = bodyPerson.firstname + "Tata";

        // retourner l'instance
        return person;
    }
}
