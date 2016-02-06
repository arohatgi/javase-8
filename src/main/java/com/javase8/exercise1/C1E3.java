package com.javase8.exercise1;

import com.javase8.WordStore;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * User: eugen
 * Date: 27.10.14
 */
public class C1E3 implements WordStore {

    @Test
    @Override
    public void perform() {
        File[] files = list(".", "xml");
        Arrays.asList(files).forEach(System.out::println);
    }

    private static File[] list(String dir, String ext) {
        File dirFile = new File(dir);
        return dirFile.listFiles(f -> f.getName().endsWith(ext));
    }
}
