package com.springboot.springwebflux.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor(staticName = "create")
@Table(name = "tbl_product_aggregate")

public class ProductAggregate {

    private Product product;
    private Promotion promotion;
    private List<Review> reviews;

}
