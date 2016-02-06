package com.javase8.exercise3;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * User: eugen
 * Date: 15.11.14
 */
public class C3E17 implements WordStore {

    @Override
    @Test
    public void perform() {
        doInParallelAsync(
                () -> {
                    if (System.currentTimeMillis() % 2 == 1) throw new RuntimeException("Exception in First");
                    else System.out.println("First OK");
                },
                () -> {
                    if (System.currentTimeMillis() % 2 == 1) throw new RuntimeException("Exception in Second");
                    else System.out.println("Second OK");
                },
                (t) -> System.out.println(t.getMessage())
        );
    }

    public void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread t = new Thread() {
            public void run() {
                new Thread(() -> {
                    try {
                        first.run();
                    } catch (Throwable t) {
                        handler.accept(t);
                    }
                }).start();
                new Thread(() -> {
                    try {
                        second.run();
                    } catch (Throwable t) {
                        handler.accept(t);
                    }
                }).start();
            }
        };
        t.start();
    }
}
