package com.ReapWebFinal.ReapWebFinal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    Integer id;
    String ProductName;

    public Product() {
    }

    public Product(Integer id, String productName) {
        this.id = id;
        ProductName = productName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}
