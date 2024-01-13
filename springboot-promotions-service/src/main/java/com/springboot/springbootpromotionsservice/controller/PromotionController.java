package com.springboot.springbootpromotionsservice.controller;

import com.springboot.springbootpromotionsservice.model.Promotion;
import com.springboot.springbootpromotionsservice.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService service;

    @PostMapping("/addNewPromotion")
    public String addNewUser(@RequestBody Promotion promotion) {
        return service.addPromotion(promotion);
    }


    @GetMapping("/promotion/{id}")
    private ResponseEntity<Promotion> getAddressDetails(@PathVariable("id") int id) {
        Promotion promotion = service.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(promotion);
    }

}

