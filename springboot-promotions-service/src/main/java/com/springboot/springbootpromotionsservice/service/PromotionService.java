package com.springboot.springbootpromotionsservice.service;

import com.springboot.springbootpromotionsservice.model.Promotion;
import com.springboot.springbootpromotionsservice.repository.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepo promotionRepo;

    public String addPromotion(Promotion promotion) {
        promotionRepo.save(promotion);
        return "Promotion Added Successfully";
    }

    public Promotion findProductById(int id) {
        Optional<Promotion> promotion = promotionRepo.findById(id);
        return promotion.get();
    }

}

