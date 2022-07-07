package com.best.spring.boot.elastic.search.model;

import com.best.spring.boot.elastic.search.config.EsIndex;
import com.best.spring.boot.elastic.search.enums.SexEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

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
