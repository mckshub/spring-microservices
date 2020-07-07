package com.mcks.spring.microservices.userservice.proxy.category;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "category-service", path="category-service")
public interface ICategoryServiceProxy {

	@PostMapping(value = "/category/getAllCategoriesByIds", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryResponseModel getAllCategoriesByIds(@RequestBody final CategoryRequestModel requestVO);
	
	@GetMapping(value = "/getAllCategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryResponseModel getAllCategories();
	
}
