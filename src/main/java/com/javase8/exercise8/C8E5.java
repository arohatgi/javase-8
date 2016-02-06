package com.javase8.exercise8;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * User: eugen
 * Date: 08.12.14
 */
public class C8E5 implements WordStore {

    @Test
    @Override
    public void perform() {
        ArrayList<String> words = new ArrayList<>(getWordsAsList());
        words.removeIf(w -> w.length() <= 12);
        assertEquals(33, words.size());
    }
}
