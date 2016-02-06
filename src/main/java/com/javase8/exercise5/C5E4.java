package com.javase8.exercise5;

import com.javase8.WordStore;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * User: eugen
 * Date: 23.11.14
 */
public class C5E4 implements WordStore {

    @Test
    @Override
    public void perform() {
        print(11, 2014);
    }

    public void print(int month, int year) {
        LocalDate day = LocalDate.of(year, month, 1);
        if(day.getDayOfWeek() != DayOfWeek.MONDAY) {
            day = day.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        }
        while (day.getMonth().getValue() < month + 1) {
            System.out.print(getDay(day, month));
            if (day.getDayOfWeek() == DayOfWeek.SUNDAY
                    && day.plusDays(1).getMonth().getValue() < month + 1) {
                System.out.println("");
            }
            day = day.plusDays(1);
        }
    }

    private String getDay(LocalDate date, int month) {
        if (date.getMonth().getValue() != month) {
            return "    ";
        }
        return date.getDayOfMonth() < 10
                ? "   " + date.getDayOfMonth()
                : "  " + date.getDayOfMonth();
    }
}
