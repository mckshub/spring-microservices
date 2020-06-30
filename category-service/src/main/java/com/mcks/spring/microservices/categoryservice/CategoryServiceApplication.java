package com.mcks.spring.microservices.categoryservice;

import com.mcks.spring.microservices.categoryservice.document.Category;
import com.mcks.spring.microservices.categoryservice.document.SubCategory;
import com.mcks.spring.microservices.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class CategoryServiceApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /* Creating subcategories for Mobile Category */
        List<SubCategory> subCategoriesToMobileCategory = new ArrayList<>();
        subCategoriesToMobileCategory.add(new SubCategory(1, "Prepaid", "MOBL-PRE", "Y"));
        subCategoriesToMobileCategory.add(new SubCategory(2, "Postpaid", "MOBL-POST", "Y"));

        /* Creating categories with Subcategory */
        Category mobileCategory = new Category(1, "Mobile", "MOBL", subCategoriesToMobileCategory, "Y");
        Category electricityCategory = new Category(2, "Electricity", "ELECTRIC", null, "Y");
        Category dthRecharge = new Category(3, "DTH Recharge", "DTHRECH", null, "Y");

        List<Category> categoriesList = new ArrayList<>();
        categoriesList.add(mobileCategory);
        categoriesList.add(electricityCategory);
        categoriesList.add(dthRecharge);

        /* Saving all categories created */
        categoryRepository.saveAll(categoriesList);

    }


}
							