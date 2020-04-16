package com.chriscorp.ecommerce.service.serviceImpl;

import com.chriscorp.ecommerce.model.SubCategory;
import com.chriscorp.ecommerce.repository.SubCategoryRepository;
import com.chriscorp.ecommerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllSubCategory() {
        return subCategoryRepository.findAll();
    }

    @Override
    public Optional<SubCategory> getSubCategoryById(long id) {
        return subCategoryRepository.findById(id);
    }

    @Override
    public void deleteSubCategoryById(long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public SubCategory postSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory putSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }
}
