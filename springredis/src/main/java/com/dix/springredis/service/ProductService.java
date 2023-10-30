package com.dix.springredis.service;

import com.dix.springredis.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findProductById(int id);
    String deleteProduct(int id);
}
