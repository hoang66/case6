package com.example.casebe6.controller;


import com.example.casebe6.models.Product;

import com.example.casebe6.repository.IProductRepo;
import com.example.casebe6.service.classALL.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("page/{page}")
    public ResponseEntity<List<Product>> getAllPro(@PathVariable int page) {
        //Page<Product> pageProducts = productRepo.findAll(pageable);
        return new ResponseEntity<>(productRepo.getAll(PageRequest.of(page - 1, 6)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return new ResponseEntity<>(productRepo.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/editproduct/{id}")
    public ResponseEntity<Product> findByIdPrAdin(@PathVariable long id) {
        return new ResponseEntity<>(productRepo.findById(id).get(), HttpStatus.OK);
    }



    @GetMapping("/catagorie/{id}")
    public ResponseEntity<List<Product>> findAllProductCatagorieByIdname(@PathVariable long id) {
        return new ResponseEntity<>(productRepo.findAllProductCatagorieByIdname(id), HttpStatus.OK);
    }

    @GetMapping("/product/{nameSt}")
    public ResponseEntity<List<Product>> findPostUser(@PathVariable String nameSt) {
        return new ResponseEntity<>(productRepo.findPostUser(nameSt), HttpStatus.OK);
    }

    //tạo sản phẩm
    @PostMapping("/save-product")
    public ResponseEntity<Product> save(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //xóa sản phẩm
    @GetMapping("/delete-product/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    //cập nhật sản phẩm
    @PostMapping("/edit-product")
    public ResponseEntity<Product> edit( @RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


