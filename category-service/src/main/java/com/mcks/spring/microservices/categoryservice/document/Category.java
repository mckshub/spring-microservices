package com.mcks.spring.microservices.categoryservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Category")
public class Category {

	private String categoryName;
	@Id
	@Indexed(unique = true)
	private String categoryCode;
	private String activeInd = "Y";

}