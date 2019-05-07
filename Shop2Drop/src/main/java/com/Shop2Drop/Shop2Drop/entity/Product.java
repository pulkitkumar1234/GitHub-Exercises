package com.Shop2Drop.Shop2Drop.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; //title
    private String manufacturer; //author
    private String supplier;//publisher
    private String manufacturerDate; //publicationdate
    private String productType; //language
    private String category;
    private int quantityWeight;  //number of pages
    private String ingredientsMaterial; //format
    private int isbn;
    private String shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active=true;

    @Column(columnDefinition = "text")
    private String description;
    private int inStockNumber;
    @Transient
    private MultipartFile productImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getManufacturerDate() {
        return manufacturerDate;
    }

    public void setManufacturerDate(String manufacturerDate) {
        this.manufacturerDate = manufacturerDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantityWeight() {
        return quantityWeight;
    }

    public void setQuantityWeight(int quantityWeight) {
        this.quantityWeight = quantityWeight;
    }

    public String getIngredientsMaterial() {
        return ingredientsMaterial;
    }

    public void setIngredientsMaterial(String ingredentsMaterial) {
        this.ingredientsMaterial = ingredentsMaterial;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(String shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInStockNumber() {
        return inStockNumber;
    }

    public void setInStockNumber(int inStockNumber) {
        this.inStockNumber = inStockNumber;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
