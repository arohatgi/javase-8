package com.javase8.exercise2;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: eugen
 * Date: 30.10.14
 */
public class C2E12 implements WordStore {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        AtomicInteger[] shortWords = new AtomicInteger[12];
        words.parallelStream().forEach(
                w -> {
                    int length = w.length();
                    if (length < 12) {
                        AtomicInteger i = shortWords[length];
                        if (i == null) {
                            i = new AtomicInteger();
                            shortWords[length] = i;
                        }
                        i.incrementAndGet();
                    }
                }
        );
        Arrays.asList(shortWords).forEach(System.out::println);
    }
}
