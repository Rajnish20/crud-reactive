package com.example.poc.service;

import com.example.poc.entity.Person;
import com.example.poc.exception.PersonException;
import com.example.poc.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Flux<Person> getAll() {
        return personRepository.findAll().switchIfEmpty(Flux.error(new PersonException("No Data Found")));
    }

    @Override
    public Mono<Person> createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Mono<Person> update(String id, Person person) {
        return personRepository.findById(id).flatMap(curr-> {
            curr.setName(person.getName());
            curr.setGender(person.getGender());
            curr.setState(person.getState());
            curr.setCity(person.getCity());
            return personRepository.save(curr);
        }).switchIfEmpty(Mono.error(new PersonException("Person Not Found")));
    }

    @Override
    public Mono<Person> getById(String personId) {
        return personRepository
                .findById(personId)
                .switchIfEmpty(Mono.error(new PersonException("Person Not Found")));
    }

    @Override
    public Mono<Void> deleteById(String personId) {
        return personRepository.findById(personId)
                .switchIfEmpty(Mono.error(new PersonException("Person Not Found")))
                .flatMap(personRepository::delete);
    }
}
