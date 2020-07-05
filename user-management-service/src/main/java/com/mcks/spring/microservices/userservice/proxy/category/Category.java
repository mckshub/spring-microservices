package com.mcks.spring.microservices.userservice.proxy.category;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_NULL)
public class Category implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1712579538179046173L;
	
    private String categoryName;
    private String categoryCode;
    private String activeInd;

}