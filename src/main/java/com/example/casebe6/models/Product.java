package com.example.casebe6.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameSt;
    private String img;
    private int price;
    private boolean status;
    private String description;

}
