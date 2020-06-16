package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "pub_house", nullable = false)
    private String pubHouse;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "pub_date", nullable = false)
    private String pubDate;

    @Column(name = "classes")
    private String classes;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cover")
    private String cover;
}