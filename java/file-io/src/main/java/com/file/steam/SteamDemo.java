package com.file.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SteamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        int[] ints = list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
        List<Integer> collect = list.stream()
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(Arrays.toString(ints));
        List<Long> collect2 = list.parallelStream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        list.parallelStream()
                .reduce((s, s2) -> s + s2)
                .ifPresent(System.out::println);

        List<String> list2 = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<StringBuilder> collect1 = list2.stream()
                .map(stringBuilder::append)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
