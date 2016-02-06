package com.javase8.exercise5;

import com.javase8.WordStore;
import org.junit.Test;

import java.time.LocalDate;

/**
 * User: eugen
 * Date: 23.11.14
 */
public class C5E2 implements WordStore {

    @Test
    @Override
    public void perform() {
        LocalDate date = LocalDate.of(2000, 2, 29);
        System.out.println(date.plusYears(1));
        System.out.println(date.plusYears(4));
        System.out.println(date.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
    }
}
