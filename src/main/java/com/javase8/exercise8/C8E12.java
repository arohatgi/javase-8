package com.javase8.exercise8;

import com.javase8.WordStore;
import org.junit.Test;

import java.lang.*;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: eugen
 * Date: 13.12.14
 */
public class C8E12 implements WordStore {

    @Test
    @Override
    public void perform() {
        Class clazz = com.javase8.exercise8.Math.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            TestCase[] testCases = method.getAnnotationsByType(TestCase.class);
            assertTrue(testCases.length > 0);
            for (TestCase testCase : testCases) {
                assertEquals(testCase.expected(), com.javase8.exercise8.Math.factorial(testCase.params()));
            }
        }
    }

}

