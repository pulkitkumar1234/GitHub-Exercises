package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Cart;
import com.ReapWebFinal.ReapWebFinal.entity.ProductList;
import com.ReapWebFinal.ReapWebFinal.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartRepositoryImpl {
    @Autowired
    CartRepository cartRepository;

    public List<Cart> allProductcCart(){

        Iterable<Cart> cartIterable=cartRepository.findAll();

        List<Cart> cartList=new ArrayList<>();
        for(Cart i: cartIterable)
            cartList.add(i);

        return cartList;
    }
}
