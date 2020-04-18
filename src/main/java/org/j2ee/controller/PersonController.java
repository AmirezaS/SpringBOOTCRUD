package org.j2ee.controller;

import org.j2ee.model.entity.Person;
import org.j2ee.model.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonJpaRepository repository;

    @RequestMapping("/save.do")
    public Object save(@ModelAttribute Person person){
        repository.save(person);
        return findAll();
    }

    @RequestMapping("/remove.do")
    public Object remove(@ModelAttribute Person person){
        repository.deleteById(person.getId());
        return findAll();
    }

    @RequestMapping("/update.do")
    public Object update(@ModelAttribute Person person){
        repository.update(person.getId(),person.getName(),person.getFamily(),person.getEmail());
        return findAll();
    }

    @RequestMapping("/findOne.do")
    public Object findOne(@ModelAttribute Person person){
        return repository.findById(person.getId());
    }
    @RequestMapping("/findAll.do")
    private Object findAll() {
        return repository.findAll();
    }

}
