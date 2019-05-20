package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.ProductList;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import com.ReapWebFinal.ReapWebFinal.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductListImpl {
    @Autowired
    ProductListRepository productListRepository;

    public List<ProductList> allProduct(){
        Iterable<ProductList> productIterable=productListRepository.findAll();

        List<ProductList> productLists=new ArrayList<>();
        for(ProductList i: productIterable)
            productLists.add(i);

        return productLists;
    }

    public ProductList findProduct(Integer id) throws GeneralException {
       Optional<ProductList>  productList=productListRepository.findById(id);
       ProductList productList1=productList.orElse(null);
        if (productList1==null){
            //throw new GeneralException();
        }
        return productList1;
    }

    public void save(ProductList productList) {
        productListRepository.save(productList);
    }
}
