package com.javase8.exercise5;

import com.javase8.WordStore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * User: eugen
 * Date: 24.11.14
 */
public class C5E5 implements WordStore {

    @Test
    @Override
    public void perform() {
        LocalDate birthday = LocalDate.of(1970, Month.JANUARY, 1);
        System.out.println(birthday.until(LocalDate.now(), ChronoUnit.DAYS));
    }
}
