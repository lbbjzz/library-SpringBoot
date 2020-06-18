package com.zsc.javaee_booktest.repository;

import com.zsc.javaee_booktest.entity.PersistentLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersistentLoginRepository extends JpaRepository<PersistentLogin, String> {
}
