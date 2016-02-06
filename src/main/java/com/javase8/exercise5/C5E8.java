package com.javase8.exercise5;

import com.javase8.WordStore;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;

/**
 * User: eugen
 * Date: 27.11.14
 */
public class C5E8 implements WordStore {

    @Test
    @Override
    public void perform() {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(id -> now.atZone(ZoneId.of(id)).getOffset())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
