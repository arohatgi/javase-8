package com.javase8.exercise3;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

/**
 * User: eugen
 * Date: 15.11.14
 */
public class C3E24 implements WordStore {

    private class Pair<T> {
        T one;
        T two;

        private Pair(T one, T two) {
            this.one = one;
            this.two = two;
        }

        <U> Pair<U> flatMap(BiFunction<? super T, ? super T, Pair<U>> mapper) {
            return mapper.apply(one, two);
        }
    }

    @Test
    @Override
    public void perform() {
        Pair<String> strPair = new Pair<>("1", "2");
        Pair<Integer> intPair = strPair.flatMap((a, b) -> new Pair<>(Integer.parseInt(a), Integer.parseInt(b)));
        assertEquals(new Integer(1), intPair.one);
        assertEquals(new Integer(2), intPair.two);
    }
}
