package com.file.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;

/**
 * @author CunLu Wang
 * @since 2022/7/25
 */
public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.setA("a");
        a.setB("b");
        a.setC("c");
        a.setD("d");
        String jsonStr = JSONUtil.toJsonStr(a);
        System.out.println(jsonStr);
        A a1 = BeanUtil.toBean(JSONUtil.parse(jsonStr), A.class);
        System.out.println(a1);
    }
}
