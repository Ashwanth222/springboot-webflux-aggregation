package com.springboot.springwebflux.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
public class Promotion {

    private String type;
    private Double discount;
    private LocalDate endDate;

}
