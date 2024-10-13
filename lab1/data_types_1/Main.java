package com.lab1.data_types_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Object[] array = {
                true,
                "hello",
                5,
                12,
                -200,
                false,
                false,
                "word",
                "A",
                42,
                85,
                "3",
                "&",
                false,
                -151
        };

        Map<String, Integer> typeCount = new HashMap<>();
        typeCount.put("Integer", 0);
        typeCount.put("String", 0);
        typeCount.put("Boolean", 0);

        for (Object element : array) {
            if (element instanceof Integer) {
                typeCount.put("Integer", typeCount.get("Integer") + 1);
            } else if (element instanceof String){
                typeCount.put("String", typeCount.get("String") + 1);
            } else if (element instanceof Boolean){
                typeCount.put("Boolean", typeCount.get("Boolean") + 1);
            }
        }

        System.out.println("Type counts:");
        for (String key : typeCount.keySet()){
            System.out.println(key + ": " + typeCount.get(key));
        }
    }
}
