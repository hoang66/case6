package com.example.casebe6.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
