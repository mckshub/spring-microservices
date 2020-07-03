package com.mcks.spring.microservices.userservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
    private Integer subCategoryId;
    private String subCategoryName;
    private String subCategoryCode;
    private String activeInd;

}
