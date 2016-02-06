package com.javase8.exercise3;

import com.javase8.WordStore;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

/**
 * User: eugen
 * Date: 15.11.14
 */
public class C3E18 implements WordStore {

    @FunctionalInterface
    public interface FunctionThatThrows<T, R> {
        R apply(T t) throws Exception;
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void perform() {
        unchecked((String p) -> Files.readAllBytes(Paths.get(p)).length).apply("/dummy.txt");
    }

    public <T, R> Function<T, R> unchecked(FunctionThatThrows<T, R> f) {
        return (a) -> {
            try {
                return f.apply(a);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
