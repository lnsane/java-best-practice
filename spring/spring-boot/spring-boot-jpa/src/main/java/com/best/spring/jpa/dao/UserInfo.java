package com.best.spring.jpa.dao;

import com.best.spring.jpa.enums.SexEnums;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author 王存露
 */
@Entity
public class UserInfo {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'")
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.best.spring.jpa.config.JpaIdGen")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private SexEnums sex;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SexEnums getSex() {
        return sex;
    }

    public void setSex(SexEnums sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
