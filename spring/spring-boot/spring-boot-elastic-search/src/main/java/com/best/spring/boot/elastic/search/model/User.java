package com.best.spring.boot.elastic.search.model;

import com.best.spring.boot.elastic.search.config.EsIndex;
import com.best.spring.boot.elastic.search.enums.SexEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.Date;

/**
 * @author 王存露
 */
@Document(indexName = EsIndex.INDEX_NAME_MERCURY)
@Setting(replicas = 0)
public class User {
    @Id
    private String id;
    @Field(type = FieldType.Keyword,index = true)
    public String userName;
    @Field(type = FieldType.Keyword)
    public SexEnum sex;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Field(type = FieldType.Date)
    public Date createTime;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Field(type = FieldType.Keyword)
    public Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", sex=" + sex + '}';
    }
}
