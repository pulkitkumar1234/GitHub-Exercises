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

    public List<ProductBuyed> allBuyedProduct(){

        Iterable<ProductBuyed> productBuyedIterable=productBuyedRepository.findAll();

        List<ProductBuyed> productBuyeds=new ArrayList<>();
        for(ProductBuyed i: productBuyedIterable)
            productBuyeds.add(i);

        return productBuyeds;

    }
}
