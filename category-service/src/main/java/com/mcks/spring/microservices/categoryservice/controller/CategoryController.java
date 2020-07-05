package com.mcks.spring.microservices.categoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcks.spring.microservices.categoryservice.document.Category;
import com.mcks.spring.microservices.categoryservice.model.CategoryRequestVO;
import com.mcks.spring.microservices.categoryservice.model.CategoryResponseVO;
import com.mcks.spring.microservices.categoryservice.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/getAllCategories", produces = APPLICATION_JSON)
    public CategoryResponseVO getAllCategories() {
        final CategoryResponseVO responseVO = new CategoryResponseVO();
        final List<Category> allCategories = categoryService.getAllCategories();
        responseVO.setResultObject(allCategories);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

    @PostMapping(value = "/getAllCategoriesByIds", produces = APPLICATION_JSON)
    public CategoryResponseVO getAllCategoriesByIds(@RequestBody final CategoryRequestVO requestVO) {
        final CategoryResponseVO responseVO = new CategoryResponseVO();
        final List<Category> allCategories = categoryService.getAllCategoriesByList(requestVO.getCategoryIds());
        responseVO.setResultObject(allCategories);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

    @GetMapping(value = "/getCategoryById/{categoryId}", produces = APPLICATION_JSON)
    public CategoryResponseVO getCategoryById(@PathVariable ("categoryId") String categoryId) {
        CategoryResponseVO responseVO = new CategoryResponseVO();
        Optional<Category> category = categoryService.getCategory(categoryId);
        responseVO.setResultObject(category);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }
    
    @PostMapping(value = "/saveCategory", produces = APPLICATION_JSON)
    public CategoryResponseVO saveCategory(@RequestBody final CategoryRequestVO requestVO) {
    	CategoryResponseVO responseVO = new CategoryResponseVO();
    	Category savedCategory = categoryService.save(requestVO.getCategory());
    	responseVO.setResultObject(savedCategory);
    	responseVO.setStatus(true);
    	responseVO.setStatusMessages("Success");
    	return responseVO;
    }
    
    @PostMapping(value = "/saveAllCategories", produces = APPLICATION_JSON)
    public CategoryResponseVO saveAllCategories(@RequestBody final CategoryRequestVO requestVO) {
    	CategoryResponseVO responseVO = new CategoryResponseVO();
    	List<Category> savedCategories = categoryService.saveAll(requestVO.getCategories());
    	responseVO.setResultObject(savedCategories);
    	responseVO.setStatus(true);
    	responseVO.setStatusMessages("Success");
    	return responseVO;
    }

}