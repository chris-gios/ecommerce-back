package com.chriscorp.ecommerce.controller;


import com.chriscorp.ecommerce.model.Product;
import com.chriscorp.ecommerce.service.ProductService;
import com.chriscorp.ecommerce.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable(name = "id") long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable(name = "id") long id){
        productService.deleteProductById(id);
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product){
        return productService.postProduct(product);
    }

    @PutMapping("/{id}")
    public Product putProduct(@RequestBody Product product, @PathVariable(name = "id") long id) throws Exception {
        return productService.getProductById(id).map(newObj -> {
            newObj.setName(product.getName());
            newObj.setDescription(product.getDescription());
            newObj.setWeight(product.getWeight());
            newObj.setPrice(product.getPrice());
            newObj.setPhoto(product.getPhoto());
            return productService.putProduct(newObj);
        }).orElseThrow(() -> new Exception("Product with id " + id + "not found"));
    }



}
