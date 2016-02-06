package com.javase8.exercise8;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * User: eugen
 * Date: 08.12.14
 */
public class C8E7 implements WordStore {

    @Test
    @Override
    public void perform() {
        String[] words = {
                "bbb",
                "aaa",
                null,
                "ccc"
        };
        Arrays.sort(words, nullsLast(reverseOrder()));
        assertEquals("ccc", words[0]);
        assertEquals("bbb", words[1]);
        assertEquals("aaa", words[2]);
        assertNull(words[3]);
    }

}
