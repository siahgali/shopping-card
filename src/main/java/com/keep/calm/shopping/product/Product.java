package com.keep.calm.shopping.product;

import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.IOException;
import java.util.ArrayList;

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
    public void addProduct() {
        JsonHelper.addObjectToJsonFile(JsonFileName.PRODUCT,this);
    }
    public void deleteProduct() {
        JsonHelper.deleteFromJsonFile(JsonFileName.PRODUCT, this);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Product)) {
            return false;
        }
        Product that = (Product) obj;
        return new EqualsBuilder()
                .append(this.productId, that.productId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.productId).toHashCode();
    }
}
