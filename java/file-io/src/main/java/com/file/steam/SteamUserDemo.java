package com.file.steam;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamUserDemo {
    public static void main(String[] args) {
        int i = 500;

        List<User> list = new ArrayList<>();
        List<User> list2 = new ArrayList<>();
        while (i > 0) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setAge((int) (Math.random() * 80 - (Math.random() * 40)));
            user.setUserName(UUID.randomUUID().toString().replace("-", ""));
            list.add(user);
            i--;
        }
        while (i < 500) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setAge((int) (Math.random() * 50 - (Math.random() * 10)));
            user.setUserName(UUID.randomUUID().toString().replace("-", ""));
            list2.add(user);
            i++;
        }
        List<User> collect3 = Stream.of(list, list2).flatMap(Collection::stream).collect(Collectors.toList());
        List<Integer> collect1 = collect3.stream().map(User::getAge).collect(Collectors.toList());
        Map<String, List<User>> collect2 = collect3.stream()
                .collect(Collectors.groupingBy(User::getUserName));
        IntStream build2 = IntStream.builder().add(1).build();
        List<User> collect = build2.mapToObj(value -> {
                    User user = new User();
                    user.setId("");
                    user.setUserName("");
                    user.setAge(value);
                    return user;
                })
                .collect(Collectors.toList());
        long start = System.currentTimeMillis();
        System.out.println("time mills start : " + start);
        Arrays.parallelPrefix(new int[2], Integer::sum);
        User anElse = collect3.parallelStream()
                .min(Comparator.comparing(User::getAge))
                .orElse(new User());
        System.out.println("username : " + anElse.getUserName() + "age :" + anElse.getAge());
        System.out.println("time mills end : " + (System.currentTimeMillis() - start));
        long start2 = System.currentTimeMillis();
        System.out.println("time mills start : " + start2);
        User anElse2 = collect3.stream()
                .min(Comparator.comparing(User::getAge))
                .orElse(new User());
        System.out.println("username : " + anElse2.getUserName() + "age :" + anElse2.getAge());
        System.out.println("time mills end : " + (System.currentTimeMillis() - start2));
        Stream<Object> build = Stream.builder().add("1").build();
        Stream<Object> build1 = Stream.builder().add("2").build();
        Stream<Object> concat = Stream.concat(build, build1);
        Stream<Object> empty = Stream.empty();
        Stream<SteamUserDemo> generate = Stream.generate(SteamUserDemo::new);

//        List<User> collect = Stream.of(list, list2).flatMap(Collection::stream).collect(Collectors.toList());
//        System.out.println((long) collect.size());
//
//        List<User> collect1 = collect.stream()
//                .sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge()))
//                .peek(user -> System.out.println(user.getAge()))
//                .collect(Collectors.toList());
//
//        System.out.println(collect.stream().min((o1, o2) -> o2.getAge().compareTo(o1.getAge()))
//                .orElse(new User()).getAge());
//
//        System.out.println("collect mini" + collect.stream()
//                .min(Comparator.comparing(User::getAge))
//                .orElse(new User()).getAge());
//
//        IntSummaryStatistics intSummaryStatistics = collect.stream()
//                .mapToInt(User::getAge)
//                .summaryStatistics();
//        System.out.println(intSummaryStatistics.getSum());
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getCount());
//        System.out.println(intSummaryStatistics.getAverage());
    }
}
