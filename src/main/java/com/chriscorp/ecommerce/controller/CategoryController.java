package com.chriscorp.ecommerce.controller;

import com.chriscorp.ecommerce.model.Category;
import com.chriscorp.ecommerce.service.serviceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable(name = "id") long id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable(name = "id") long id){
        categoryService.deleteCategoryById(id);
    }

    @PostMapping
    public Category postCategory(@RequestBody Category category){
        return categoryService.postCategory(category);
    }

    @PutMapping("/{id}")
    public Category putCategory(@RequestBody Category category, @PathVariable(name = "id") long id) throws Exception {
        return categoryService.getCategoryById(id).map(newObj -> {
            newObj.setName (category.getName());
            newObj.setPhoto(category.getPhoto());
            return categoryService.putCategory(newObj);
        }).orElseThrow(() -> new Exception("Category with id " + id + "not found"));
    }

}
