package com.example.casebe6.controller;


import com.example.casebe6.models.Product;
import com.example.casebe6.repositorys.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin("*")
public class ProductAPI {
    @Autowired
    IProductRepo productRepo;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>((List<Product>) productRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        return new ResponseEntity<>( productRepo.findById(id).get(), HttpStatus.OK);
    }
}
