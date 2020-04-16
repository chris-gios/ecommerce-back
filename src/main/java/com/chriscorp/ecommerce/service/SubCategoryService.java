package com.chriscorp.ecommerce.service;

import com.chriscorp.ecommerce.model.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {

    List<SubCategory> getAllSubCategory();

    Optional<SubCategory> getSubCategoryById(long id);

    void deleteSubCategoryById(long id);

    SubCategory postSubCategory(SubCategory subCategory);

    SubCategory putSubCategory(SubCategory subCategory);

}
