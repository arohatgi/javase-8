package com.javase8.exercise3;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.function.BooleanSupplier;

/**
 * User: eugen
 * Date: 01.11.14
 */
public class C3E3 implements WordStore {

    @Test(expected = AssertionError.class)
    @Override
    public void perform() {
        assertThat(() -> 2 * 2 == 5);
    }

    public void assertThat(BooleanSupplier assertion) {
        if (!assertion.getAsBoolean()) {
            throw new AssertionError();
        }
    }
}
