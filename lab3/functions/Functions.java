package com.lab3.functions;

import java.lang.reflect.Method;

public class Functions {
    static class Example {
        public int m1(int x) {
            return x;
        }

        public int m2(int x, int y) {
            return x + y;
        }

        public int m3(int x, int y, int z) {
            return x + y + z;
        }
    }


    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static String generateKey(int length, String characters) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++) {
            key.append(characters.charAt(random(0, characters.length())));
        }

        return key.toString();
    }

    public static int ipToInteger(String ipAddress) {
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = "127.0.0.1";
        }

        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid IPv4 address format");
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            int byteValue = Integer.parseInt(parts[i]);
            if (byteValue < 0 || byteValue > 255) {
                throw new IllegalArgumentException("Invalid byte value in IPv4 address");
            }

            result |= byteValue << (8 * (3 - i));
        }

        return result;
    }

    public static void introspect(Object iface) {
        Method[] methods = iface.getClass().getDeclaredMethods();

        for (Method method : methods) {
            System.out.println("Method: " + method.getName() + ", Arguments: " + method.getParameterCount());
        }
    }

    public static void main(String[] args) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println(generateKey(16, characters));

        System.out.println(ipToInteger("192.168.1.10"));

        introspect(new Example());
    }
}
