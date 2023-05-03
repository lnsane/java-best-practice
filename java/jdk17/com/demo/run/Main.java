package com.demo.run;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CunLu Wang
 * @since 2023/3/3
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("123", "222");
        List<String> collect = list.stream().takeWhile(s -> s.contains("1")).collect(Collectors.toList());
        List<String> collect2 = list.stream().dropWhile(s -> s.contains("1")).collect(Collectors.toList());
        boolean b = list.stream().anyMatch(s -> "123".equals(s));
        System.out.println(b);
        System.out.println(collect);
        System.out.println(collect2);
    }
}
