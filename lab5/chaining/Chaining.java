package com.lab5.chaining;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Seq {
    private final List<Function<Double, Double>> functions = new ArrayList<>();

    public Seq(Function<Double, Double> function) {
        functions.add(function);
    }

    public Seq apply (Function<Double, Double> function) {
        functions.add(function);
        return this;
    }

    public double execute (double input) {
        double result = input;
        for (int i = functions.size() - 1; i >= 0; i--) {
            result = functions.get(i).apply(result);
        }

        return result;
    }

    public static Seq seq (Function<Double, Double> function) {
        return new Seq(function);
    }
}

//java doesn't support functional objects, so the task is done using a regular object
class FunctionalArrayObject {
        private final List<String> array = new ArrayList<>();

        public String get(Integer index) {
            if (index >= 0 && index < array.size()) {
                return array.get(index);
            }
            return null;
        }

        public void push(String value) {
            array.add(value);
        }

        public String pop() {
            if (!array.isEmpty()) {
                return array.remove(array.size() - 1);
            }
            return null;
        }
    }


public class Chaining {
    public static void main(String[] args) {
        double result = Seq.seq(x -> x + 1)
                .apply(x -> x * 2)
                .apply(x -> x / 3)
                .apply(x -> x - 4)
                .execute(7);
        System.out.println(result + "\n");


        FunctionalArrayObject arr = new FunctionalArrayObject();

        arr.push("first");
        arr.push("second");
        arr.push("third");

        System.out.println(arr.get(0));
        System.out.println(arr.get(1));
        System.out.println(arr.get(2));

        System.out.println(arr.pop());
        System.out.println(arr.pop());
        System.out.println(arr.pop());

        System.out.println(arr.pop());
    }
}