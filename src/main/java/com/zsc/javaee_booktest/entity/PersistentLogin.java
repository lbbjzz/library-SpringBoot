package com.zsc.javaee_booktest.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "persistent_logins")
@Data
public class PersistentLogin {
    @Column(name = "username", nullable = false)
    private String username;

    @Id
    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "lastUsed", nullable = false)
    private Date lastUsed;
}