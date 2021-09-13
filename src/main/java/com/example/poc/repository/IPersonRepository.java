package com.example.poc.repository;


import com.example.poc.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends ReactiveMongoRepository<Person,String> {
}
