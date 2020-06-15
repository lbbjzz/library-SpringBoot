package com.zsc.javaee_booktest.jpa;

import com.zsc.javaee_booktest.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJPA extends JpaRepository<Authority, Integer> {
}
