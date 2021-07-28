package com.best.spring.boot.mongodb.model;

import com.best.spring.boot.mongodb.enums.SexEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 王存露
 */
@Document
public class User {
    @Id
    private String id;
    private String name;
    private SexEnum sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserRepo{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", sex=" + sex + '}';
    }
}
