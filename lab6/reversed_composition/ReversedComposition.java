package com.lab6.reversed_composition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

class SafePipe<I, O> {
    private final List<Function<?, ?>> functions = new ArrayList<>();
    private final List<Consumer<Exception>> errorHandlers = new ArrayList<>();

    private SafePipe(Function<?, ?>... args) {

        this.functions.addAll(Arrays.asList(args));
    }

    public static <I, O> SafePipe<I, O> of(Function<?, ?>... args) {
        return new SafePipe<>(args);
    }

    @SuppressWarnings("unchecked")
    public O execute(I input) {
        Object result = input;

        for (int i = functions.size() - 1; i >= 0; i--) {
            Function<Object, Object> function = (Function<Object, Object>) functions.get(i);
            try {
                result = function.apply(result);
            } catch (Exception e) {
                notifyErrorHandlers(e);
                return null;
            }
        }

        return (O) result;
    }

    public void onError(Consumer<Exception> errorHandler) {
        errorHandlers.add(errorHandler);
    }

    private void notifyErrorHandlers(Exception e) {
        for (Consumer<Exception> handler : errorHandlers) {
            handler.accept(e);
        }
    }
}

public class ReversedComposition {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleValue = x -> x * 2;
        Function<Integer, Integer> divideByZero = x -> x / 0;
        Function<Integer, String> stringify = x -> "Result: " + x;

        SafePipe<Integer, String> safePipe = SafePipe.of(stringify, doubleValue, divideByZero);

        safePipe.onError(e -> System.out.println("Error occurred: " + e.getMessage()));

        System.out.println(safePipe.execute(10));
    }
}
