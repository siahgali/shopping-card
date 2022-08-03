package com.keep.calm.shopping.address;

import com.keep.calm.shopping.cart.Cart;
import com.keep.calm.shopping.customer.Customer;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.ADDRESS);
    }

    @Test
    public void should_addAddressToJsonFile_when_noError() {
        //Initial GIVEN
        Address address = buildAddress();

        //WHEN
        address.addAddress();

        //then
        List<Address> addressList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
        assertEquals(1, addressList.size());

    }

    private Address buildAddress() {
        Address address = new Address();
        address.setAddress("René-Lévesque");
        address.setAddressId("1");
        address.setCity("Montreal");
        address.setCountry("Canada");
        address.setState("Quebec");

        Address billingAddress = new Address();
        address.setAddress("René-Lévesque");
        address.setAddressId("1");
        address.setCity("Montreal");
        address.setCountry("Canada");
        address.setState("Quebec");

        Customer customer = new Customer();
        customer.setCustomerId("1");
        customer.setCustomerPhone("514 518 4841");
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(billingAddress);
        customer.setFirstName("Ali");
        customer.setLastName("Siahkali");

        Cart cart = new Cart();
        cart.setCartId("1");
        cart.setTotalPrice(100d);

        customer.setCart(cart);
        address.setCustomer(customer);
        return address;
    }


}