package com.lab2.Collections;

import java.util.HashMap;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {
        usingArrays();

        usingMap();
    }

    public static void usingArrays() {
        Person[] phoneBook = {
                new Person("dude", 111),
                new Person("ur Mom", 222),
                new Person("doodoo", 333)
        };

        System.out.println(findPhoneByName(phoneBook, "ur Mom") + "\n");
    }

    public static int findPhoneByName(Person[] phoneBook, String name) {
        for (Person person : phoneBook) {
            if (person.name().equals(name)) {
                return person.phone();
            }
        }

        return 0;
    }


    public static void usingMap() {
        Map<String, Integer> phoneBook = new HashMap<>();

        phoneBook.put("dude", 111);
        phoneBook.put("ur Mom", 222);
        phoneBook.put("doodoo", 333);

        System.out.println(findPhoneByName(phoneBook, "ur Mom"));
    }

    public static int findPhoneByName(Map<String, Integer> phoneBook, String name) {
        for (Map.Entry<String, Integer> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue();
            }
        }

        return 0;
    }
}

record Person(String name, int phone) {
}