package com.dix.springredis.controller;

import com.dix.springredis.entity.Product;
import com.dix.springredis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return productService.deleteProduct(id);
    }
}
