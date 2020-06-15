package com.zsc.javaee_booktest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {
    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private Date last_used;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsed() {
        return last_used;
    }

    public void setLastUsed(Date last_used) {
        this.last_used = last_used;
    }

    @Override
    public String toString() {
        return "PersistentLogin{" +
                ",username = " + username +
                ",series = " + series +
                ",token = " + token +
                ",lastUsed = " + last_used +
                "}";
    }
}
