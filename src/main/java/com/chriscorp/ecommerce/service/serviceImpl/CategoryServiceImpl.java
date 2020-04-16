package com.chriscorp.ecommerce.service.serviceImpl;

import com.chriscorp.ecommerce.model.Category;
import com.chriscorp.ecommerce.repository.CategoryRepository;
import com.chriscorp.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category postCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category putCategory(Category category) {
        return categoryRepository.save(category);
    }
}
