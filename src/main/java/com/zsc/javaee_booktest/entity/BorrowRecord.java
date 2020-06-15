package com.zsc.javaee_booktest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_borrow_record")
public class BorrowRecord {
    @Id
    private int id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private Date borrow_date;

    @Column(nullable = false)
    private Date return_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public Date getReturnDate() {
        return return_date;
    }

    public void setReturnDate(Date return_date) {
        this.return_date = return_date;
    }

    public Date getBorrowDate() {
        return borrow_date;
    }

    public void setBorrowDate(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" +
                "id = " + id +
                ",userId = " + user_id +
                ",borrowDate = " + borrow_date +
                ",returnDate = " + return_date +
                "}";
    }
}
