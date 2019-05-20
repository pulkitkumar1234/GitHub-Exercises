package com.ReapWebFinal.ReapWebFinal.repository;

import com.ReapWebFinal.ReapWebFinal.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    public List<Cart> findAllByCartOwnerId(Integer id);
}
