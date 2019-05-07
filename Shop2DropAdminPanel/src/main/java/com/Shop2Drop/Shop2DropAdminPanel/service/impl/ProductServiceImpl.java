package com.Shop2Drop.Shop2DropAdminPanel.service.impl;

import com.Shop2Drop.Shop2DropAdminPanel.entity.Product;
import com.Shop2Drop.Shop2DropAdminPanel.repository.ProductRepository;
import com.Shop2Drop.Shop2DropAdminPanel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findOne(Long id){
        return productRepository.findOne(id);
    }
}
