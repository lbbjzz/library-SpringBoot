package com.zsc.javaee_booktest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_return_record")
public class ReturnRecord {
    @Id
    private int id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private Date return_date;

    @Column(nullable = false)
    private int is_overdue;

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

    public int getIsOverdue() {
        return is_overdue;
    }

    public void setIsOverdue(int is_overdue) {
        this.is_overdue = is_overdue;
    }

    @Override
    public String toString() {
        return "ReturnRecord{" +
                "id = " + id +
                ",userId = " + user_id +
                ",returnDate = " + return_date +
                ",isOverdue = " + is_overdue +
                "}";
    }
}
