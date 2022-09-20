package com.example.casebe6.controller;

import com.example.casebe6.models.OderProduct;
import com.example.casebe6.service.classALL.OrderProductService;
import com.example.casebe6.service.interfaceALL.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OderProductApi {
    @Autowired
    OrderProductService orderProductService;

    @GetMapping("/User/{id}")
    public ResponseEntity<List<OderProduct>> findAllByProductIdUser(@PathVariable int id) {
        return new ResponseEntity<>(orderProductService.findAllProductByIdUser(id), HttpStatus.OK);
    }

    @GetMapping("/User")
    public ResponseEntity<List<OderProduct>> findAll() {
        return new ResponseEntity<>(orderProductService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/saveorder")
    public ResponseEntity<OderProduct> save(@RequestBody OderProduct oderProduct) {
        java.util.Date now = new java.util.Date();
        Timestamp timestamp = new Timestamp(now.getTime());
        OderProduct newOrder = new OderProduct();
        newOrder.setAdress(oderProduct.getAdress());
        newOrder.setPriceAll(oderProduct.getPriceAll());
        newOrder.setQuantity(oderProduct.getQuantity());
        newOrder.setDate(timestamp);
        newOrder.setAppUser(oderProduct.getAppUser());
        newOrder.setProducts(oderProduct.getProducts());

        return new ResponseEntity<>(orderProductService.save(newOrder), HttpStatus.OK);
    }
}
