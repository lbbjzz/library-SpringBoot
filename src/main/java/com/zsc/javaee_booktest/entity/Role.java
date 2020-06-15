package com.zsc.javaee_booktest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_authority")
public class Role {
    @Id
    private int id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private int authority_id;

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

    public int getAuthorityId() {
        return authority_id;
    }

    public void setAuthorityId(int authority_id) {
        this.authority_id = authority_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id = " + id +
                ",userId = " + user_id +
                ",authorityId = " + authority_id +
                "}";
    }
}
