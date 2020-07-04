package com.mcks.spring.microservices.categoryservice.service;

import java.util.List;
import java.util.Optional;

import com.mcks.spring.microservices.categoryservice.document.Category;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Category> getAllCategoriesByList(final List<String> categorycodes);

    Optional<Category> getCategory(final String code);

	Category save(Category category);

	List<Category> saveAll(List<Category> categories);

}