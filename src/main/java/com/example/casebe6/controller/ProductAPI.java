package com.example.casebe6.controller;


import com.example.casebe6.models.AppUser;
import com.example.casebe6.models.Product;

import com.example.casebe6.repository.IProductRepo;
import com.example.casebe6.service.classALL.ProductService;
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

    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>((List<Product>) productRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return new ResponseEntity<>(productRepo.findById(id).get(), HttpStatus.OK);
    }

    //tạo sản phẩm
    @PostMapping("/save-product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //xóa sản phẩm
    @GetMapping("/delete-product/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    //cập nhật sản phẩm
    @PostMapping("/edit-product")
    public ResponseEntity<Product> edit(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
