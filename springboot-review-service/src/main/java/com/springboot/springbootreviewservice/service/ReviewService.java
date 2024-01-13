package com.springboot.springbootreviewservice.service;

import com.springboot.springbootreviewservice.model.Review;
import com.springboot.springbootreviewservice.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    public String addReview(Review review) {
        reviewRepo.save(review);
        return "Review Added Successfully";
    }

    public Review findProductById(int id) {
        Optional<Review> product = reviewRepo.findById(id);
        return product.get();
    }

}

