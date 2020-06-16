package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_return_record")
@Data
public class ReturnRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "is_overdue")
    private int isOverdue;

}
