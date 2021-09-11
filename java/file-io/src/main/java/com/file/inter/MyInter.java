package com.file.inter;

public interface MyInter extends InterfaceDemo<User, Integer> {
    User saveOne(Integer id);
}
