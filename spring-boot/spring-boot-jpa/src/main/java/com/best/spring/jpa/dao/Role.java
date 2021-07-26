package com.best.spring.jpa.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 王存露
 */
@Entity
@Table(name = "role")
@org.hibernate.annotations.Table(appliesTo = "role", comment = "123")
public class Role {

    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'")
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.best.spring.jpa.config.JpaIdGen")
    private Long id;


    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, targetEntity = Resouce.class)
    @JoinTable(name = "role_resource", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "resouce_id", referencedColumnName = "id")})
    private Set<Resouce> roleResourceSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
