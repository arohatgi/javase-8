package com.javase8.exercise3;

import com.javase8.WordStore;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * User: eugen
 * Date: 01.11.14
 */
public class C3E2 implements WordStore {

    @Test
    @Override
    public void perform() {
        withLock(new ReentrantLock(), () -> System.out.println("some locked action"));
    }

    public void withLock(ReentrantLock lock, Runnable action){
        lock.lock();
        try {
            action.run();
        } finally {
            lock.unlock();
        }
    }
}
