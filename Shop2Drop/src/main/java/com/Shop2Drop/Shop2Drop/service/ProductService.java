package com.Shop2Drop.Shop2Drop.service;

import com.Shop2Drop.Shop2Drop.entity.Product;

import java.util.List;

public interface ProductService {
 List<Product> findAll();
 Product findOne(Long id);
}
