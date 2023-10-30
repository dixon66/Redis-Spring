package com.dix.springredis.service;

import com.dix.springredis.entity.Product;
import com.dix.springredis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findProductById(int id) {
        return productDao.findProductById(id);
    }

    @Override
    public String deleteProduct(int id) {
        return productDao.deleteProduct(id);
    }
}
