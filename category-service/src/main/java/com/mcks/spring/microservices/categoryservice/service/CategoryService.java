package com.mcks.spring.microservices.categoryservice.service;

import com.mcks.spring.microservices.categoryservice.document.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Category> getAllCategoriesByList(final List<Integer> categoryIds);

    Optional<Category> getCategory(final Integer categoryId);

}