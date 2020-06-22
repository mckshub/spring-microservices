package com.mcks.spring.microservices.usermanagementservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcks.spring.microservices.usermanagementservice.document.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {
    
}