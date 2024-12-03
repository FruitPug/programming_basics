package com.lab4.iterations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Iterations {
    public static int sumFor(int... args) {
        int result = 0;
        for (int i = 0; i < args.length; i++) {
            result += args[i];
        }
        return result;
    }

    public static int sumForEach(int... args) {
        int result = 0;
        for (int value : args) {
            result += value;
        }
        return result;
    }

    public static int sumWhile(int... args) {
        int result = 0;
        int i = 0;
        while (i < args.length) {
            result += args[i];
            i++;
        }
        return result;
    }

    public static int sumDoWhile(int... args) {
        if (args.length == 0) return 0; // Обработка случая без аргументов
        int result = 0;
        int i = 0;
        do {
            result += args[i];
            i++;
        } while (i < args.length);
        return result;
    }

    public static int sumReduce(int... args) {
        return Arrays.stream(args).reduce(0, Integer::sum);
    }

    public static int max(int[][] array) {
        int maxElement = array[0][0];

        for (int[] row : array) {
            for (int value : row) {
                if (value > maxElement) {
                    maxElement = value;
                }
            }
        }

        return maxElement;
    }

    public static Map<String, Integer> calculateAges(Map<String, Map<String, Integer>> persons) {
        Map<String, Integer> ages = new HashMap<>();

        for (String person : persons.keySet()) {
            Map<String, Integer> lifeSpan = persons.get(person);

            int born = lifeSpan.get("born");
            int died = lifeSpan.get("died");
            ages.put(person, died - born);
        }

        return ages;
    }

    public static void main(String[] args) {
        System.out.println(sumFor(1, 2, 3));
        System.out.println(sumForEach(0));
        System.out.println(sumWhile());
        System.out.println(sumDoWhile(1, -1, 1));
        System.out.println(sumReduce(10, -1, -1, -1));


        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = max(matrix);
        System.out.println("\n" + result);


        Map<String, Map<String, Integer>> persons = new HashMap<>();

        persons.put("lenin", Map.of("born", 1870, "died", 1924));
        persons.put("mao", Map.of("born", 1893, "died", 1976));
        persons.put("gandhi", Map.of("born", 1869, "died", 1948));
        persons.put("hirohito", Map.of("born", 1901, "died", 1989));

        Map<String, Integer> ages = calculateAges(persons);

        System.out.println("\n" + ages);
    }
}
