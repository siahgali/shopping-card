package com.keep.calm.shopping.product;

import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.PRODUCT);
    }

    @org.junit.Test
    public void should_addProductToJsonFile_when_noError() {
        //Initial GIVEN
        Product product = buildProduct("1","laptop");

        //WHEN
        product.addProduct();

        //then
        List<Product> productList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.PRODUCT);

        assertEquals(1, productList.size());

    }

    public Product buildProduct(String id,String productName){
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
