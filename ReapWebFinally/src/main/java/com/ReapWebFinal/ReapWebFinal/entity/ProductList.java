package com.ReapWebFinal.ReapWebFinal.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String productImage;
    @Transient
    MultipartFile multipartProductImageFile;
    String productname;
    Integer pointsToRedeem;
    Integer stock;

    public ProductList() {
    }

    public ProductList(Integer id, String productImage, MultipartFile multipartProductImageFile, String productname, Integer pointsToRedeem, Integer stock) {
        this.id = id;
        this.productImage = productImage;
        this.multipartProductImageFile = multipartProductImageFile;
        this.productname = productname;
        this.pointsToRedeem = pointsToRedeem;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public MultipartFile getMultipartProductImageFile() {
        return multipartProductImageFile;
    }

    public void setMultipartProductImageFile(MultipartFile multipartProductImageFile) {
        this.multipartProductImageFile = multipartProductImageFile;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getPointsToRedeem() {
        return pointsToRedeem;
    }

    public void setPointsToRedeem(Integer pointsToRedeem) {
        this.pointsToRedeem = pointsToRedeem;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
