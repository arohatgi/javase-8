package com.javase8.exercise1;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by arohatgi on 2/5/16.
 */
public class C6EExtra01 implements WordStore {

    @Test
    public void perform() {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            repeatMessage("Test ", 100);
            System.out.println("[" + threadName + "]  Done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(text + " ==  " + count);
            for (int i = 0; i < count; i++) {
                System.out.println("[" + threadName + "] - " + text + " " + i);
                Thread.yield();
            }
        };
        r.run();
//        new Thread(r).start();
    }


    @Test
    public void performExecutor() {
        String mainThreadName = Thread.currentThread().getName();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName + " - " + mainThreadName);
        });
    }

    @Test
    public void performExecutorFuture() throws ExecutionException, InterruptedException {
        String mainThreadName = Thread.currentThread().getName();

        Callable<Integer> t = () -> {
            String threadName = Thread.currentThread().getName();
            int count = 100;
            System.out.println("Hello  ==  " + count);
            for (int i = 0; i < count; i++) {
                System.out.println("[" + threadName + "] - " + "text" + " " + i);
                Thread.yield();
            }
            return new Integer(count);
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(t);
        System.out.println("future done? " + future.isDone());

        Integer result = (Integer)future.get();

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);
    }
}
