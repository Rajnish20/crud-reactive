package com.example.poc.controller;


import com.example.poc.entity.Person;
import com.example.poc.service.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public Flux<Person> getAll(){
        return personService.getAll();
    }

    @PostMapping
    public Mono<Person> createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping("/{personId}")
    public Mono<Person> getById(@PathVariable ("personId") final String personId){
        return personService.getById(personId);
    }

    @PutMapping("/{personId}")
    public Mono<Person> updateById(@PathVariable ("personId") final String personId, @RequestBody Person person){
        return personService.update(personId,person);
    }

    @DeleteMapping("/{personId}")
    public Mono<Void> delete(@PathVariable ("personId") final String personId ){
        return personService.deleteById(personId);
    }

}
