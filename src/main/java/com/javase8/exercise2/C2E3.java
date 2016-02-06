package com.javase8.exercise2;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * User: eugen
 * Date: 28.10.14
 */
public class C2E3 implements WordStore {

    @Test
    @Override
    public void perform() {
        //It makes no sense - it should be done using a well-developed benchmarking framework
        List<String> words = getWordsAsList();
        long durationSeq = countDuration(words.stream());
        long durationParallel = countDuration(words.parallelStream());
        System.out.printf("Seq: %d - Parallel: %d", durationSeq, durationParallel);
    }

    public long countDuration(Stream<String> stream) {
        long start = System.currentTimeMillis();
        stream.filter(s -> s.length() > 12).count();
        return System.currentTimeMillis() - start;
    }


}
