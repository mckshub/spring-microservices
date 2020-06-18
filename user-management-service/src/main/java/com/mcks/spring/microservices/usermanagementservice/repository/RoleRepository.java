package com.mcks.spring.microservices.usermanagementservice.repository;

import com.mcks.spring.microservices.usermanagementservice.model.Role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {
    
}