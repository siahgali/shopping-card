package com.keep.calm.shopping.address;

import com.keep.calm.shopping.cart.Cart;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Before
    public void setUp() {
        JsonHelper.clearJsonFile(JsonFileName.ADDRESS);
    }

 /*  @Test
    public void should_addAddressToJsonFile_when_noError() {
        //Initial GIVEN
        Address address = buildAddress("salam");

        //WHEN
        address.addAddress();
        //address.deleteAddress();

        //then
        List<Address> addressList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
        assertEquals(0, addressList.size());

    }*/

    @Test
    public void should_updateAddress() {
        //Initial GIVEN
        Address address = buildAddress("Montreal");
        Address addressEntered = buildAddress("Toronto");
        //WHEN
        address.addAddress();



        addressEntered.updateAddress();
      //  List<Address> addressList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
     //   assertEquals(2, addressList.size());

        assertEquals("Toronto", address.getCity());

    }


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
        address.setCity(city);
        address.setCountry("Canada");
        address.setState("Quebec");


        Cart cart = new Cart();
        cart.setCartId("1");
        cart.setTotalPrice(100d);

        return address;
    }


}