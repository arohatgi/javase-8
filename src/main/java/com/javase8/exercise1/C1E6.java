package com.javase8.exercise1;

import com.javase8.WordStore;
import org.junit.Test;

/**
 * User: eugen
 * Date: 27.10.14
 */
public class C1E6 implements WordStore {

    @Test
    @Override
    public void perform() {
        new Thread(
                uncheck(
                        () -> {
                            System.out.println("Zzz");
                            Thread.sleep(1000);
                        }
                )
        ).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception ignored) {
            }
        };
    }
}

@FunctionalInterface
interface RunnableEx {

    void run() throws Exception;

}
