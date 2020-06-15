package com.zsc.javaee_booktest.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_authority")
public class Authority {
    @Id
    private int id;

    @Column(nullable = false)
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id = " + id +
                ",authority = " + authority +
                "}";
    }
}
