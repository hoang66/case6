package com.example.casebe6.controller;

import com.example.casebe6.models.OderProduct;
import com.example.casebe6.service.classALL.OrderProductService;
import com.example.casebe6.service.interfaceALL.IOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
