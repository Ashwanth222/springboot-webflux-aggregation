package com.springboot.springbootreviewservice.controller;

import com.springboot.springbootreviewservice.model.Review;
import com.springboot.springbootreviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping("/addNewReview")
    public String addNewProduct(@RequestBody Review review) {
        return service.addReview(review);
    }


    @GetMapping("/review/{id}")
    private ResponseEntity<Review> getAddressDetails(@PathVariable("id") int id) {
        Review review = service.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(review);
    }

}

