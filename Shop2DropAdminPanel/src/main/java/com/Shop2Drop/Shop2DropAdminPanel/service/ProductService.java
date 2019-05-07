package com.Shop2Drop.Shop2DropAdminPanel.service;

import com.Shop2Drop.Shop2DropAdminPanel.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findOne(Long id);
}
