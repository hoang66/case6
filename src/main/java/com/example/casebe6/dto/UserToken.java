package com.example.casebe6.dto;

import com.example.casebe6.models.Role;

import java.util.Set;

public class UserToken {
    private long id;
    private String name;
    private String token;
    private Set<Role> roles;

    public UserToken() {
    }

    public UserToken(long id, String name, String token, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.token = token;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
