package com.mcks.spring.microservices.categoryservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mcks.spring.microservices.categoryservice.document.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

	Optional<Category> findByCategoryCode(String code);

}