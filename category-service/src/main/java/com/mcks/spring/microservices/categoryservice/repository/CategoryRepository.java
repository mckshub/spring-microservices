package com.mcks.spring.microservices.categoryservice.repository;

import com.mcks.spring.microservices.categoryservice.document.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer> {

}