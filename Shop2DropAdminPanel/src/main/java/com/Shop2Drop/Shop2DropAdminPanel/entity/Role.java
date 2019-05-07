package com.Shop2Drop.Shop2DropAdminPanel.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {

    @Id
    private int roleid;
    private String name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<UserRole> userRoles=new HashSet<>();

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
