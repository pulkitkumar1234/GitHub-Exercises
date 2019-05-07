package com.Shop2Drop.Shop2DropAdminPanel.repository;

import com.Shop2Drop.Shop2DropAdminPanel.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
