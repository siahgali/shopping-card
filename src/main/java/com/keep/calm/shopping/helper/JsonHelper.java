package com.keep.calm.shopping.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.customer.Customer;
import com.keep.calm.shopping.product.Product;
import com.keep.calm.shopping.user.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonHelper<T> {

    public static <T> void addObjectToJsonFile(JsonFileName filename, T javaObject) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> objectList = new ArrayList<>();
        String filePath = "src/main/resources/json/" + filename.getValue();
        try {
            objectList = mapper.readValue(new File( filePath), ArrayList.class);
            objectList.add(javaObject);
            mapper.writeValue(Paths.get(filePath).toFile(), objectList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void clearJsonFile(JsonFileName filename) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList objectList = new ArrayList<>();
        String filePath = "src/main/resources/json/" + filename.getValue();
        try {
            mapper.writeValue(Paths.get(filePath).toFile(), objectList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static ArrayList convertJsonFileToJavaObject(JsonFileName filename) {
//        ObjectMapper mapper = new ObjectMapper();
//        ArrayList objectList = new ArrayList();
//        String filePath = "src/main/resources/json/" + filename.getValue();
//        try {
//            objectList = mapper.readValue(new File( filePath), ArrayList.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return objectList;
//    }
public static ArrayList convertJsonFileToJavaObject(JsonFileName filename) throws IOException {
    final ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Object> objectList = new ArrayList();
    String filePath = "src/main/resources/json/" + filename.getValue();
    Object[] obj = objectList.toArray(new Object[0]);
    switch(filename) {
        case ADDRESS:
            obj = objectMapper.readValue(new FileReader( filePath),Address[].class);
            break;
        case PRODUCT:
            obj = objectMapper.readValue(new FileReader( filePath),Product[].class);
            break;
        case CUSTOMER:
            obj = objectMapper.readValue(new FileReader( filePath),Customer[].class);
            break;
        case USER:
            obj = objectMapper.readValue(new FileReader( filePath),User[].class);
            break;
        default:
            // code block
    }
    objectList = new ArrayList(Arrays.asList(obj));

    return objectList;
}
}
