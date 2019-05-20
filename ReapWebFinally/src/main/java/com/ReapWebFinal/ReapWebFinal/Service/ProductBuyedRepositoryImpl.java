package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Cart;
import com.ReapWebFinal.ReapWebFinal.entity.ProductBuyed;
import com.ReapWebFinal.ReapWebFinal.repository.ProductBuyedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductBuyedRepositoryImpl {
    @Autowired
    ProductBuyedRepository productBuyedRepository;

    public List<ProductBuyed> allBuyedProduct(Integer id){
        return productBuyedRepository.findAllByProductOwnerId(id);
    }

    public ProductBuyed saveBuyedProduct(ProductBuyed productBuyed){
       return productBuyedRepository.save(productBuyed);
    }
}
