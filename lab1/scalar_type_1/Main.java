package com.lab1.scalar_type_1;

public class Main {
    public static void main(String[] args) {
        final int a = 5;
        final int b = inc(a);

        System.out.println("a: " + a + ", b: " + b);
    }

    private static int inc(int x) {
        return x + 1;
    }
}
