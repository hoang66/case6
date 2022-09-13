package com.example.casebe6.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class OderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  int quantity;
    private int price;
    private int priceAll;
    @ManyToOne
    private User user;
    @ManyToMany
    private Set<Product> products;
}
