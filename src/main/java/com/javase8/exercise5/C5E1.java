package com.javase8.exercise5;

import com.javase8.WordStore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static org.junit.Assert.assertEquals;

/**
 * User: eugen
 * Date: 23.11.14
 */
public class C5E1 implements WordStore {

    @Test
    @Override
    public void perform() {
        LocalDate programmersDay = LocalDate.of(2014, Month.JANUARY, 1).plus(Period.ofDays(255));
        assertEquals(13, programmersDay.getDayOfMonth());
        assertEquals(Month.SEPTEMBER, programmersDay.getMonth());
    }
}
