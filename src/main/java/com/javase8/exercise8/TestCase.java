package com.javase8.exercise8;

import java.lang.annotation.*;

/**
 * User: eugen
 * Date: 13.12.14
 */
@Repeatable(TestCases.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestCase {
    int params();

    int expected();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestCases {
    TestCase[] value();
}

