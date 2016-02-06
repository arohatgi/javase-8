package com.javase8.exercise1;

import com.javase8.WordStore;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * User: eugen
 * Date: 27.10.14
 */
public class C1E2 implements WordStore {

    @Test
    @Override
    public void perform() {
        Arrays.asList(getChildDirsWithLambda(".")).forEach(System.out::println);
        System.out.println("---------------------------------------------");
        Arrays.asList(getChildDirsWithMethodReference(".")).forEach(System.out::println);
    }

    private static File[] getChildDirsWithLambda(String dir) {
        File dirFile = new File(dir);
        return dirFile.listFiles(d -> d.isDirectory());
    }

    private static File[] getChildDirsWithMethodReference(String dir) {
        File dirFile = new File(dir);
        return dirFile.listFiles(File::isDirectory);
    }

}
