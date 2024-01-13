package com.springboot.springbootreviewservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tabel_review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;
    private int rating;
    private String comment;

}

