package com.chriscorp.ecommerce.service;

import com.chriscorp.ecommerce.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    Optional<Category> getCategoryById(long id);

    void deleteCategoryById(long id);

    Category postCategory(Category category);

    Category putCategory(Category category);



}
