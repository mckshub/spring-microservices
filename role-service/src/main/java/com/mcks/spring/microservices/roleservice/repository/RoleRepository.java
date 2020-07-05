package com.mcks.spring.microservices.roleservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcks.spring.microservices.roleservice.document.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer> {

	Optional<Role> findByRoleCode(String code);
    
}