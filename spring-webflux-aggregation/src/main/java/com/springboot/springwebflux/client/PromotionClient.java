package com.springboot.springwebflux.client;

import com.springboot.springwebflux.model.Promotion;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class PromotionClient {

    private final WebClient client;
    private final Promotion noPromotion = new Promotion("no-promotion", 0.0, LocalDate.of(2999, 12, 31));

    public PromotionClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8089/promotion-service/promotion/").build();
    }

    public Mono<Promotion> getPromotion(Integer productId){
        return this.client
                .get()
                .uri("{productId}", productId)
                .retrieve()
                .bodyToMono(Promotion.class)
                .onErrorReturn(noPromotion); // if no result, it returns 404, so switch to no promotion
    }

}
