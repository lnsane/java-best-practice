package com.best.spring.rabbitmq.cq.model;


import com.best.spring.rabbitmq.enums.DemoEnum1;

/**
 * @author 王存露
 */
public class Demo1 {
    private String name;
    private DemoEnum1 demoEnum1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoEnum1 getDemoEnum1() {
        return demoEnum1;
    }

    public void setDemoEnum1(DemoEnum1 demoEnum1) {
        this.demoEnum1 = demoEnum1;
    }

    @Override
    public String toString() {
        return "Demo1{" + "name='" + name + '\'' + ", demoEnum1=" + demoEnum1 + '}';
    }
}
