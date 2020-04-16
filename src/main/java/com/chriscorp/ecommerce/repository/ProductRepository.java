package com.chriscorp.ecommerce.repository;

import com.chriscorp.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
