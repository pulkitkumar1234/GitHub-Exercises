package com.Shop2Drop.Shop2Drop.repository;

import com.Shop2Drop.Shop2Drop.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
