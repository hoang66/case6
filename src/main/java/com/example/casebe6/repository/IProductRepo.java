package com.example.casebe6.repository;

import com.example.casebe6.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends CrudRepository<Product, Integer> {
    
}
