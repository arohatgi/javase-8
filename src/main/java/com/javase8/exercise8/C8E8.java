package com.javase8.exercise8;

import com.javase8.WordStore;
import org.junit.Test;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User: eugen
 * Date: 08.12.14
 */
public class C8E8 implements WordStore {

    @Test(expected = ClassCastException.class)
    @Override
    public void perform() {
        Queue<URL> queue = Collections.checkedQueue(new LinkedList<>(), URL.class);
        test(queue);
    }

    @SuppressWarnings("unchecked")
    public void test(Queue queue) {
        queue.add("test");
    }
}
