package com.chriscorp.ecommerce.controller;


import com.chriscorp.ecommerce.model.Product;
import com.chriscorp.ecommerce.model.SubCategory;
import com.chriscorp.ecommerce.service.SubCategoryService;
import com.chriscorp.ecommerce.service.serviceImpl.SubCategoryServiceImpl;
import org.hibernate.mapping.Subclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryServiceImpl subCategoryService;

    @GetMapping
    public List<SubCategory> getAllSubCategory(){
        return subCategoryService.getAllSubCategory();
    }

    @GetMapping("/{id}")
    public Optional<SubCategory> getSubCategoryById(@PathVariable(name = "id") long id){
        return subCategoryService.getSubCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSubCategoryById(@PathVariable(name = "id") long id){
        subCategoryService.deleteSubCategoryById(id);
    }

    @PostMapping
    public SubCategory postSubCategory(@RequestBody SubCategory subCategory){
        return subCategoryService.postSubCategory(subCategory);
    }

    @PutMapping("/{id}")
    public SubCategory putProduct(@RequestBody SubCategory subCategory, @PathVariable(name = "id") long id) throws Exception {
        return subCategoryService.getSubCategoryById(id).map(newObj -> {
            newObj.setName (subCategory.getName());
            return subCategoryService.putSubCategory(newObj);
        }).orElseThrow(() -> new Exception("SubCategory with id " + id + "not found"));
    }

}
