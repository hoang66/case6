package com.example.casebe6.controller;

import com.example.casebe6.models.Catagorie;
import com.example.casebe6.repository.ICatagorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("shop")
@CrossOrigin("*")
public class CatagorieAPI {
    @Autowired
    ICatagorieRepo catagorieRepo;
    @GetMapping
    public ResponseEntity<List<Catagorie>> getAll(){
        return new ResponseEntity<>((List<Catagorie>) catagorieRepo.findAll() , HttpStatus.OK);
    }
}
