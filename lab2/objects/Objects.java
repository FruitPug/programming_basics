package com.lab2.objects;

public class Objects {
    public static void main(String[] args) {
        nameCheck();

        createUser("Robert", "Massachusetts");
    }

    public static void nameCheck(){
        Variable_name var_name = new Variable_name("Bob");
        Constant_name const_name = new Constant_name("John");

        var_name.setName("Waltah");
        //const_name.setName("Finger"); //cannot assign a value to final variable

        System.out.println(var_name.getName());
        System.out.println(const_name.getName() + "\n");
    }

    public static void createUser(String name, String city){
        User user1 = new User(name, city);

        System.out.println(user1.getName());
        System.out.println(user1.getCity());
    }
}

class Variable_name {
    private String name;
    Variable_name(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Constant_name {
    final private String name;
    Constant_name(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //this won't work
    /*
    public void setName(String name) {
        this.name = name;
    }
     */
}

class User {
    private final String name;
    private final String city;

    User(String name, String city){
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
}