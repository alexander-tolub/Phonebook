package com.alexander.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by alex on 20.01.2017.
 */

@Entity
@Table(name = "role")
public class Role {

    public Role() {
    }

    private Long id;
    private String name;
    private Set<User> userSet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userSet=" + userSet +
                '}';
    }
}
