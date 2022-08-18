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
        Address address1 = buildAddress("Montreal", "1");
        Address address2 = buildAddress("Cote Saint-Luc", "2");

        //WHEN
        address1.addAddress();
        address2.addAddress();

        //then
        List<Address> addressList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
        assertEquals(2, addressList.size());
    }

    @Test
    public void should_deleteAddress_when_callDeleteAddress() {
        //Initial GIVEN
        Address address1 = buildAddress("Montreal", "1");
        Address address2 = buildAddress("Cote Saint-Luc", "2");
        address1.addAddress();
        address2.addAddress();

        //WHEN
        address1.deleteAddress();

        //THEN
        List<Address> addressList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
        assertEquals(1, addressList.size());
    }

    @Test
    public void should_updateAddress_when_callUpdateAddress() {
        //Initial GIVEN
        Address address = buildAddress("Montreal", "1");
        Address addressForUpdate = buildAddress("Cote Saint-Luc", "1");
        address.addAddress();

        //WHEN
        addressForUpdate.updateAddress();

        //THEN
        Address result = JsonHelper.findOneInJsonFile(JsonFileName.ADDRESS, addressForUpdate);
        assertEquals("Cote Saint-Luc", result.getCity());
    }

    private Address buildAddress(String city, String addressId) {
        Address address = new Address();
        address.setAddress("René-Lévesque");
        address.setAddressId(addressId);
        address.setCity(city);
        address.setCountry("Canada");
        address.setState("Quebec");

        return address;
    }


}