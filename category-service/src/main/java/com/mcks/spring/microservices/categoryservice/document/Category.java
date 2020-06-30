package com.mcks.spring.microservices.categoryservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor*/
@Document(collection = "Category")
public class Category {

    private Integer categoryId;
    private String categoryName;
    private String categoryCode;
    private List<SubCategory> subCategories;
    private String activeInd;

    public Category() {
        super();
    }

    public Category(Integer categoryId, String categoryName, String categoryCode, List<SubCategory> subCategories, String activeInd) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.subCategories = subCategories;
        this.activeInd = activeInd;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", subCategories=" + subCategories +
                ", activeInd='" + activeInd + '\'' +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }
}