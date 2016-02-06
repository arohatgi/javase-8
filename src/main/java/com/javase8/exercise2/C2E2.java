package com.javase8.exercise2;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.List;

/**
 * User: eugen
 * Date: 28.10.14
 */
public class C2E2 implements WordStore {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        words.stream().filter(s -> s.length() > 12)
                .limit(5).forEach(System.out::println);
    }
}

