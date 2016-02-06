package com.javase8.exercise8;

import com.javase8.WordStore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * User: eugen
 * Date: 13.12.14
 */
public class C8E14 implements WordStore {

    @Test(expected = NullPointerException.class)
    @Override
    public void perform() {
        test(null);
    }

    public void test(String a){
        Objects.requireNonNull(a, () -> "[" + LocalDateTime.now() + "]: arg must not be null");
    }
}
