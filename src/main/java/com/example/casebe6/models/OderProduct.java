package com.example.casebe6.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class OderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    private int priceAll;
    private String adress;
    private Date date;
    @ManyToOne
    private AppUser appUser;
    @ManyToMany
    private Set<Product> products;
}
