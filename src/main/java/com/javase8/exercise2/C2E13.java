package com.javase8.exercise2;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * User: eugen
 * Date: 30.10.14
 */
public class C2E13 implements WordStore {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        words.parallelStream()
                .filter(w -> w.length() < 12)
                .collect(groupingBy(String::length, counting()))
                .forEach((k, v) -> System.out.printf("%d - %d\n", k, v));
    }
}
