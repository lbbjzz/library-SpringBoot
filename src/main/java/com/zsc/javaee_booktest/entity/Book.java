package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
@Data
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String pubHouse;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String pubDate;

    private String classes;
    private float price;
    private int quantity;
    private String cover;
}