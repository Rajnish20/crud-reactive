package com.example.poc.service;

import com.example.poc.entity.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

    Flux<Person> getAll();

    Mono<Person> createPerson(Person person);

    Mono<Person> update (final String id, final Person person);

    Mono<Person> getById(final String personId);

    Mono<Void> deleteById(final String personId);
}
