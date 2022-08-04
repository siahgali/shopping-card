package com.keep.calm.shopping.customer;

import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.cart.Cart;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class CustomerTest extends TestCase {
    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.CUSTOMER);
    }
    @Test
    public void Should_addCustomerToJsonFile_when_noError(){
        //Initial GIVEN
        Customer customer = buildCustomer();

        //WHEN
        customer.addCustomer();

        //then
        List<Customer> customerList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.CUSTOMER);
        assertEquals(1, customerList.size());

    }

    private Customer buildCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerPhone(" 4169887806");
        customer.setFirstName("simin");
        customer.setLastName("Bigdeli");
        Address buildingAddress = new Address();
        customer.setBillingAddress(buildingAddress);
        Cart cart = new Cart();
        customer.setCart(cart);
        return customer;
    }
}