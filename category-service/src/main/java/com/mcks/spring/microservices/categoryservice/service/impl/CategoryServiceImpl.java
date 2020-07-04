package com.mcks.spring.microservices.categoryservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcks.spring.microservices.categoryservice.document.Category;
import com.mcks.spring.microservices.categoryservice.repository.CategoryRepository;
import com.mcks.spring.microservices.categoryservice.service.CategoryService;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getAllCategoriesByList(List<String> categoryCodes) {

		LOGGER.debug("Category codes obtained from RequestVO : {}", categoryCodes);

		List<Category> categories = new ArrayList<>();
		categoryCodes.forEach(categoryCode -> {
			Category category = getCategory(categoryCode).get();
			categories.add(category);
		});

		return categories;
	}

	@Override
	public Optional<Category> getCategory(String code) {
		return categoryRepository.findByCategoryCode(code);
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> saveAll(List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}

}