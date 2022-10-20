package com.file.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CunLu Wang
 * @since 2022/9/24
 */
public class SortS {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(User.builder().age(123L).build());
        list.add(User.builder().age(13L).build());
        list.add(User.builder().age(223L).build());
        for (User user : list.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList())) {
            System.out.println(user.getAge());
        }

    }
}
