package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_borrow_record")
@Data
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "borrowData")
    private Date borrow_date;

    @Column(name = "returnDate")
    private Date returnDate;
}