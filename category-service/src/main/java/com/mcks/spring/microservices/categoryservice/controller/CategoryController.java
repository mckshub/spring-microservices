package com.mcks.spring.microservices.categoryservice.controller;

import com.mcks.spring.microservices.categoryservice.document.Category;
import com.mcks.spring.microservices.categoryservice.model.ResponseVO;
import com.mcks.spring.microservices.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
        return responseVO;
    }

    @GetMapping(value = "/getAllCategorysByIds", produces = APPLICATION_JSON)
    public ResponseVO getAllCategoriesByIds(final List<Integer> categoryIds) {
        final ResponseVO responseVO = new ResponseVO();
        final List<Category> allCategories = categoryService.getAllCategoriesByList(categoryIds);
        responseVO.setResultObject((Object) allCategories);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

    @GetMapping(value = "/getCategoryById/{categoryId}", produces = APPLICATION_JSON)
    public ResponseVO getCategoryById(@PathVariable ("categoryId") Integer categoryId) {
        ResponseVO responseVO = new ResponseVO();
        Optional<Category> category = categoryService.getCategory(categoryId);
        responseVO.setResultObject((Object) category);
        responseVO.setStatus(true);
        responseVO.setStatusMessages("Success");
        return responseVO;
    }

}