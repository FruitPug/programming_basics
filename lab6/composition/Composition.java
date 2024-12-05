package com.lab6.composition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class Pipe<I, O> {
    private final List<Function<?, ?>> functions = new ArrayList<>();

    private Pipe(Function<?, ?>... args) {
        validateFunctions(args);
        this.functions.addAll(Arrays.asList(args));
    }

    public static <I, O> Pipe<I, O> of(Function<?, ?>... args) {
        return new Pipe<>(args);
    }

    @SuppressWarnings("unchecked")
    public O execute(I input) {
        Object result = input;
        for (Function<?, ?> f : functions) {
            result = ((Function<Object, Object>) f).apply(result);
        }
        return (O) result;
    }

    private static void validateFunctions(Function<?, ?>... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Pipe must have at least one function");
        }
        for (Function<?, ?> f : args) {
            if (f == null) {
                throw new IllegalArgumentException("All arguments must be valid functions");
            }
        }
    }
}

public class Composition {
    public static void main(String[] args) {
        Function<Integer, Integer> inc = x -> x + 1;
        Function<Integer, Integer> twice = x -> x * 2;
        Function<Integer, Integer> cube = x -> x * x * x;

        Pipe<Integer, Integer> intPipe = Pipe.of(inc, twice, cube);
        System.out.println(intPipe.execute(5));

        Function<String, Integer> length = String::length;
        Function<Integer, Integer> square = x -> x * x;

        Pipe<String, Integer> stringPipe = Pipe.of(length, square);
        System.out.println(stringPipe.execute("hello"));

        Function<String, Integer> parseToInt = s -> Integer.parseInt(s);
        Function<Integer, Double> sqrt = Math::sqrt;

        Pipe<String, Double> mixedPipe = Pipe.of(parseToInt, sqrt);
        System.out.println(mixedPipe.execute("49"));
    }
}
