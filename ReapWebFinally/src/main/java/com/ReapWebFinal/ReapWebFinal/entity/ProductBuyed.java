package com.ReapWebFinal.ReapWebFinal.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class ProductBuyed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer productId;
    String productImage;
    @Transient
    MultipartFile multipartProductImageFile;
    String productname;
    Integer pointToRedeem;
    Integer ProductOwnerId;


    public ProductBuyed() {
    }

    public ProductBuyed(Integer id, String productImage, MultipartFile multipartProductImageFile, String productname, Integer pointsRedeemed, Integer productId,Integer productOwnerId) {
        this.id = id;
        this.productImage = productImage;
        this.multipartProductImageFile = multipartProductImageFile;
        this.productname = productname;
        this.pointToRedeem = pointsRedeemed;
        this.productId = productId;
        ProductOwnerId = productOwnerId;
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

    public Integer getPointToRedeem() {
        return pointToRedeem;
    }

    public void setPointToRedeem(Integer pointToRedeem) {
        this.pointToRedeem = pointToRedeem;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getProductOwnerId() {
        return ProductOwnerId;
    }

    public void setProductOwnerId(Integer productOwnerId) {
        ProductOwnerId = productOwnerId;
    }

}
