package com.javase8.exercise1;

import com.javase8.WordStore;
import org.junit.Test;

/**
 * User: eugen
 * Date: 27.10.14
 */
public class C1E7 implements WordStore {

    @Test
    @Override
    public void perform() {
        new Thread(
                andThen(
                        () -> System.out.println("First"),
                        () -> System.out.println("Second")
                )).start();
    }

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
