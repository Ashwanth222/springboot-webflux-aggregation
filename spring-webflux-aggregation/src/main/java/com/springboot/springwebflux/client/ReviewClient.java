package com.springboot.springwebflux.client;

import com.springboot.springwebflux.model.Review;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewClient {

    private final WebClient client;

    private final Review noReview = new Review("no-review", 0, "no_comment");


    public ReviewClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8090/review-service/review/").build();
    }

    public Mono<List<Review>> getReviews(Integer productId){
        return this.client
                .get()
                .uri("{productId}", productId)
                .retrieve()
              //  .uri(b -> b.queryParam("productId", productId).build())
                .bodyToFlux(Review.class)
                .collectList()
                .onErrorReturn(Collections.emptyList());// in case of error, switch it to empty list
    }

}
