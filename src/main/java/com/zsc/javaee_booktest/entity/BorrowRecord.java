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
    private int userId;
    private int bookId;
    private Date borrow_date;
    private Date returnDate;
    private int isReturned;
}