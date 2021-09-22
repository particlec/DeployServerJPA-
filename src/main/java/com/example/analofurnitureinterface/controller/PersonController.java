package com.example.analofurnitureinterface.controller;


import com.example.analofurnitureinterface.dao.PersonRepository;
import com.example.analofurnitureinterface.entity.Person;
import com.example.analofurnitureinterface.pojo.PersonVO;
import com.example.analofurnitureinterface.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello!";
    }

    @RequestMapping("/create")
    public void createFieldDataTable() {
        personService.createPerson();
    }

    @ResponseBody
    @RequestMapping("/query")
    public Page<PersonVO> queryPerson() {
      return   personService.queryPerson();
    }


    @RequestMapping(value = "/save")
    public Person savePerson(String name, String address, Integer age){
        return personRepository.save(new Person(null,name,age,address));
    }

    @RequestMapping(value = "/findByName")
    public List<Person> findByName(String name){
        return personRepository.findByName(name);
    }
}
