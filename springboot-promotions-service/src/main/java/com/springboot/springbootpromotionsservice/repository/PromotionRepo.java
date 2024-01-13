package com.springboot.springbootpromotionsservice.repository;

import com.springboot.springbootpromotionsservice.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Integer> {

}

