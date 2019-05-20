package com.ReapWebFinal.ReapWebFinal.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer productId;
    String productImage;
    @Transient
    MultipartFile multipartProductImageFile;
    String productname;
    Integer pointsUsedToRedeem;
    Integer cartOwnerId;


    public Cart() {
    }

    public Cart(Integer id, Integer productId, String productImage, MultipartFile multipartProductImageFile, String productname, Integer pointsUsedToRedeem,Integer cartOwnerId) {
        this.id = id;
        this.productId = productId;
        this.productImage = productImage;
        this.multipartProductImageFile = multipartProductImageFile;
        this.productname = productname;
        this.pointsUsedToRedeem = pointsUsedToRedeem;
        this.cartOwnerId = cartOwnerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        return pointsUsedToRedeem;
    }

    public void setPointsToRedeem(Integer pointsUsedToRedeem) {
        this.pointsUsedToRedeem = pointsUsedToRedeem;
    }
    public Integer getPointsUsedToRedeem() {
        return pointsUsedToRedeem;
    }

    public void setPointsUsedToRedeem(Integer pointsUsedToRedeem) {
        this.pointsUsedToRedeem = pointsUsedToRedeem;
    }

    public Integer getCartOwnerId() {
        return cartOwnerId;
    }

    public void setCartOwnerId(Integer cartOwnerId) {
        this.cartOwnerId = cartOwnerId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", productId=" + productId +
                ", productImage='" + productImage + '\'' +
                ", multipartProductImageFile=" + multipartProductImageFile +
                ", productname='" + productname + '\'' +
                ", pointsUsedToRedeem=" + pointsUsedToRedeem +
                ", cartOwnerId=" + cartOwnerId +
                '}';
    }
}
