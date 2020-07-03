package com.mcks.spring.microservices.userservice.repository;

import com.mcks.spring.microservices.userservice.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    User findByEmail(final String email);
}
