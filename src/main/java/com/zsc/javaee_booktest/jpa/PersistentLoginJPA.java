package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.PersistentLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistentLoginJPA extends JpaRepository<PersistentLogin, String> {
}
