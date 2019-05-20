package com.ReapWebFinal.ReapWebFinal.repository;

import com.ReapWebFinal.ReapWebFinal.entity.Cart;
import com.ReapWebFinal.ReapWebFinal.entity.ProductBuyed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductBuyedRepository extends CrudRepository<ProductBuyed,Integer> {
    List<ProductBuyed> findAllByProductOwnerId(Integer id);
}
