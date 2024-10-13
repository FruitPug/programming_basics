package com.lab1.scalar_type_2;

public class Main {
    public static void main(String[] args) {
        Num obj = new Num(5);
        assert(obj.getNum() == 5);

        inc(obj);

        System.out.println(obj);
    }

    public static void inc(Num obj) {
        obj.setNum(obj.getNum() + 1);
    }
}

class Num {
    private int n;
    public Num(int n) {
        this.n = n;
    }

    public int getNum() {
        return n;
    }

    public void setNum(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "{ n: " + n + " }";
    }
}
