package com.example.casebe6.models;

import jdk.jfr.Name;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pass;
//    @ManyToOne
//    private Role role;


}
