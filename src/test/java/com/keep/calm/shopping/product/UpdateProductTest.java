package com.keep.calm.shopping.product;

import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.junit.Before;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UpdateProductTest {
    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.PRODUCT);
    }

    @org.junit.Test
    public void should_addProductToJsonFile_when_noError() throws IOException {
        //Initial GIVEN
        Product product = buildProduct("1","laptop");

        //WHEN
        product.addProduct();

        //then
        ArrayList<Product> productList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.PRODUCT);

        assertEquals(1, productList.size());

    }
    @org.junit.Test
    public void should_UpdateProductInJsonFile_when_noError() throws IOException {
        //Initial GIVEN
        Product product1 = buildProduct("1","Laptop");
        //WHEN
        product1.addProduct();

        Product product2 = buildProduct("2","Mouse");
        product2.addProduct();

        //to be updated
        Product product3 = buildProduct("1","Keyboard");
        product3.updateProduct(product3);
        //then
        ArrayList<Product> productList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.PRODUCT);
        assertEquals(2, productList.size());

    }

    public Product buildProduct(String id,String productName) throws IOException {
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(productName);
        product.setProductPrice(1000);
        product.setUnitStock("3");
        product.setProductManufacturer("HP");
        product.setProductCategory("Electronic");
        product.setProductDescription("IT Stuff");
        return product;
    }




}
