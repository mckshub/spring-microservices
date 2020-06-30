package com.mcks.spring.microservices.categoryservice.service.impl;

import com.mcks.spring.microservices.categoryservice.document.Category;
import com.mcks.spring.microservices.categoryservice.repository.CategoryRepository;
import com.mcks.spring.microservices.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getAllCategoriesByList(final List<Integer> roleIds) {
        return (List<Category>) categoryRepository.findAllById(roleIds);
    }

    @Override
    public Optional<Category> getCategory(final Integer roleId) {
        return categoryRepository.findById(roleId);
    }

}