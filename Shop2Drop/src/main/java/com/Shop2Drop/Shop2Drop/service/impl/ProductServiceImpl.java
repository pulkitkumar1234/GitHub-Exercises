package com.Shop2Drop.Shop2Drop.service.impl;

import com.Shop2Drop.Shop2Drop.entity.Product;
import com.Shop2Drop.Shop2Drop.repository.ProductRepository;
import com.Shop2Drop.Shop2Drop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findOne(Long id){
        return productRepository.findOne(id);
    }
}
