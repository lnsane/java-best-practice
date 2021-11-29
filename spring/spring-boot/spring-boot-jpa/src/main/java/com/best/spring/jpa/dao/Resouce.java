package com.best.spring.jpa.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author 王存露
 */
@Entity
@Table(name = "resouce")
@org.hibernate.annotations.Table(appliesTo = "resouce", comment = "资源表")
public class Resouce {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'")
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.best.spring.jpa.config.JpaIdGen")
    private Long id;


    private String resourceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
}
