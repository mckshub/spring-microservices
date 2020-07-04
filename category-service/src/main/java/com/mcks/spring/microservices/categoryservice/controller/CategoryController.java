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
import com.mcks.spring.microservices.categoryservice.model.ResponseVO;
import com.mcks.spring.microservices.categoryservice.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

    private static final String APPLICATION_JSON = "application/json";

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/getAllCategories", produces = APPLICATION_JSON)
    public ResponseVO getAllCategories() {
        final ResponseVO responseVO = new ResponseVO();
        final List<Category> allCategories = categoryService.getAllCategories();
        responseVO.setResultObject((Object) allCategories);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

    @PostMapping(value = "/getAllCategoriesByIds", produces = APPLICATION_JSON)
    public ResponseVO getAllCategoriesByIds(@RequestBody final CategoryRequestVO requestVO) {
        final ResponseVO responseVO = new ResponseVO();
        final List<Category> allCategories = categoryService.getAllCategoriesByList(requestVO.getCategoryIds());
        responseVO.setResultObject((Object) allCategories);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

    @GetMapping(value = "/getCategoryById/{categoryId}", produces = APPLICATION_JSON)
    public ResponseVO getCategoryById(@PathVariable ("categoryId") String categoryId) {
        ResponseVO responseVO = new ResponseVO();
        Optional<Category> category = categoryService.getCategory(categoryId);
        responseVO.setResultObject((Object) category);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }
    
    @PostMapping(value = "/saveCategory", produces = APPLICATION_JSON)
    public ResponseVO saveCategory(@RequestBody final CategoryRequestVO requestVO) {
    	ResponseVO responseVO = new ResponseVO();
    	Category savedCategory = categoryService.save(requestVO.getCategory());
    	responseVO.setResultObject(savedCategory);
    	responseVO.setStatus(true);
    	responseVO.setStatusMessages("Success");
    	return responseVO;
    }
    
    @PostMapping(value = "/saveAllCategories", produces = APPLICATION_JSON)
    public ResponseVO saveAllCategories(@RequestBody final CategoryRequestVO requestVO) {
    	ResponseVO responseVO = new ResponseVO();
    	List<Category> savedCategories = categoryService.saveAll(requestVO.getCategories());
    	responseVO.setResultObject(savedCategories);
    	responseVO.setStatus(true);
    	responseVO.setStatusMessages("Success");
    	return responseVO;
    }

}