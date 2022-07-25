package com.keep.calm.shopping.product;

public class Product {

    private String productId;

    private String productCategory;

    private String productDescription;

    private String productManufacturer;

    private String productName;

    private double productPrice;

    private String unitStock;

    // Getters and Setter

    public String getProductId() {
        return productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getUnitStock() {
        return unitStock;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setUnitStock(String unitStock) {
        this.unitStock = unitStock;
    }

}
