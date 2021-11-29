package com.best.spring.boot.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 王存露
 */
@XmlRootElement
public class MyUser {
    private String userName;
    private String age;

    public MyUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
