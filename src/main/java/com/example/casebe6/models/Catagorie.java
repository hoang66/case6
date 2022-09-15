package com.example.casebe6.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Catagorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
