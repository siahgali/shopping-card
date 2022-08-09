package com.keep.calm.shopping.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

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
    public static ArrayList convertJsonFileToJavaObject(JsonFileName filename) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList objectList = new ArrayList();
        String filePath = "src/main/resources/json/" + filename.getValue();
        try {
            objectList = mapper.readValue(new File( filePath), ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectList;
    }

//    public static <T> void updateObjectToJsonFile(JsonFileName filename, T javaObject) {
////        ArrayList<T> objectList = JsonHelper.convertJsonFileToJavaObject(filename);
////        Optional<T> objectFound = objectList.stream().filter(obj ->obj.equals(javaObject)).findFirst();
////        objectFound.ifPresent(obFound ->{objectList.remove(objectFound);
////                                            objectList.add(javaObject);});



   // }
    public static <T> void deleteObjectToJsonFile(JsonFileName filename, T javaObject) {
        ArrayList<T> objectList = JsonHelper.convertJsonFileToJavaObject(filename);
        Optional<T> objectFound = objectList.stream().filter(obj ->obj.equals(javaObject)).findFirst();
        objectFound.ifPresent(obFound -> {
            objectList.remove(objectFound);
        });



    }
}
