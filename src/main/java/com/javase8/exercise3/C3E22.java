package com.javase8.exercise3;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: eugen
 * Date: 15.11.14
 */
public class C3E22 implements WordStore {

    @Test
    @Override
    public void perform() {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "1", executor);
        try {
            future.thenApply(Integer::parseInt)                                                //map
                    .thenCompose((a) -> CompletableFuture.supplyAsync(() -> 1 + a, executor))  //flatMap
                    .thenAccept(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
