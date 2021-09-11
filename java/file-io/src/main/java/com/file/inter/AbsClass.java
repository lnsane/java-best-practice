package com.file.inter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsClass<T, ID> implements InterfaceDemo<T, ID> {
    @Override
    public List<T> save(T name) {
        List<T> list = new ArrayList<>();
        list.add(name);
        return list;
    }
}
