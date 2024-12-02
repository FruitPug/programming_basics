package com.lab2.functions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Functions {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        var calculate = IntStream.rangeClosed(0, 9)
                .mapToDouble(n ->
                    average(square(n), cube(n)))
                .toArray();

        System.out.println("Average = " + average(a, b));
        System.out.println("Square of a = " + square(a));
        System.out.println("Cube of a = " + cube(a));
        System.out.println("Calculation results = " + Arrays.toString(calculate));
    }

    public static double average(int a, int b) {
        return (a + b) / 2.0;
    }

    public static int square(int n) {
        return n * n;
    }

    public static int cube(int n) {
        return n * n * n;
    }
}
