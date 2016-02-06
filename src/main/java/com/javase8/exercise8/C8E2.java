package com.javase8.exercise8;

import com.javase8.WordStore;
import org.junit.Test;

/**
 * User: eugen
 * Date: 06.12.14
 */
public class C8E2 implements WordStore {

    @Test(expected = Exception.class)
    @Override
    public void perform() {
        java.lang.Math.negateExact(Integer.MIN_VALUE);
    }
}
