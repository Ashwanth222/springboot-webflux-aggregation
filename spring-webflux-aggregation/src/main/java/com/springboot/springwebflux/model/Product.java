package com.springboot.springwebflux.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Product {

    private String id;
    private String description;
    private String category;

}
