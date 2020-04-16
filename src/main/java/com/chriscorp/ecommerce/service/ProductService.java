package com.chriscorp.ecommerce.service;

import com.chriscorp.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct();

    Optional<Product> getProductById(long id);

    void deleteProductById(long id);

    Product postProduct(Product product);

    Product putProduct(Product product);

}
