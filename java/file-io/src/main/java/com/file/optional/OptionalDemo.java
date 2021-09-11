package com.file.optional;

import java.io.IOException;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(8 << 1);
        Integer i = 1;
//        if (i == 1) {
//            System.out.println(0);
//        }
//        if (i == 2) {
//            System.out.println(2);
//        }
        Optional<Object> empty = Optional.empty();
        Optional<Integer> i1 = Optional.ofNullable(i);
        System.out.println(i1.toString());
        if (i1 instanceof Optional<?>) {
            System.out.println(1);
        }
        Optional<Optional<Integer>> i11 = Optional.ofNullable(i1);
        System.out.println(Optional.ofNullable(i11).flatMap(Optional::get)
                .orElseGet(() -> {
                    int t = 0;
                    return t + 1;
                }));
        System.out.println(Optional.ofNullable(i11).flatMap(Optional::get)
                .orElseGet(() -> {
                    int t = 0;
                    return t + 1;
                }));
        String s = Optional.ofNullable(i11)
                .flatMap(Optional::get)
                .filter(integer -> integer.equals(1))
                .map(String::valueOf)
                .orElseThrow(IOException::new);
        System.out.println(s);
        Optional.ofNullable(i11).flatMap(Optional::get)
                .orElseThrow(IOException::new);
        String s1 = Optional.empty().toString();
        System.out.println(s1);
    }
}
