package com.lab1.data_types_2;

import java.util.Arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
                42.42d,
                85L,
                '3',
                '&',
                false,
                -151.17f
        };

        var typeCount = Arrays.stream(array)
                .collect(groupingBy(o -> o.getClass().getSimpleName(),
                counting()));

        System.out.println("Type counts:");
        System.out.println(typeCount);
    }
}

