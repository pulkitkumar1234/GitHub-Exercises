package com.ReapWebFinal.ReapWebFinal.Service;

import com.ReapWebFinal.ReapWebFinal.entity.Cart;
import com.ReapWebFinal.ReapWebFinal.exception.GeneralException;
import com.ReapWebFinal.ReapWebFinal.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartRepositoryImpl {
    @Autowired
    CartRepository cartRepository;

    public List<Cart> allProductcCart(Integer id){
        return cartRepository.findAllByCartOwnerId(id);
    }

    public Cart saveToCart(Cart cart)
    {
        return cartRepository.save(cart);
    }


    public Cart findProductInCart(Integer id) throws GeneralException {
        Optional<Cart> cart= cartRepository.findById(id);
        Cart cart1=cart.orElse(null);
        if (cart1==null){
           // throw new GeneralException();
        }
        return cart1;
    }

    public void deleteFromCart(Integer id){
        cartRepository.deleteById(id);
    }
}
