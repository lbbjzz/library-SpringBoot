package com.zsc.javaee_booktest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_book")
public class Book {
    @Id
    private int id;

    @Column(nullable = false)
    private String book_name;

    @Column(nullable = false)
    private String pub_house;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String pub_date;

    @Column(nullable = false)
    private String classes;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String cover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return book_name;
    }

    public void setBookName(String book_name) {
        this.book_name = book_name;
    }

    public String getPubHouse() {
        return pub_house;
    }

    public void setPubHouse(String pub_house) {
        this.pub_house= pub_house;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pub_date;
    }

    public void setPubDate(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id = " + id +
                ",bookName = " + book_name +
                ",pubHouse = " + pub_house +
                ",author = " + author +
                ",pubDate = " + pub_date +
                ",classes = " + classes +
                ",price = " + price +
                ",quantity = " + quantity +
                ",cover = " + cover +
                "}";
    }
}
