package com.lab2.loops;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Loops {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(15, 30).toArray();
        System.out.println(Arrays.toString(arr));

        int[] oddArr = IntStream.rangeClosed(15, 30).filter(i -> i % 2 == 1).toArray();
        System.out.println(Arrays.toString(oddArr));
    }
}
