package com.example.spring_AOP_hw.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column
    private String author;
    @Column(name="publish_year")
    private int publishYear;
}
