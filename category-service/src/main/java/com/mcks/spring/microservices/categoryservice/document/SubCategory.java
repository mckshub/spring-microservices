package com.mcks.spring.microservices.categoryservice.document;

import org.springframework.data.mongodb.core.mapping.Document;

/*@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor*/
@Document(collection = "SubCategory")
public class SubCategory {
    private Integer subCategoryId;
    private String subCategoryName;
    private String subCategoryCode;
    private String activeInd;

    public SubCategory() {
        super();
    }

    public SubCategory(Integer subCategoryId, String subCategoryName, String subCategoryCode, String activeInd) {
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.subCategoryCode = subCategoryCode;
        this.activeInd = activeInd;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "subCategoryId=" + subCategoryId +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", subCategoryCode='" + subCategoryCode + '\'' +
                ", activeInd='" + activeInd + '\'' +
                '}';
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }
}
