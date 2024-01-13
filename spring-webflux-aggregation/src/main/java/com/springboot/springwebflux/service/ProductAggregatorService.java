package com.springboot.springwebflux.service;

import com.springboot.springwebflux.client.ProductClient;
import com.springboot.springwebflux.client.PromotionClient;
import com.springboot.springwebflux.client.ReviewClient;
import com.springboot.springwebflux.model.Product;
import com.springboot.springwebflux.model.ProductAggregate;
import com.springboot.springwebflux.model.Promotion;
import com.springboot.springwebflux.model.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple3;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductAggregatorService {

    private final ProductClient productClient;
    private final PromotionClient promotionClient;
    private final ReviewClient reviewClient;

    public Mono<ProductAggregate> getProduct(Integer productId){
        return Mono.zip(
                        this.productClient.getProduct(productId),
                        this.promotionClient.getPromotion(productId),
                        this.reviewClient.getReviews(productId)
                )
                .map(this::combine);
    }

    private ProductAggregate combine(Tuple3<Product, Promotion, List<Review>> tuple){
        return ProductAggregate.create(
                tuple.getT1(),
                tuple.getT2(),
                tuple.getT3()
        );
    }

}
