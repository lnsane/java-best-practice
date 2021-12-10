package com.best.java.checker;


import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * @author 王存露
 */
public class MyUtils {
    public static void isNull(@NonNull String checkerString) {
        if (checkerString == null) {
            System.out.println(checkerString);
        }
    }
}
