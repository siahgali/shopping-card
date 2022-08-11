package com.keep.calm.shopping.address;

import com.keep.calm.shopping.cart.Cart;
import com.keep.calm.shopping.customer.Customer;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.ADDRESS);
    }

    @Test
    public void should_addAddressToJsonFile_when_noError() throws IOException {
        //Initial GIVEN
        Address address = buildAddress("Montreal");

        //WHEN
        address.addAddress();

        //then
        ArrayList addressList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
        assertEquals(1, addressList.size());

    }

//    @Test
//    public void should_updateAddress() {
//        //Initial GIVEN
//        Address address = buildAddress("Montreal");
//        //WHEN
//        address.addAddress();
//
//        Address addressEntered = buildAddress("Cote saint-luc");
//
//        //address.update("1", addressEntered);
//
//        assertEquals("Cote saint luc", address.getCity());
//
//    }

    private Address buildAddress(String city) {
        Address address = new Address();
        address.setAddress("René-Lévesque");
        address.setAddressId("1");
        address.setCity(city);
        address.setCountry("Canada");
        address.setState("Quebec");

        Address billingAddress = new Address();
        address.setAddress("René-Lévesque");
        address.setAddressId("1");
        address.setCity("Montreal");
        address.setCountry("Canada");
        address.setState("Quebec");


        Cart cart = new Cart();
        cart.setCartId("1");
        cart.setTotalPrice(100d);

        return address;
    }


}