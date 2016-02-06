package com.javase8.exercise6;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * User: eugen
 * Date: 30.11.14
 */
public class C6E1 implements WordStore {

    @Test
    @Override
    public void perform() {
        AtomicReference<String> longest = new AtomicReference<>();
        LongAccumulator accumulator = new LongAccumulator(Math::max, 0);
        List<String> words = getWordsAsList();
        words.parallelStream().forEach(
                next -> longest.updateAndGet(
                        current -> {
                            String result = next.length() > accumulator.intValue() ? next : current;
                            accumulator.accumulate(next.length());
                            return result;
                        }));
        System.out.println(longest.get());
    }
}
