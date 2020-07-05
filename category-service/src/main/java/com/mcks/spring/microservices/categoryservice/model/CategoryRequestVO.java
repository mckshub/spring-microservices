package com.mcks.spring.microservices.categoryservice.model;

import java.util.List;

import com.mcks.spring.microservices.categoryservice.document.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestVO {

	private Category category;
	
	private List<Category> categories;
	
	private List<String> categoryIds;
}
