package com.springboot.springbootproductservice.controller;

import com.springboot.springbootproductservice.model.Product;
import com.springboot.springbootproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addNewProduct")
    public String addNewUser(@RequestBody Product product) {
        return service.addAddress(product);
    }


    @GetMapping("/product/{id}")
    private ResponseEntity<Product> getAddressDetails(@PathVariable("id") int id) {
        Product product = service.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}

