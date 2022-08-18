package com.keep.calm.shopping.customer;

import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.cart.Cart;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.CUSTOMER);
    }
    @Test
    public void Should_addCustomerToJsonFile_when_noError(){
        //Initial GIVEN
        Customer customer = buildCustomer("simin");

        //WHEN
        customer.addCustomer();

        //then
        List<Customer> customerList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.CUSTOMER);
        assertEquals(1,customerList.size());


    }


  /*  @Test
    public void Should_updateCustomerToJsonFile_when_noError(){
        //Initial GIVEN
        Customer customer = buildCustomer("Akbar");
       // Customer customer = buildCustomer("Simin");

        //WHEN
        customer.updateCustomer();

        //then
        List<Customer> customerList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.CUSTOMER);
        assertEquals("Akbar",customer.getFirstName());


    }
*/
    private Customer buildCustomer(String name) {
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerPhone(" 4169887806");
        customer.setFirstName(name);
        customer.setLastName("Bigdeli");
        Address buildingAddress = new Address();
        customer.setBillingAddress(buildingAddress);
        customer.setShippingAddress(buildingAddress);
        Cart cart = new Cart();
        cart.setCartId("1");
        cart.setTotalPrice(1000d);

        customer.setCart(cart);
        return customer;
    }
}