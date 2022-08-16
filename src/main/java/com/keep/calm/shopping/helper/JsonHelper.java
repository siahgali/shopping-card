package com.keep.calm.shopping.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.customer.Customer;
import com.keep.calm.shopping.product.Product;
import com.keep.calm.shopping.user.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper<T> {

    public static <T> void addObjectToJsonFile(JsonFileName filename, T javaObject) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> objectList;
        String filePath = "src/main/resources/json/" + filename.getValue();
        try {
            objectList = mapper.readValue(new File( filePath), ArrayList.class);
            objectList.add(javaObject);
            mapper.writeValue(Paths.get(filePath).toFile(), objectList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T findOneInJsonFile(JsonFileName fileName, T javaObject) {
        List objectList = JsonHelper.convertJsonFileToJavaObject(fileName);
        return (T) objectList.stream().filter(element -> element.equals(javaObject)).findFirst().get();
    }

    public static void clearJsonFile(JsonFileName fileName) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Object> objectList = new ArrayList<>();
        String filePath = "src/main/resources/json/" + fileName.getValue();
        try {
            mapper.writeValue(Paths.get(filePath).toFile(), objectList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List convertJsonFileToJavaObject(JsonFileName fileName) {
        ObjectMapper mapper = new ObjectMapper();
        List objects = new ArrayList();
        String filePath = "src/main/resources/json/" + fileName.getValue();
        try {
            objects = mapper.readValue(new File( filePath), ArrayList.class);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List objectList = new ArrayList();
        switch (fileName) {
            case ADDRESS: 
                List<Address> addresses = mapper.convertValue(objects, new TypeReference<>() { }); 
                objectList = addresses;
                break;
            case CUSTOMER:
                List<Customer> customers = mapper.convertValue(objects, new TypeReference<>() { });
                objectList = customers;
                break;
            case PRODUCT:
                List<Product> products = mapper.convertValue(objects, new TypeReference<>() { });
                objectList = products;
                break;
            case USER:
                List<User> users = mapper.convertValue(objects, new TypeReference<>() { });
                objectList = users;
                break;

        }
        
        return objectList;
    }

    public static <T> void deleteFromJsonFile(JsonFileName fileName, T item) {
        List<T> objectList = JsonHelper.convertJsonFileToJavaObject(fileName);
        objectList.remove(item);
        JsonHelper.clearJsonFile(fileName);
        objectList.forEach(element -> addObjectToJsonFile(fileName, element));
    }

    public static <T> void updateJsonFile(JsonFileName fileName, T item) {
        List<T> objectList = JsonHelper.convertJsonFileToJavaObject(fileName);
        objectList.remove(item);
        objectList.add(item);
        JsonHelper.clearJsonFile(fileName);
        objectList.forEach(element -> addObjectToJsonFile(fileName, element));
    }
}
