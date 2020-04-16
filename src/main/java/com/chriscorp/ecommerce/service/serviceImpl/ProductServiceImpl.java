package com.chriscorp.ecommerce.service.serviceImpl;

import com.chriscorp.ecommerce.model.Product;
import com.chriscorp.ecommerce.repository.ProductRepository;
import com.chriscorp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product postProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product putProduct(Product product) {
        return productRepository.save(product);
    }
}
