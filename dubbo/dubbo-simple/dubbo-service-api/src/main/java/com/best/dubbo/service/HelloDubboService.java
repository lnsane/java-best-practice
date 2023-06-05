package com.best.dubbo.service;


import java.util.List;

public interface HelloDubboService {
    /**
     * 说你好
     *
     * @param name
     * @return
     */
    String sayHello(String name);


    List<String> copyList(List<String> list);

}
